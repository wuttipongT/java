package JUNTRA.maingame;

import java.awt.Color;
import java.awt.Font;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import JUNTRA.hero.Hero;
import JUNTRA.monster.Monster;

public class MenuFightGame{
	//--------hero
	int heropowerliving;//กำลังชีวิต
	int heropowerattack;//พละกำลังต่อสู้
	int herodeform;//ค่าป้องกัน
	int heroproperty;//สมบัติ

	JProgressBar pheroliving,pheroattack,pherodeform;
	JLabel showproperty=new JLabel();
	
	//--------มอนเต้อ
	int monpowerliving;//กำลังชีวิต
	int monpowerattack;//พละกำลังต่อสู้
	int mondeform;//ค่าป้องกัน
	JProgressBar pmonliving,pmonattack,pmondeform;
	JLabel showmon;
	
	JPanel menupanel;
	JPanel menufight=new JPanel();;//ดู พลัง เวลาต่อสู้
	//ส่วนของ ฮีโร่ และ ,มอนเต้อ
	JPanel herofight;
	JPanel monsterfight;
	
	Hero hero;
	Main_JuntraGame main;
	Monster monster;
	
	String filename="images/defaultImMon.gif";
	
	//-------ค่า default ของพลังต่าง ๆ
	final int defaulthero=0;
	final int defaultmon=0;
	final String defaultfilename="images/defaultImMon.gif";
	
	public MenuFightGame(Main_JuntraGame main,Hero hero,JPanel menupanel) {
		this.main=main;
		this.hero=hero;
		this.menupanel=menupanel;
		
		heropowerliving=this.hero.getPowerliving();
		heropowerattack=this.hero.getPowerattack();
		herodeform=this.hero.getDeform();
		heroproperty=this.hero.getProperty();
		
		menufight.setLayout(null);
		createMenuHero();
		createMenumonster();
		createMenufight();
	}
	public void createlevelpowerMonster(Monster mon,String filename){
		this.filename=filename;
		this.monster=mon;
		monpowerliving=monster.getPowerliving();
		monpowerattack=monster.getPowerattack();
		mondeform=monster.getDeform();
		setPmonliving(monpowerliving);
		setPmonattack(monpowerattack);
		setPmondeform(mondeform);
		setShowimagemonster();
	}
	public void createMenufight(){
		menufight.setBackground(Color.green);
		menufight.setBounds(355, 0, 440, 180);
		menupanel.add(menufight);
	}
	//------ฆ่ามอนเต้อตายแล้ว มอนเต้อก็ต้องมาเซต ค่า default ใหม่ --------------
	public void setToDeaulthonster(){
		monpowerliving=defaultmon;
		monpowerattack=defaultmon;
		mondeform=defaultmon;
		filename=defaultfilename;
		setPmonliving(monpowerliving);
		setPmonattack(monpowerattack);
		setPmondeform(mondeform);
		setShowimagemonster();
	}
	public void createMenuHero(){
		herofight=new JPanel();
		herofight.setLayout(null);
		herofight.setBounds(0, 0, 200, 180);
		herofight.setBackground(Color.BLACK);
		
		ImageIcon icon;
		JLabel showhero=new JLabel();
		int maxliving=hero.maxpowerliving;
		int maxattack=hero.maxpowerattack;
		int maxdefrom=hero.maxdeform;
			
		showhero.setBounds(10,10, 80, 80);
		icon=new ImageIcon("images/Hero_1.jpg");
		showhero.setIcon(icon);
		herofight.add(showhero);
		
		pheroliving=new JProgressBar(0,maxliving);
		pheroliving.setMaximum(maxliving);
		pheroliving.setValue(heropowerliving);
		pheroliving.setStringPainted(true);
		pheroliving.setBounds(10, 100, 150, 15);
		herofight.add(pheroliving);
		
		pheroattack=new JProgressBar(0,maxattack);
		pheroattack.setMaximum(maxattack);
		pheroattack.setValue(heropowerattack);
		pheroattack.setStringPainted(true);
		pheroattack.setBounds(10, 120, 150, 15);
		herofight.add(pheroattack);
		
		pherodeform=new JProgressBar(0,maxdefrom);
		pherodeform.setMaximum(maxdefrom);
		pherodeform.setValue(herodeform);
		pherodeform.setStringPainted(true);
		pherodeform.setBounds(10, 140, 150, 15);
		herofight.add(pherodeform);
		
		showproperty.setText("$$ = "+heroproperty);
		showproperty.setForeground(Color.orange);
		showproperty.setBounds(10,155, 150, 30);
		herofight.add(showproperty);
		
		menufight.add(herofight);
	}
	public void createMenumonster(){
		
		monsterfight=new JPanel();
		monsterfight.setBounds(200, 0, 230, 180);
		monsterfight.setBackground(Color.black);
		monsterfight.setLayout(null);
		
		JLabel word=new JLabel("VS");
		word.setFont(new Font(Font.DIALOG,Font.BOLD,20));
		word.setForeground(Color.red);
		word.setBounds(0, 40, 30, 30);
		monsterfight.add(word);
		
		showmon=new JLabel();
		showmon.setBounds(105, 10, 80, 80);
		ImageIcon icon=new ImageIcon(filename);
		showmon.setIcon(icon);
		monsterfight.add(showmon);
		
		pmonliving=new JProgressBar(0,1000);
		pmonliving.setMaximum(1000);
		pmonliving.setValue(monpowerliving);
		pmonliving.setStringPainted(true);
		pmonliving.setBounds(35, 100, 150, 15);
		monsterfight.add(pmonliving);
		
		pmonattack=new JProgressBar(0,1000);
		pmonattack.setMaximum(1000);
		pmonattack.setValue(monpowerattack);
		pmonattack.setStringPainted(true);
		pmonattack.setBounds(35, 120, 150, 15);
		monsterfight.add(pmonattack);
		
		pmondeform=new JProgressBar(0,1000);
		pmondeform.setMaximum(1000);
		pmondeform.setValue(mondeform);
		pmondeform.setStringPainted(true);
		pmondeform.setBounds(35, 140, 150, 15);
		monsterfight.add(pmondeform);
		
		menufight.add(monsterfight);
		main.repaint();
		
	}
	public void setPheroattack(int attack) {
		this.pheroattack.setValue(attack);
	}
	public void setPherodefrom(int deform) {
		this.pherodeform.setValue(deform);
	}
	public void setPheroliving(int living) {
		this.pheroliving.setValue(living);
	}
	public void setProperty(int property){
		showproperty.setText("$$ = "+property);
	}
	//---------------------------------------------------
	
	public void setPmonattack(int attack) {
		this.pmonattack.setValue(attack);
	}
	public void setPmondeform(int deform) {
		this.pmondeform.setValue(deform);
	}
	public void setPmonliving(int living) {
		this.pmonliving.setValue(living);
	}
	public void setShowimagemonster(){
		ImageIcon icon=new ImageIcon(filename);
		showmon.setIcon(icon);
	}
}