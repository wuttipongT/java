package JUNTRA.map;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import JUNTRA.hero.Hero;
import JUNTRA.hero.ImageSprite;
import JUNTRA.item.CreateITem;
import JUNTRA.item.ITem;
import JUNTRA.maingame.Main_JuntraGame;
import JUNTRA.maingame.MenuFightGame;
import JUNTRA.monster.Monster;

public abstract class Map extends JPanel implements KeyListener{
	Image image;// image วาดแมพ
	Toolkit tk=Toolkit.getDefaultToolkit();////ตัวนี้ไม่ได้ใช้แล้ว  เอาไว้ก่อนเผื่อมีประโยชน์
	String file;//ตัวนี้ไม่ได้ใช้แล้ว  เอาไว้ก่อนเผื่อมีประโยชน์
	int x,y,w=1020,h=527;
	int go1=5;//ระยะขาก้าวเดิน
	int checkX,checkY;//จุดที่ฮีโร่เดินไป
	int checkKEY;//คีย์สำหรับการเปลี่ยน เฟรมซีเค้วน ของฮีโร่

	public Main_JuntraGame mainGame;
	Hero hero;
	
	int level;//เอาไว้ให้แมพ fight เรียกใช้เพราะจะได้สร้าง Mapถูก
	ArrayList <JLabel>parea=new ArrayList<JLabel>();//เก็บพื้นที่ไม่ให้เข้า
	public static ArrayList <Monster>monster;//สำหรับเก็บมอนเต้อเพราะเรานิวหลาย ๆ ตัว (เช็คตาย..และอีกหลายอย่าง)
	
	Monster m;
	Rectangle fightingArea;//พื้นที่การต่อสู้ 
	public  MenuFightGame menuFight;//เป็นคลาสที่ทำงานเกี๋ยวกับโชว์พลัง เวลาที่มีการฆ่ากันพลังมีลด-เพิ่ม พลังที่ดชว์ก็ต้องเปลี่ยนตามปัจจุบัน
	
	CreateITem createitem;//คลาสสร้างไปเท่ม
	public ArrayList <ITem>poweritem=new ArrayList<ITem>();//สำหรับเก็บไอเท่ม
	
	public Map(Main_JuntraGame frame,Hero hero) {
		mainGame=frame;
		menuFight=frame.menuFight;
		setLayout(null);
		this.hero=hero;
		addKeyListener(this);
		setFocusable(true);
		monster=new ArrayList<Monster>();
		createitem=new CreateITem(this,this.hero);
	}
	protected abstract void paintComponent(Graphics g);
	
	public void keyPressed(KeyEvent arg0) {System.out.println("11111");}
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
}