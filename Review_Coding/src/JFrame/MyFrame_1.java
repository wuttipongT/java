package JFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MyFrame_1 extends JFrame implements ActionListener{

	/**
	 * @param args
	 */
	public MyFrame_1(){
		setSize(400,400);
		setLocation(40,50);
		setTitle("MyFrame_1");
		setVisible(true);//�������ʴ��Ż���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�Դ�������á�÷ӧҹ
		//-DO_NOTHING_ON_CLOSE ����ͧ������Դ���
		//-HIDE_ON_CLOSE ��͹����ʴ��������ѧ
		//-DISPOSE_ON_CLOSE �Դ�����������ѧ��診��÷ӧҹ
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame_1 gui = new MyFrame_1();
		gui.setIconImage(null);//��˹��ٻ�Ҿ icon �ͧ Frame
		gui.setResizable(true); //Frame can resize (���¹��Ҵ)-true&false
		gui.getContentPane().setBackground(Color.cyan);//��˹�׾����ѧ�ͧ Frame
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
