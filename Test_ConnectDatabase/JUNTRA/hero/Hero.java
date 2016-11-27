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
	int powerliving;//���ѧ���Ե
	int powerattack;//��С��ѧ������
	int deform;//��һ�ͧ�ѹ
	int property;//���ѵ�
	//--------�ٻẺ��ѧ------
	public final int power_GUN=0;
	public final int power_THUNDERBOLT=1;
	public final int power_fire=2;
	public static int typpower=2;
	//-----------------------
	public static int KEY_DOWN=0;//�Թŧ
	public static int KEY_LEFT=1;//�Թ����
	public static int KEY_RIGHT=2;//�Թ���
	public static int KEY_UP=3;//�Թ���
	public static int KEY_FIGHT=4;//������
	public static int KEY_JUMP=5;//���ⴴ
	int WAY;//��ȷҧ����Թ�  ���������һ���¾�ѧ

	ImageSprite power1,power2;
	public ArrayList indexpower=new ArrayList();//������վ�ѧ�ú�ҧ
	
	Main_JuntraGame main;
	public Hero(String imageFile, int row, int colum, int x, int y, int w, int h) {
		super(imageFile, row, colum, x, y, w, h);
		powerliving=1000;//���ѧ���Ե
		powerattack=30;//��С��ѧ������
		deform=12;//��һ�ͧ�ѹ
		property=100;//���ѵ�
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
	public void setpowerhero(int indexpower){//���;�ѧ���ʹ��ѧ����
		this.indexpower.add(indexpower);
	}
	public void removepowerhero(int indexpower){//������͹�Ѻ�͹�����Ң�¾�ѧ  ��ѧ��ж١ź�
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