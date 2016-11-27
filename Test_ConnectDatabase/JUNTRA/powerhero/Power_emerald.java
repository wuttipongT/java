package JUNTRA.powerhero;

import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

import JUNTRA.hero.Hero;
import JUNTRA.map.Map;
import JUNTRA.monster.Monster;

public class Power_emerald extends Power{
	int mostfar=70;//ระยะที่พลังไปได้ไกลสุด
	public Power_emerald(Map map, Hero hero, int way) {
		super(map, hero, way);
		speed=100;
		this.power=hero.getPower1();
		power.setFrameSequence(2);
		this.power.run();
		this.map.add(this.power);
	}
	public void checkKill() {
		Rectangle powerfight=power.getBounds();
		Rectangle m;
		Monster mon=null;
		int killindex=0;
		boolean kill=false;
		for(int i=0;i<monster.size();i++){
			killindex=i;
			m=monster.get(i).getBoundmonster();
			mon=monster.get(i);
			kill=powerfight.intersects(m);
			if(kill){kill=true;break;}
		}//เพื่อให้ง่ายเวลาเอาไปตรวจสอบ ก็เกตบาวให้เรียบร้อยเลย
		if(kill){
			stop();//พอพลังมาโดนมอนเต้อ พลังก็หายไปเลย  1 ก้อนยิงได้ 1 ตัว
			//----------ดึงค่ามอนเต้อออกมาคำนวนความเสียหาย
			this.monsterdeform=mon.getDeform();
			int powerkill=heroattack-monsterdeform;//พลังที่จะส่งไปฆ่า
			int power=monster.get(killindex).getPowerliving()-powerkill;//คำนวน
			monster.get(killindex).setPowerliving(power);
			if(power<=0){
				Monster mondie=monster.get(killindex);
				mondie.die(mondie);//ส่งตัวมันเองไปตาย
				this.hero.setProperty(10);//ฆ่ามอนเต้อตายก็ได้แต้ม
			}
		}
	}
	public void run() {	
		timer=new Timer();
		timer.schedule(new Running(), 0, speed)	;
	}
	public void stop() {	
		timer.cancel();
		map.remove(power);
		map.repaint();
		speed=100;
	}
	class Running extends TimerTask{
		int far;//ระยะปัจจุบัน
		public void run(){
			far+=2;
			if(way==hero.KEY_DOWN){pointY+=5;}
			else if(way==hero.KEY_UP){pointY-=5;}
			else if(way==hero.KEY_RIGHT){pointX+=5;}
			else if(way==hero.KEY_LEFT){pointX-=5;}
			if(far>=mostfar){stop();}
			checkKill();
			power.setPosition(pointX, pointY);
		}	
	}
}
