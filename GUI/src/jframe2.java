import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class jframe2 extends JFrame {

	public jframe2() {
		// TODO Auto-generated constructor stub
		 // create a new panel with GridBagLayout manager
		JPanel p = new JPanel();
        JPanel newPanel = new JPanel(new GridBagLayout());
       
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        
        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Login Panel"));
      
        p.add(newPanel);
        // add the panel to this frame
        //add(p);
   
        JPanel panel = new JPanel(new GridBagLayout()); 
        GridBagConstraints c = new GridBagConstraints();
       

       

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
       
        
     
        //panel.add(user);
       
        getContentPane().add(panel);
        
        pack();
        setSize(500,500);
  
        setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// set look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new jframe2().setVisible(true);
            }
        });
	}

}
