package JUNTRA.maingame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import JUNTRA.hero.Hero;

public class MenuITemGame implements MouseListener{//ไอเท่มพวกนี้เป็นไอเท่นที่เล่นไปเก็บไป  
	Main_JuntraGame main;
	Hero hero;
	int size=6;
	int monny;//เงินฮีโร่
	JPanel menuItem;//ใช้แสดง ส่วนของไอเทม
	JPanel menupanel;
	JPanel menugame;// ปุ่มต่าง ๆ (Play , help , Score , Exit)
	
	ImageIcon icon1[]=new ImageIcon[size];
	ImageIcon icon2[]=new ImageIcon[size];
	JLabel bitem[]=new JLabel[size];
	JLabel showvalue[]=new JLabel[size];
	boolean click[]=new boolean[size];//เอาไว้เชค  ย่อรูปขยายรูป
	boolean checkClick[]=new boolean[size];
	
	int Value[]=new int[size];
	boolean checkbuy[]=new boolean[size];//เก็บว่าถูกซื้อหรือยัง
	
	public MenuITemGame(Main_JuntraGame main,Hero hero,JPanel menupanel) {
		this.hero=hero;
		this.main=main;
		for(int i=0;i<icon2.length;i++){
			icon1[i]=new ImageIcon("images/item"+(i+1)+".gif");
			icon2[i]=new ImageIcon("images/item_"+(i+1)+".gif");
			checkClick[i]=false;//เอาไว้เชคปุ่มกดได้หรือไม่ได้  เพราะว่า เลเบลเมื่อเราเซต Ennable มันยังเกิดแอกชั่นอยู่ไม่เหมือนกับ บอทท่อน
		}

		this.menupanel=menupanel;
		createmenuItem();
		int heroproperty=this.hero.getProperty();
		checkHeroBuyITempower(heroproperty);
		System.out.println("heroproperty"+heroproperty);
	}
	public void createmenuItem(){		
		menuItem=new JPanel();
		menuItem.setLayout(null);
		menuItem.setBackground(Color.BLACK);
		menuItem.setBounds(0, 0, 330, 180);
		
		int x=50;
		for(int i=0;i<Value.length;i++){
			Value[i]=(x+=50);
		}
		
		int bW=64,bH=64;
		int bX=15,bY=10;
		for(int i=0;i<bitem.length;i++){
			bitem[i]=new JLabel();
			bitem[i].setIcon(icon1[i]);
			bitem[i].setBounds(bX,bY, bW, bH);
			
			showvalue[i]=new JLabel("$$ "+Value[i]);
			showvalue[i].setForeground(new Color(107,61,61));
			showvalue[i].setBounds(bX+10, bY+bW+5, 50, 10);
			
			bX+=bW+10;
			if((i+1)%4==0){
				bX=15;
				bY+=bH+25;
			}
			//bitem[i].setEnabled(false);//เมื่อเริ่มเล่นก็ยังไม่มีไอเท่มใด ๆ 
			bitem[i].addMouseListener(this);
			menuItem.add(bitem[i]);
			bitem[i].setHorizontalTextPosition(JLabel.CENTER);
			menuItem.add(showvalue[i]);
		}
		menupanel.add(menuItem);	
	}
	public void checkHeroBuyITempower(int property){//มันเป็นการเช็คเงินเพื่อนซื้อไอเท่ม
		monny=property;
		for(int i=0;i<bitem.length;i++){
			if(monny>=Value[i]){
				bitem[i].setEnabled(true);
				checkClick[i]=true;//ถ้า checkClick[i]=true คือซื้อได้
			}
			else if(click[i]!=true){
				bitem[i].setEnabled(false);
				checkClick[i]=false;//ถ้า checkClick[i]=true คือซื้อได้
			}
		}
	}
	public void DIRUBITEM(int typitem){}//พอได้รับไปเท่มก็มาเซตให้ไอเท่มคลิกได้
	public void mousePressed(MouseEvent e) {
		Object sorce=e.getSource();
		for(int i=0;i<bitem.length;i++){
			if(sorce==bitem[i]){
				if(checkClick[i]==true){
					if(click[i]==false){//ซื้อไอเท่ม ย่อรูป
						bitem[i].setIcon(icon2[i]);
						click[i]=true;
						hero.setProperty(-Value[i]);//เสียเงิน
						checkbuy[i]=true;//ซื้อแล้ว
						hero.setpowerhero(i);//ให้ฮีโร่แอดพลังที่รับมา
					}
					else{//ขายไอเท่ม
						bitem[i].setIcon(icon1[i]);
						click[i]=false;
						hero.setProperty(Value[i]/2);//ขายก็ได้เงินครึ่งนึงของราคาที่ซื้อ
						checkClick[i]=false;
						bitem[i].setEnabled(false);
						checkbuy[i]=false;
						hero.removepowerhero(i);
					}
					//-----ต้องทำต่อตรงที่ ไปสั่งให้ฮีโร่ไปสไป้ภาพให้พลังเป็นภาพใหม่ที่เราเลือก---//ก็เพิ่มตรงนี้หล่ะ
				}
			}
		}		
	}
	public void mouseReleased(MouseEvent arg0) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	
}
