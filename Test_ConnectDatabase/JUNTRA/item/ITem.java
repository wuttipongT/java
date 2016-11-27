package JUNTRA.item;

import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import JUNTRA.hero.Hero;
import JUNTRA.map.Map;
import JUNTRA.monster.Monster;

public abstract class ITem extends JLabel implements Runnable{
	Map map;
	Monster monster;
	Hero hero;
	int powertyp;
	
	int powerliving=1;
	int powerattack=2;
	int powerproperty=3;
	
	int mapW;
	int mapH;
	int randomnameitem;
	ImageIcon icon;
	
	Timer timer;
	JLabel itemlabel;
	
	int ranX;
	
	public ITem(Map map,Hero hero,int ranX) {
		this.map=map;
		mapW=map.getWidth();
		mapH=map.getHeight();
		this.hero=hero;
		this.ranX=ranX;
	}
	public abstract void deleatitem();
	public abstract void setpositionhero(Hero hero);
	public abstract void run();
}
