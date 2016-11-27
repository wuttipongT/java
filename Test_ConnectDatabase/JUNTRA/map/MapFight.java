package JUNTRA.map;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import JUNTRA.hero.Hero;
import JUNTRA.hero.ImageSprite;
import JUNTRA.item.ITem;
import JUNTRA.maingame.Main_JuntraGame;
import JUNTRA.monster.Monster_1;
import JUNTRA.monster.Monster_2;
import JUNTRA.monster.Monster_3;
import JUNTRA.monster.Monster_4;
import JUNTRA.monster.Monster_5;
import JUNTRA.monster.Monster_6;
import JUNTRA.monster.Monster_7;
import JUNTRA.powerhero.ControlPowerHeroFight;

public class MapFight extends Map{
	int px,py,pw,ph;
	int gox=820,goy=450,gow=30,goh=45;//set ให้ hero
	int setLo;
	int way=0;
	public MapFight(Main_JuntraGame frame,Hero hero) {
		super(frame,hero);level=1;
		setFocusable(true);
		level=1;
		px=0;py=230;pw=800;ph=280;//ข้อความ
		setBounds(x, y, w, h);
		setLayout(null);
		fightingArea=new Rectangle();//ขอบเขตการต่อสู้
		fightingArea.setBounds(gox-100, goy-100,(100*2)+gow, (100*2)+goh);
		//สร้างหัวหน้าด่านตาม ค่า Level
		level=mainGame.level;
		if(level<=7){
			if(level==1){m=new Monster_1(this,hero);}
			else if(level==2){m=new Monster_2(this,hero);}
			else if(level==3){m=new Monster_3(this,hero);}
			else if(level==4){m=new Monster_4(this,hero);}
			else if(level==5){m=new Monster_5(this,hero);}
			else if(level==6){m=new Monster_6(this,hero);}
			else if(level==7){m=new Monster_7(this,hero);}
			mainGame.menuFight.createlevelpowerMonster(m,"governorMonster/H"+level+".gif");
			monster.add(m);
		}
		monster.get(0).setLocationHero(gox, goy);
		m.run();
		createitem.run();
	}
	protected void paintComponent(Graphics g) {
		//super.paintComponents(g);
		level=mainGame.getLevel();
		image=tk.getImage("images/mapfight"+level+".jpg");
		g.drawImage(image, x, y, w, h, this);
	}
	public boolean  checkKill(Hero hero){
		Rectangle rh=hero.getBounds();
		Rectangle rm=m.getBoundmonster();
		return rh.intersects(rm);
	}
	public void keyPressed(KeyEvent e){
		int key=e.getKeyCode();
		if(monster.size()==0){//เอาไว้ขึ้นคำพูดเมื่อชน
			repaint();
			this.removeKeyListener(this);
			hero.stop();
			if(level+1<=7)mainGame.createMap(level+1,hero);
			mainGame.menuFight.setToDeaulthonster();
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