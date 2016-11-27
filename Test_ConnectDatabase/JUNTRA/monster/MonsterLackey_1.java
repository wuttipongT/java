package JUNTRA.monster;



import java.awt.Color;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

import JUNTRA.hero.Hero;
import JUNTRA.hero.ImageSprite;
import JUNTRA.map.Map;
import JUNTRA.monster.MonsterLackey_4.Running;
import JUNTRA.powermonster.Power_kill;

public class MonsterLackey_1 extends Monster{
	
	public MonsterLackey_1(Map map,Hero hero) {
		super(map,hero);
		
		powerliving=500;
		powerattack=(int)(10+Math.random()*15);
		deform=(int)(2+Math.random()*10);
		speed=(int)(500+Math.random()*800);
		
		w=30;h=45;
		x=(int)(1+Math.random()*700);
		y=(int)(1+Math.random()*500);
		int name=(int)(1+Math.random()*7);
		file="images/mm"+name+".png";
		sprite=new ImageSprite(file,4,4,x,y,w,h);
		sprite.setFrameSequence(KEY_DOWN);
		sprite.run();
		this.map.add(sprite);
		
		imagepower="images/crystal.png";
		power=new ImageSprite(imagepower,4,4,x,y,w,h);
		power.setFrameSequence(1);
		
		blood=new JProgressBar(0,powerliving);
		blood.setMaximum(powerliving);
		blood.setValue(powerliving);
		blood.setStringPainted(true);
		blood.setOpaque(true);
		blood.setBackground(new Color(0,0,225,100));
		blood.setBounds(x, y-35, 100, 15);
		map.add(blood);
		
	}
	public int getWay() {
		return way;
	}
	public int getDeform() {
		return deform;
	}
	public void setDeform(int deform) {
		this.deform = deform;
	}
	public int getPowerattack() {
		return powerattack;
	}
	public void setPowerattack(int powerattack) {
		this.powerattack = powerattack;
	}
	public int getPowerliving() {
		return powerliving;
	}
	public void setPowerliving(int powerliving) {
		this.powerliving = powerliving;
		blood.setValue(this.powerliving);
	}
	public void die(Monster monster){//ถูกเรียกจากคลาสพลัง ของฮีโร่
		Monster mon=monster;
		map.monster.remove(mon);//ลบออกจากลิศด้วย
		map.remove(sprite);
		map.remove(blood);
		timer.cancel();
	}
	public void setOpponent(Hero hero) {//คู่ต่อสู้
		this.hero = hero;
	}
	public boolean  checkKillHero(){//ถ้าเข้าไปในพื้นที่ต้องสู้ก็ต่อสู้
		Rectangle rm=this.getBoundmonster();
		return fightingArea.intersects(rm);
	}
	public void setfightingArea(Rectangle fightingArea){//ถูกเรียกใช้จากแมพ  เวลาคนเดินไปไหนแมพก็จะส่งพื้นที่ต่อสู้มาให้
		this.fightingArea=fightingArea;
		boolean fight=checkKillHero();
		if(fight){
			int i=(int)(1+Math.random()*2);//ให้มอนเต้อแรนดอมว่าจะสู้หรือไม่สู้
			if(i==2){//ถ้าได้ 1 สู้
			fightmonster=new Power_kill(this,hero,map,power,sprite);
			fightmonster.run();
			}
		}//ทำการต่อสู้
	}
	public void setLocationHero(int tox, int toy) {
		this.toX=tox;this.toY=toy;
	}
	public void run() {
		timer=new Timer();
		timer.schedule(new Running(), 0, speed)	;
	}
	public void stop() {
		timer.cancel();	
	}
	public Rectangle getBoundmonster(){
		Rectangle rm=sprite.getBounds();
		return rm;
	}
	class Running extends TimerTask{
		int gonow=5;
		int gonow2=5;
		public void run(){
			
			checkX=x;checkY=y;
			if(toX>x&&toY<y){
				x+=gonow;y-=gonow;
				sprite.setFrameSequence(KEY_UP);
				way=KEY_UP;
			}//ขวาเฉียงบน
			else if(toX>x&&toY>y){
				x+=gonow;y+=gonow;
				sprite.setFrameSequence(KEY_DOWN);
				way=KEY_DOWN;
			}//ขวาเฉียงล่าง
			else if(toX<x&&toY<y){
				x-=gonow;y-=gonow;
				sprite.setFrameSequence(KEY_UP);
				way=KEY_UP;
			}//ซ้ายเฉียงบน
			else if(toX<x&&toY>y){
				x-=gonow;y+=gonow;
				sprite.setFrameSequence(KEY_DOWN);
				way=KEY_DOWN;
			}//ขวาเฉียงล่าง
			else if(toX>x&&toY==y){
				x+=gonow2;
				sprite.setFrameSequence(KEY_LEFT);
				way=KEY_LEFT;
			}//ซ้ายตรง
			else if(toX<x&&toY==y){
				x-=gonow2;
				sprite.setFrameSequence(KEY_RIGHT);
				way=KEY_RIGHT;
			}//ขวาตรง
			else if(toX==x&&toY>y){
				y+=gonow2;
				sprite.setFrameSequence(KEY_DOWN);
				way=KEY_DOWN;
			}//ล่าง
			else if(toX==x&&toY<y){
				y-=gonow2;
				sprite.setFrameSequence(KEY_UP);
				way=KEY_UP;
			}//บน
		
			//ตรงนี้ไม่เกี่ยวกับการเดินแต่เอามาเชคหันซ้ายขวา เฉย ๆๆ เพื่อเอาไปหันมอนเต้อหันหน้ามาหาเรา
			if(toY>y-100&&toY<y+100+h&&toX>=x){
				sprite.setFrameSequence(KEY_RIGHT);
				way=KEY_RIGHT;
			}
			else if(toY>y-50&&toY<y+50+h&&toX<=x){
				sprite.setFrameSequence(KEY_LEFT);
				way=KEY_LEFT;
			}
			sprite.setPosition(x, y);
			blood.setBounds(x, y-20, 100, 15);
			power.setLocation(x, y);
			//ต้องเซตโลเคชั่นที่มอนเต้อเดินไปด้วยเพราะเวลามอนเต้อเริ่มปล่อยพลังจะได้จุดเริ่มปล่อยที่ถูก
		}
	}


}
