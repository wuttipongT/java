import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class jframe extends JFrame {

	private JButton btnHi;
	private JPanel jp;
	jframe(){
		setTitle("Buttons"); 
		jp = new JPanel();
		BH bh = new BH(); 
		btnHi = new JButton("Click Me");
		jp.add(btnHi);
		btnHi.addActionListener(bh);
		
		getContentPane().add(jp);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf = new jframe();
		jf.setSize(500,500);
		jf.setVisible(true);
	}
	
	class BH implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Object ob = arg0.getSource();
			if(ob == btnHi){
				JFrame jf = new jframe2();
				JDialog dialog = new JDialog(jf);
		        dialog.setTitle("Dialog created without extending JDialog class.");
		        dialog.setSize(new Dimension(500, 500));
		        dialog.setLocationRelativeTo(jf);
		        dialog.setModal(true);
		        dialog.setVisible(true);
				//jf.setSize(500, 500);
				//jf.setVisible(true);
			}
		}
		
		
	}	

}
