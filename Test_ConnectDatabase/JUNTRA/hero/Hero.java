package JUNTRA.hero;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import JUNTRA.maingame.Main_JuntraGame;
import JUNTRA.map.Map;

public class Hero extends ImageSprite {
	
	public final int maxpowerliving=1000;
	public final int maxpowerattack=1000;
	public final int maxdeform=1000;
	//***
	int powerliving;//กำลังชีวิต
	int powerattack;//พละกำลังต่อสู้
	int deform;//ค่าป้องกัน
	int property;//สมบัติ
	//--------รูปแบบพลัง------
	public final int power_GUN=0;
	public final int power_THUNDERBOLT=1;
	public final int power_fire=2;
	public static int typpower=2;
	//-----------------------
	public static int KEY_DOWN=0;//เดินลง
	public static int KEY_LEFT=1;//เดินซ้าย
	public static int KEY_RIGHT=2;//เดินขวา
	public static int KEY_UP=3;//เดินขึ้น
	public static int KEY_FIGHT=4;//ต่อสู้
	public static int KEY_JUMP=5;//กระโดด
	int WAY;//ทิศทางที่เดินไป  เอาไปใช้เวลาปล่อยพลัง

	ImageSprite power1,power2;
	public ArrayList indexpower=new ArrayList();//เก็บว่ามีพลังไรบ้าง
	
	Main_JuntraGame main;
	public Hero(String imageFile, int row, int colum, int x, int y, int w, int h) {
		super(imageFile, row, colum, x, y, w, h);
		powerliving=1000;//กำลังชีวิต
		powerattack=30;//พละกำลังต่อสู้
		deform=12;//ค่าป้องกัน
		property=100;//สมบัติ
		createPOwer();
	}
	public Hero(){
		this("images/kanji1.png",4,4,820,450,30,45);	
	}
	public void setMaingame(Main_JuntraGame main){
		this.main=main;
	}
	public void createPOwer(){
		power1=new ImageSprite("powerhero/powerhero1.png",4,4,x,y,w,h);
		power2=new ImageSprite("powerhero/powerhero2.png",4,4,x,y,w,h);
		
	}
	public void setpowerhero(int indexpower){//ซื้อพลังก็แอดพลังเพิ่ม
		this.indexpower.add(indexpower);
	}
	public void removepowerhero(int indexpower){//ก็เหมือนกับตอนที่เราขายพลัง  พลังก็จะถูกลบไป
		this.indexpower.remove(indexpower);
	}
	public ImageSprite getPower1() {
		return power1;
	}
	public ImageSprite getPower2() {
		return power2;
	}
	public  int getTyppower() {
		return typpower;
	}
	public  void setTyppower(int typpower) {
		Hero.typpower = typpower;
	}
	public  int getWAY() {
		return WAY;
	}
	public  void setWAY(int way) {
		WAY = way;
	}
	public int getDeform() {
		return deform;
	}
	public void setDeform(int deform) {
		this.deform = this.deform+deform;
		main.menuFight.setPherodefrom(this.deform);
	}
	public int getPowerattack() {
		return powerattack;
	}
	public void setPowerattack(int powerattack) {
		this.powerattack = this.powerattack+powerattack;
		main.menuFight.setPheroattack(this.powerattack);
	}
	public int getPowerliving() {
		return powerliving;
	}
	public void setPowerliving(int powerliving) {
		this.powerliving = this.powerliving+powerliving;
		main.menuFight.setPheroliving(this.powerliving);
	}
	public int getProperty() {
		return property;
	}
	public void setProperty(int property) {
		this.property = this.property+property;
		main.menuFight.setProperty(this.property);
		main.menuItem.checkHeroBuyITempower(this.property);
	}
}