package JUNTRA.powermonster;

import java.util.Timer;

import JUNTRA.hero.Hero;
import JUNTRA.hero.ImageSprite;
import JUNTRA.map.Map;
import JUNTRA.monster.Monster;


public abstract class Fight implements Runnable{
	Monster monster;
	Hero hero;
	Map map;
	
	Timer timer;
	ImageSprite power;
	ImageSprite mon;
	
	String image;
	int pointX;
	int pointY;
	int w,h;
	int way;
	int speed;//ความเร็วของพลังที่พุ่งเข้าใส่ฮีโร่
	
	int herodeform;//ค่าป้องกัน

	int monsterattack;//พละกำลังต่อสู้

	public Fight(Monster monster,Hero hero,Map map,ImageSprite power,ImageSprite sprite) {
			
		this.monster=monster;
		this.hero=hero;
		this.map=map;
		this.power=power;
		mon=sprite;
		int x=this.monster.getX();
		way=this.monster.getWay();
		
		pointX=this.mon.getX();
		pointY=this.mon.getY();
		
		herodeform=this.hero.getDeform();
		monsterattack=this.monster.getPowerattack();
		
	}
	public abstract void run();
	public abstract void stop();
	public abstract void checkKill();
}
