package JUNTRA.maingame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import JUNTRA.hero.Hero;
import JUNTRA.hero.ImageSprite;
import JUNTRA.map.Map;
import JUNTRA.map.Map1; 
import JUNTRA.map.Map2;
import JUNTRA.map.Map3;
import JUNTRA.map.Map4;
import JUNTRA.map.Map5;
import JUNTRA.map.Map6;
import JUNTRA.map.Map7;
import JUNTRA.map.MapFight;

public class Main_JuntraGame extends JFrame implements MouseListener,MouseMotionListener{
	Map map;
	
	public int level;
	public static Hero hero;
	
	public static MenuITemGame menuItem;
	public static MenuFightGame menuFight;
	public static MainLogoGame mainlogo;
	Help help;
	ShowScore showScore;
	
	JPanel menupanel;
	
	JPanel pmenuButton;
	JPanel menuButton=new JPanel();
	JLabel buttongame[]=new JLabel[4];
	ImageIcon icon1[]=new ImageIcon[4];
	ImageIcon icon2[]=new ImageIcon[4];
	boolean checkclick[]=new boolean[4];
	JLabel showover=new JLabel();
	ReadAndWriteFile ReadAndWriteFile=new ReadAndWriteFile();;
	
	public Main_JuntraGame() {
		setLayout(null);
		setSize(1025,770);
		mainlogo=new MainLogoGame(this);
		mainlogo.repaint();
		help=new Help();
		createFrame();
	}
	void createFrame(){
		setAlwaysOnTop(true);
		setLocation(0, 0);
		//setUndecorated(true);////////
		//setResizable(false);
		getContentPane().setBackground(Color.black);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void createNewgame(){
		remove(showover);
		menupanel=new JPanel();
		createHero();
		menupanel.setLayout(null);
		createButtonmenu();
		menuItem=new MenuITemGame(this,hero,menupanel);
		menuFight=new MenuFightGame(this,hero,menupanel);
		menupanel.setBackground(Color.BLACK);
		menupanel.setBounds(5, 550, 750, 180);
		add(menupanel);
		map=new Map1(this,hero);
		map.add(hero);
		this.hero.run();
		add(map);
	}
	public void savedata(){//เรียกใช้ตอนจบเกมส์
		int living=hero.getPowerliving();
		int attack=hero.getPowerattack();
		int deform=hero.getDeform();
		int property=hero.getProperty();
		int score=living+attack+deform+property;

		String inputname=JOptionPane.showInputDialog(null,"YOU NAME",
				"input you data",JOptionPane.QUESTION_MESSAGE);
		if(inputname!=null){
			if(inputname.equals("")){}
			else {//บันทึกข้อมูล	
				ReadAndWriteFile.WriteFile(inputname, score);
			}
		}
	}
	public void createHero(){
		hero=new Hero();//สร้าง Hero
		hero.setMaingame(this);
		hero.setFrameSequence(hero.KEY_DOWN);//กำหนดเป็น คีย์เดินหน้า(เดินลง)
	}
	public void say(JLabel l){//เอาไว้เมื่อขึ้นคำพูดของตัวละคร
		l.setOpaque(true);
		l.setHorizontalTextPosition(JLabel.CENTER);
		l.setForeground(Color.pink);
		l.setBackground(Color.green);
		l.setBackground(new Color(0,0,0,10));
		l.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		map.add(l);
		map.repaint();
	}
	public void createButtonmenu(){
		pmenuButton=new JPanel();
		pmenuButton.setLayout(null);
		
		int x=60,y=10,w=85,h=80;
		for(int i=0;i<buttongame.length;i++){
			checkclick[i]=true;
			icon1[i]=new ImageIcon("buttongame2/button"+(i+1)+".png");
			icon2[i]=new ImageIcon("buttongame2/button"+(i+5)+".png");
			buttongame[i]=new JLabel(icon1[i]);
			buttongame[i].setBounds(x, y, w,h);
			x+=100;
			if((i+1)%2==0){x=60;y+=90;}
			pmenuButton.add(buttongame[i]);
			buttongame[i].addMouseListener(this);
			buttongame[i].addMouseMotionListener(this);
		}
		
		pmenuButton.setBackground(Color.BLACK);
		pmenuButton.setBounds(750, 545, 250, 180);
		add(pmenuButton);
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void createMapFight(int level,Hero hero){
		this.hero=hero;
		this.level=level;
		remove(map);
		map=new MapFight(this,this.hero);
		this.hero.setBounds(50, 50, 30, 45);
		map.add(this.hero);
		this.hero.run();//
		add(map);
	}
	public void createMapOvergame(){
		remove(map);
		ImageIcon icon=new ImageIcon("map/gameover.jpg");
		showover.setBounds(0, 0, 1021, 527);
		showover.setIcon(icon);
		add(showover);
	}
	public void createMap(int level,Hero hero){
		this.hero=hero;
		this.level=level;
		remove(map);
		map=new Map2(this,this.hero);
		if(level==2){map=new Map2(this,this.hero);}
		else if(level==3){map=new Map3(this,this.hero);}
		else if(level==4){map=new Map4(this,this.hero);}
		else if(level==5){map=new Map5(this,this.hero);}
		else if(level==6){map=new Map6(this,this.hero);}
		else if(level==7){map=new Map7(this,this.hero);}
		map.add(this.hero);
		this.hero.run();//
		add(map);
	}
	public static void main(String[] args) {
		new Main_JuntraGame();
	}
	public void mousePressed(MouseEvent e) {//ควบ
		Object sorce=e.getSource();
		if(sorce==buttongame[0]){
			remove(map);
			remove(menupanel);
			remove(map);
			remove(pmenuButton);
			createNewgame();
		}
		else if(sorce==buttongame[1]){
			ImageIcon icon=new ImageIcon("");
			int ans=JOptionPane.showConfirmDialog(this, "   Exit Juntra Game", "Exit", JOptionPane.YES_NO_OPTION,0,icon);
			if(ans==JOptionPane.YES_OPTION)System.exit(0);
		}
		else if(sorce==buttongame[2]){
			help.createHelp();
		}
		else if(sorce==buttongame[3]){
			showScore=new ShowScore();
			System.out.println("SSSCORE");
		}
	}
	public void mouseMoved(MouseEvent e) {
		Object sorce=e.getSource();
		for(int i=0;i<buttongame.length;i++){
			if(sorce==buttongame[i]){
				if(checkclick[i]){buttongame[i].setIcon(icon2[i]);checkclick[i]=false;}
				break;
			}
		}
	}
	public void mouseExited(MouseEvent e) {
		Object sorce=e.getSource();
		for(int i=0;i<buttongame.length;i++){
			if(sorce==buttongame[i]){
				buttongame[i].setIcon(icon1[i]);checkclick[i]=true;
				break;
			}
		}
	}
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}
