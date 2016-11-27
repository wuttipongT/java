package JUNTRA.monster;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import JUNTRA.hero.Hero;
import JUNTRA.hero.ImageSprite;
import JUNTRA.map.Map;
import JUNTRA.powermonster.Fight;

public abstract class Monster extends JLabel implements Runnable,KeyListener{

	String file;//ภาพมอนเต้อ
	int x,y,w,h;
	Map map;//พื้นที่เดิน
	ImageSprite sprite;//ตัวมอนเต้อ
	int speed;
	Timer timer;
	int toX,toY,checkX,checkY;
	
	//คีย์ควบคุมการเดิน
	int KEY_DOWN=0;
	int KEY_LEFT=1;
	int KEY_RIGHT=2;
	int KEY_UP=3;
	
	int way;//ทิศทางการเดิน
	
	int powerliving;//กำลังชีวิต
	int powerattack;//พละกำลังต่อสู้
	int deform;//ค่าป้องกัน
	
	JProgressBar  blood;//แสดงขีดเลือด
	Fight fightmonster;
	
	Rectangle fightingArea;//พื้นที่ต่อสู้
	Hero hero;
	ImageSprite power; //พลังสำหรับฆ่า
	String imagepower;//ไฟล์พลัง
	
	public Monster(Map map,Hero hero){
		this.hero=hero;
		this.map=map;
	}
	public abstract void die(Monster monster);
	public abstract void stop();
	public abstract void setLocationHero(int tox,int toy);
	public abstract void setfightingArea(Rectangle fightingArea); 
	public abstract Rectangle getBoundmonster();
	
	public abstract int getWay();
	public abstract int getDeform();
	public abstract void setDeform(int deform);
	public abstract int getPowerattack();
	public abstract void setPowerattack(int powerattack);
	public abstract int getPowerliving();
	public abstract void setPowerliving(int powerliving);
	abstract public void run();
	
	//public abstract boolean checkCillide(JLabel hero,JLabel monster);
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
}