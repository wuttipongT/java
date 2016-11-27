package JUNTRA.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import JUNTRA.hero.Hero;
import JUNTRA.hero.ImageSprite;
import JUNTRA.item.ITem;
import JUNTRA.maingame.Main_JuntraGame;
import JUNTRA.monster.Monster;
import JUNTRA.monster.MonsterLackey_1;
import JUNTRA.monster.MonsterLackey_2;
import JUNTRA.monster.MonsterLackey_3;
import JUNTRA.monster.MonsterLackey_4;
import JUNTRA.monster.Monster_1;
import JUNTRA.powerhero.ControlPowerHeroFight;

public class Map1 extends Map{
	int px,py,pw,ph;
	int gox=820,goy=450,gow=30,goh=45;//set ให้ hero
	int setLo;
	int way=0;
	JLabel lb1,lb2;
	boolean chaeckchon=false;
	public Map1(Main_JuntraGame frame,Hero hero) {
		super(frame,hero);level=1;
		setFocusable(true);
		
		lb1=new JLabel();
		lb2=new JLabel();
		lb1.setBounds(40, 0, 350, 200);
		lb2.setBounds(440,20,200,210);
		parea.add(lb1);parea.add(lb2);
		
		level=1;
		px=0;py=230;pw=800;ph=280;//ข้อความ
		setBounds(x, y, w, h);
		setLayout(null);
		fightingArea=new Rectangle();//ขอบเขตการต่อสู้
		fightingArea.setBounds(gox-100, goy-100,(100*2)+gow, (100*2)+goh);
		for(int i=0;i<3;i++){
			int random=(int)(1+Math.random()*4);
			random=1;//ทดลอง-
			if(random==1){
				m=new MonsterLackey_1(this,hero);
			}
			else if(random==2){
				m=new MonsterLackey_2(this,hero);
			}
			else if(random==3){
				m=new MonsterLackey_3(this,hero);
			}
			else if(random==4){
				m=new MonsterLackey_4(this,hero);
			}
			monster.add(m);
			monster.get(i).setLocationHero(gox, goy);
			m.run();
		}
		createitem.run();
		repaint();
	}
	protected void paintComponent(Graphics g) {
		//super.paintComponents(g);
		image=tk.getImage("images/Map1.jpg");
		g.drawImage(image, x, y, w, h, this);
	}
	public boolean  checkKill(Hero hero){
		Rectangle rh=hero.getBounds();
		Rectangle rm=m.getBoundmonster();
		return rh.intersects(rm);
	}
	public void keyPressed(KeyEvent e){
		int key=e.getKeyCode();
		int pastgox=gox,pastgoy=goy;//เก็บค่าก่อนการเดินแต่ละครั้งเพื่อว่า  ถ้าเดินชนต้นไม้  บ้าน  ก็เอาค่านี้ไปเซตให้ hero เพื่อจะถอยกลับ
		if(monster.size()==0){//เอาไว้ขึ้นคำพูดเมื่อชน
			hero.stop();
			this.removeKeyListener(this);
			mainGame.createMapFight(1,hero);
			createitem.stop();
		}
		if(key==e.VK_SPACE){//ปล่อยพลัง	
			hero.setWAY(way);//ทิศทางที่จะปล่อยพลัง
			ControlPowerHeroFight con=new ControlPowerHeroFight(this,hero);
		}
		checkX=gox;checkY=goy;
		if(checkKEY!=key){
			if(key==e.VK_LEFT){//ซ้าย
				hero.setFrameSequence(way=hero.KEY_LEFT);
				gox+=-go1;
			}
			else if(key==e.VK_RIGHT) {//ขวา
				hero.setFrameSequence(way=hero.KEY_RIGHT);
				gox+=go1;	
			}
			else if(key==e.VK_UP) {
				hero.setFrameSequence(way=hero.KEY_UP);
				goy+=-go1;
			}
			else if(key==e.VK_DOWN) {
				hero.setFrameSequence(way=hero.KEY_DOWN);
				goy+=go1;
			}
		  }
		else if(key==e.VK_G){//กระโดด   
		}
		else if(key==e.VK_F){//กระโดด   
		}
		  else{
				if(key==e.VK_LEFT){gox+=-go1;}
				else if(key==e.VK_RIGHT){gox+=go1;}
				else if(key==e.VK_UP){goy+=-go1;}
				else if(key==e.VK_DOWN){goy+=go1;}	
		  }
		if(gox<0||gox>w-gow||goy<0||goy>h-goh){
			gox=checkX;goy=checkY;
		}
		
		hero.setPosition(gox, goy);
		for(int i=0;i<parea.size();i++){//เชคชน บ้าน ชนก็ถอยกลับ

			Rectangle r=parea.get(i).getBounds();
			Rectangle rhe=hero.getBounds();

			if(r.intersects(rhe)){		
			
				if(gox>pastgox)gox=(pastgox-=10);
				else if(gox<pastgox)gox=(pastgox+=10);
				else gox=pastgox;
				
				if(goy>pastgoy)goy=(pastgoy-=10);
				else if(goy<pastgoy)goy=(pastgoy+=10);
				else goy=pastgoy;
				//gox=pastgox;goy=pastgoy;
	
				hero.setPosition(gox,goy);
			}
			
		}
		fightingArea.setBounds(gox-100, goy-100,(100*2)+gow, (100*2)+goh);//ระยะการต่อสู้
		for(int i=0;i<monster.size();i++){
			monster.get(i).setLocationHero(gox, goy);
			monster.get(i).setfightingArea(fightingArea);
		}
		for(int i=0;i<poweritem.size();i++){//บอกตำแหน่งฮีโร่ให้ ไอเท่มรู้
			ITem con=poweritem.get(i);
			con.setpositionhero(hero);
		}
		checkKEY=key;
	}
}

