package JUNTRA.item;

import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import JUNTRA.hero.Hero;
import JUNTRA.map.Map;

public class ITem_powerattack extends ITem{

	public ITem_powerattack(Map map, Hero hero, int ranX) {
		super(map, hero, ranX);
		randomnameitem=(int)(1+Math.random()*5);
		icon=new ImageIcon("items/powerattack"+randomnameitem+".png");
		itemlabel=new JLabel(icon);
		map.add(itemlabel);
	}
	public void run() {
		timer=new Timer();
		timer.schedule(new Running(), 0, 500);
	}
	public void setpositionhero(Hero hero) {
		this.hero=hero;
		Rectangle r1=this.hero.getBounds();
		Rectangle r2=itemlabel.getBounds();
		if(r1.intersects(r2)){
			deleatitem();
			this.hero.setPowerattack(5);
			this.hero.setProperty(5);
		}
	}
	public void deleatitem() {
		timer.cancel();
		map.remove(itemlabel);
		map.poweritem.remove(this);
		map.repaint();
	}
	class Running extends TimerTask{
		int x=ranX;
		int y=5;
		int w=48;
		int h=48;
		public void run() {	
			y+=20;
			itemlabel.setBounds(x, y, w, h);
			if(y>=mapH-w){deleatitem();}
		}
	}
}
