package monpackageclient;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import com.sun.javacard.apduio.CadTransportException;
public class Tansactions extends JFrame implements ActionListener {
	
	
	JLabel l1;
    JButton b1,b2,b3,b4,b7;
    String pin;
    Tansactions() 
    {
    	
    	
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, -200, 960, 1080);
        add(l2);

        l1 = new JLabel("<html><u>Please Select Your Transaction</u></html> ");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 20));


        b1 = new JButton("CREDITER");
        b2 = new JButton("SOLDE");
        b3 = new JButton("DEBITER");
        b4 = new JButton("RELEVE DU COMPTE");
        b7 = new JButton("EXIT");

        setLayout(null);

        l1.setBounds(210,400,700,35);
        l2.add(l1);

        b1.setBounds(170,499,150,35);
        l2.add(b1);

        b2.setBounds(390,499,150,35);
        l2.add(b2);

        b3.setBounds(170,543,150,35);
        l2.add(b3);

        b4.setBounds(390,543,150,35);
        l2.add(b4);

        b7.setBounds(390,620,150,35);
        l2.add(b7);


        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b7.addActionListener(this);


        setSize(960,800);
        setLocation(500,5);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){ 
            setVisible(false);
            new Crediter(this).setVisible(true);
        }else if(ae.getSource()==b2){       
        	setVisible(false);
            new Solde(this).setVisible(true);
        }else if(ae.getSource()==b3){ 
            setVisible(false);
            new Debiter(this).setVisible(true);
        }else if(ae.getSource()==b4){ 
        	new TransactionHitory().setVisible(true);
        }else if(ae.getSource()==b7){ 
            System.exit(0);
        }
    }

  //  public static void main(String[] args) throws IOException, CadTransportException{
  //      new Tansactions().setVisible(true);
  //  }
}