package JUNTRA.powerhero;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import JUNTRA.hero.Hero;
import JUNTRA.hero.ImageSprite;
import JUNTRA.maingame.Main_JuntraGame;
import JUNTRA.map.Map;
import JUNTRA.monster.Monster;

public abstract class Power extends JLabel implements Runnable{
	
	Map map;
	ArrayList <Monster> monster;//เอามาเก็บมอนเต้อไว้สำหรับไปเอาไปเชคชนกับพลัง

	int amountMonster;
	Timer timer;
	Hero hero;
	int speed;

	int pointX;
	int pointY;
	//จุด X.Y ที่จะเริ่มปล่อยพลัง
	int way;//ทิศทางที่พลังจะมุ่งไป
	//ความกว้าง,สูงของรูปภาพเอามาเพื่อคำนวนจุดปล่อยพลัง
	
	ArrayList<Rectangle>mon=new ArrayList<Rectangle>();
	
	int heroliving;//กำลังชีวิต
	int heroattack;//พละกำลังต่อสู้
	int herodeform;//ค่าป้องกัน
	
	int monsterliving;//กำลังชีวิต
	int monsterattack;//พละกำลังต่อสู้
	int monsterdeform;//ค่าป้องกัน
	
	ImageSprite power;
	public Power(Map map,Hero hero,int way){
		this.hero=hero;
		//Rectangle r=monster.get(0).getBounds();
		pointX=this.hero.getX();
		pointY=this.hero.getY();
		this.way=way;
		this.map=map;
		this.monster=map.monster;
		this.heroattack=this.hero.getPowerattack();

	}
	abstract void checkKill();
	abstract public void run();
	abstract public void stop();
}