import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class VatCalculation extends JFrame implements ActionListener
{
	JButton button [] = new JButton[3];
	String buttonName [] = {"Calculate","Clear","About"};
	JTextField textField[] = new JTextField[2];
	Choice choice;
	String srtVate[] = {"-- select --","1","2","3","7","10"};
	public VatCalculation(){
		super("PriceSumProduct VAT!");
		JPanel panelLabel = new JPanel(new GridLayout(3,1));
		JPanel panelC = new JPanel(new GridLayout(3,1));
		JPanel panelB = new JPanel ();
		
		panelLabel.add(new Label("Product+Vat :"));
		textField[0] = new JTextField();
		textField[0].addActionListener(this);
		panelC.add(textField[0]);

		panelLabel.add(new Label("VAT %"));
		choice = new Choice();
		for (int i = 0;i<srtVate.length ;i++ )
		{
			choice.addItem(srtVate[i]);		
		}
		panelC.add(choice);
		
		panelLabel.add(new Label("The actual price."));
		textField[1] = new JTextField();
		textField[1].setEditable(false);	
		panelC.add(textField[1]);

		for (int i = 0;i<button.length ;i++ )
		{
			button[i] = new JButton(buttonName[i]);
			button[i].addActionListener(this);
			panelB.add(button[i]);
		}
		
		add(panelLabel,BorderLayout.WEST);
		add(panelC,BorderLayout.CENTER);
		add(panelB,BorderLayout.SOUTH);
	}
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
			if (source == button[0])
			{
				String text = textField[0].getText();
				Pattern p = Pattern.compile("[^A-Za-z\\.\\@_\\-~# ]+");
			    Matcher m = p.matcher(text);
				if( text.equals(""))
					JOptionPane.showMessageDialog(this,"Please enter the catalog.");
				else if(!m.find())
					JOptionPane.showMessageDialog(this,"Please enter 0 - 9.");
				else if(choice.getSelectedIndex()==0)
					JOptionPane.showMessageDialog(this,"Please enter the Vat.");
				else {
					double price = Integer.parseInt(text);
					double vat = Double.parseDouble(choice.getSelectedItem());
					double div = 100+vat;
					double sumPirceVat = (price*vat)/div;
					DecimalFormat df = new DecimalFormat("###,##0.00");
					textField[1].setText(df.format(Integer.parseInt(text)-sumPirceVat));
					System.out.println(price+"*"+vat+"/"+div+"+"+vat+"="+sumPirceVat);
				}
			}else if(source == button[1]){
				for (int i = 0;i<textField.length ;i++ )
				{
					textField[i].setText("");
					textField[i].setOpaque(true);
					textField[i].setForeground(Color.black);
				}
			}else if(source == button[2]){
				JOptionPane.showMessageDialog(this,"about me");
			}		
	}
	public static void main(String[] args) 
	{
		VatCalculation gui = new VatCalculation();
		gui.setSize(300,200);
		gui.setVisible(true);
		gui.getContentPane().setBackground(Color.cyan);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
