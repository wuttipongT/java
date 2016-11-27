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
	ArrayList <Monster> monster;//��������͹����������Ѻ�����ત���Ѻ��ѧ

	int amountMonster;
	Timer timer;
	Hero hero;
	int speed;

	int pointX;
	int pointY;
	//�ش X.Y �������������¾�ѧ
	int way;//��ȷҧ����ѧ������
	//�������ҧ,�٧�ͧ�ٻ�Ҿ��������ͤӹǹ�ش����¾�ѧ
	
	ArrayList<Rectangle>mon=new ArrayList<Rectangle>();
	
	int heroliving;//���ѧ���Ե
	int heroattack;//��С��ѧ������
	int herodeform;//��һ�ͧ�ѹ
	
	int monsterliving;//���ѧ���Ե
	int monsterattack;//��С��ѧ������
	int monsterdeform;//��һ�ͧ�ѹ
	
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