package JUNTRA.map;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import JUNTRA.hero.Hero;
import JUNTRA.hero.ImageSprite;
import JUNTRA.item.CreateITem;
import JUNTRA.item.ITem;
import JUNTRA.maingame.Main_JuntraGame;
import JUNTRA.maingame.MenuFightGame;
import JUNTRA.monster.Monster;

public abstract class Map extends JPanel implements KeyListener{
	Image image;// image �Ҵ���
	Toolkit tk=Toolkit.getDefaultToolkit();////��ǹ�������������  �������͹�����ջ���ª��
	String file;//��ǹ�������������  �������͹�����ջ���ª��
	int x,y,w=1020,h=527;
	int go1=5;//���Тҡ����Թ
	int checkX,checkY;//�ش���������Թ�
	int checkKEY;//��������Ѻ�������¹ �������ǹ �ͧ�����

	public Main_JuntraGame mainGame;
	Hero hero;
	
	int level;//������������ fight ���¡�����Ш������ҧ Map�١
	ArrayList <JLabel>parea=new ArrayList<JLabel>();//�纾�鹷�����������
	public static ArrayList <Monster>monster;//����Ѻ���͹���������ҹ������ � ��� (�礵��..����ա�������ҧ)
	
	Monster m;
	Rectangle fightingArea;//��鹷���õ����� 
	public  MenuFightGame menuFight;//�繤��ʷ��ӧҹ����ǡѺ����ѧ ���ҷ���ա�æ�ҡѹ��ѧ��Ŵ-���� ��ѧ��贪����ͧ����¹����Ѩ�غѹ
	
	CreateITem createitem;//�������ҧ����
	public ArrayList <ITem>poweritem=new ArrayList<ITem>();//����Ѻ�������
	
	public Map(Main_JuntraGame frame,Hero hero) {
		mainGame=frame;
		menuFight=frame.menuFight;
		setLayout(null);
		this.hero=hero;
		addKeyListener(this);
		setFocusable(true);
		monster=new ArrayList<Monster>();
		createitem=new CreateITem(this,this.hero);
	}
	protected abstract void paintComponent(Graphics g);
	
	public void keyPressed(KeyEvent arg0) {System.out.println("11111");}
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
}