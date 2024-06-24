package monpackageclient;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import com.sun.javacard.apduio.CadTransportException;
public class Login extends JFrame implements ActionListener{
	static MaClasse a;
//	private Tansactions transactions;
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b3;

   // Login(Tansactions transactions)
    Login() throws IOException, CadTransportException{
    	//this.transactions = transactions;

        //Move the text to the center
    	a =new MaClasse ();
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("AUTOMATED TELLER MACHINE");
        int y = fm.stringWidth(" ");
        int z = getWidth() - x;
        int w = z/y;


        setTitle("AUTOMATED TELLER MACHINE");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("STB-Bank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(250, -10, 300, 150);
        add(l11);


        l2 = new JLabel("Welcome to STB-Bank!");
        l2.setFont(new Font("Raleway", Font.BOLD, 33));
        l2.setBounds(210,150,375,200);
        add(l2);


        l3 = new JLabel("PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125,225,375,200);
        add(l3);

        pf2 = new JPasswordField(15);

        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300,220,230,30);
        add(pf2);

        
        b3 = new JButton("LOGIN");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);

        setLayout(null);




        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300,310,230,30);
        add(pf2);


        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(300,450,230,30);
        b3.setBounds(300,350,230,30);
        add(b3);

        b3.addActionListener(this);

        getContentPane().setBackground(Color.GRAY);

        setSize(750,750);
        setLocation(500,200);
        setSize(800,480);
        setLocation(550,200);
        setVisible(true);



    }
    public void actionPerformed(ActionEvent ae){
    	String enteredPIN = new String(pf2.getPassword());
    	int l=enteredPIN.length();
    	System.out.println(l);
    	 byte[] enteredPINBytes = new byte[l]; // Convert PIN string to byte array
    	 for (int i = 0; i < l; i++) {
    		    char digit = enteredPIN.charAt(i);
    		    enteredPINBytes[i] = (byte) Character.getNumericValue(digit);}
  
    	
         short isValidPIN = a.verifyPIN(enteredPINBytes);
    
    	 if (isValidPIN==1) {
             setVisible(false);
             new Tansactions().setVisible(true);
         } else if (isValidPIN==-1)  {
             // Display an error message or take necessary action for invalid PIN
             JOptionPane.showMessageDialog(this, "Invalid PIN. Please try again.");
         }
         else if (isValidPIN==-2)  {
             // Display an error message or take necessary action for invalid PIN
             JOptionPane.showMessageDialog(this, "Card is blocked ");
         }
         else  JOptionPane.showMessageDialog(this, "why.");
		}
       


    public static void main(String[] args) throws IOException, CadTransportException{
       new Login().setVisible(true);
    }
    
}
