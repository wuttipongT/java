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
import JUNTRA.powermonster.Power_kill;


public class Monster_4 extends Monster{
	
	public Monster_4(Map map,Hero hero) {
		super(map,hero);
		
		
		powerliving=1000;
		powerattack=(int)(15+Math.random()*30);
		deform=(int)(10+Math.random()*20);
		speed=(int)(300+Math.random()*500);
		
		x=20;y=300;w=80;h=96;

		file="governorMonster/Hmon4.png";
		sprite=new ImageSprite(file,4,4,x,y,w,h);
		sprite.setFrameSequence(KEY_RIGHT);
		sprite.run();
		this.map.add(sprite);
		imagepower="images/crystal.png";
		power=new ImageSprite(imagepower,4,4,x,y,w,h);
		power.setFrameSequence(1);
	}
	public int getWay() {
		return way;
	}
	public int getDeform() {
		return deform;
	}
	public void setDeform(int deform) {
		this.deform = deform;
		map.mainGame.menuFight.setPmondeform(this.deform);
	}
	public int getPowerattack() {
		return powerattack;
	}
	public void setPowerattack(int powerattack) {
		this.powerattack = powerattack;
		map.mainGame.menuFight.setPheroattack(this.powerattack);
	}
	public int getPowerliving() {
		return powerliving;
	}
	public void setPowerliving(int powerliving) {
		this.powerliving = powerliving;
		map.mainGame.menuFight.setPmonliving(this.powerliving);
	}
	public void die(Monster monster){//ถูกเรียกจากคลาสพลัง ของฮีโร่
		Monster mon=monster;
		map.monster.remove(mon);//ลบออกจากลิศด้วย
		map.remove(sprite);
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
			power.setLocation(x, y);
			//ต้องเซตโลเคชั่นที่มอนเต้อเดินไปด้วยเพราะเวลามอนเต้อเริ่มปล่อยพลังจะได้จุดเริ่มปล่อยที่ถูก
		}
	}
}
