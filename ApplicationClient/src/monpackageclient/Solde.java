package monpackageclient;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import com.sun.javacard.apduio.CadTransportException;
public class Solde extends JFrame implements ActionListener {

	private Tansactions transactions;
	JLabel l1,l3;
    JButton b7;
    String pin;
    short solde;
    Solde(Tansactions transactions)
    {
    	this.transactions = transactions;
    	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, -200, 960, 1080);
        add(l2);
        solde=Login.a.checkBalance();
        l1 = new JLabel("<html><u>VOTRE SOLDE</u></html> ");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        
       String ssolde = String.valueOf(solde);
        l3 = new JLabel(ssolde);
        l3.setBackground(Color.WHITE);
        l3.setOpaque(true);
        l3.setForeground(Color.BLACK);


        setLayout(null);

        l1.setBounds(275,400,700,35);
        l2.add(l1);

        l3.setBounds(272,499,150,35);
        l2.add(l3);
        
        b7 = new JButton("RETURN");
        b7.setBounds(390,620,150,35);
        l2.add(b7);
        b7.addActionListener(this);

        setSize(960,800);
        setLocation(500,5);
        setUndecorated(true);
        setVisible(true);



    }

    public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b7){ 
	this.setVisible(false);
    if (transactions != null) {
        transactions.setVisible(true);
    }
}
}
    }