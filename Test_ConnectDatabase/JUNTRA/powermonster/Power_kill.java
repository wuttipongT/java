package JUNTRA.powermonster;

import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Spring;

import JUNTRA.hero.Hero;
import JUNTRA.hero.ImageSprite;
import JUNTRA.map.Map;
import JUNTRA.monster.Monster;

public class Power_kill extends Fight{
	
	public Power_kill(Monster monster, Hero hero,Map map,ImageSprite power,ImageSprite sprite) {
		super(monster, hero,map,power,sprite);
		speed=100;
		this.map.add(power);
		this.power.run();
	}
	public void run() {	
		timer=new Timer();
		timer.schedule(new Running(), 0, speed)	;
	}
	public void stop() {	
		timer.cancel();
		map.remove(power);
		map.repaint();
	}
	public void checkKill() {
		Rectangle rmonpower=power.getBounds();
		Rectangle rhero=hero.getBounds();
		if(rmonpower.intersects(rhero)){
			int powerKill=monsterattack-herodeform;
			if(powerKill>0){
				powerKill*=-1;
				hero.setPowerliving(powerKill);
				int a=hero.getPowerliving();
				if(a<=0){
					hero.stop();
					map.mainGame.createMapOvergame();//Over
				}//hero ตาย
			}
		}
	}
	class Running extends TimerTask{
		int mostfar=70;//ระยะที่พลังไปได้ไกลสุด
		int far;//ระยะปัจจุบัน
		boolean checkkill;
		public void run(){
			far+=5;
			if(way==hero.KEY_DOWN){pointY+=5;}
			else if(way==hero.KEY_UP){pointY-=5;}
			else if(way==hero.KEY_RIGHT){pointX+=5;}
			else if(way==hero.KEY_LEFT){pointX-=5;}
			if(far>=mostfar){stop();}
			power.setPosition(pointX, pointY);
			checkKill();
		}	
	}
}
