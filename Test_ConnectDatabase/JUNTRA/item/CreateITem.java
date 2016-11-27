package JUNTRA.item;

import java.util.Timer;
import java.util.TimerTask;

import JUNTRA.hero.Hero;
import JUNTRA.map.Map;

public class CreateITem implements Runnable{
	
	Map map;
	Hero hero;
	Timer timer;
	ITem item;
	public CreateITem(Map map,Hero hero) {
		this.map=map;
		this.hero=hero;
	}
	public void stop(){
		timer.cancel();
	}
	public void run() {
		timer=new Timer();
		timer.schedule(new Running(), 0, 10000);//100000 พอดี
	}
	class Running extends TimerTask{
		int randomitemtyp;
		int ranX;
		int ranY;
		int mapW=map.getWidth();
		int mapH=map.getWidth();
		public void run() {	
			randomitemtyp=(int)(1+Math.random()*3);
			ranX=(int)(5+Math.random()*(mapW-48));
			ranY=(int)(5+Math.random()*(mapH-48));
			if(randomitemtyp==1){
				item=new ITem_powerliving(map,hero,ranX);
			}
			else if(randomitemtyp==2){
				item=new ITem_powerattack(map,hero,ranX);
			}
			else if(randomitemtyp==3){
				item=new ITem_powerproperty(map,hero,ranX);
			}
			map.poweritem.add(item);
			item.run();
		}
	}
}
