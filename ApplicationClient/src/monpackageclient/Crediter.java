package monpackageclient;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Date;


//JOptionPane.showMessageDialog(null, "Rs. "+5000+" Debited Successfully");
public class Crediter extends JFrame implements ActionListener{

	private Tansactions transactions;
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    Crediter(Tansactions transactions){

    	this.transactions = transactions;
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("FAST CASH");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (4*x);
        int w = z/y;
        String pad ="";  
        setTitle(pad+"FAST CASH");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, -200, 960, 1080);
        add(l3);

        l1 = new JLabel("SELECTIONNER LA QUANTITE A CREDITER");
        l1.setFont(new Font("System", Font.BOLD, 38));

        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("20");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.green);
        b1.setForeground(Color.black);

        b2 = new JButton("50");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.green);
        b2.setForeground(Color.black);

        b3 = new JButton("100");
        b3.setFont(new Font("System", Font.BOLD, 18));
        b3.setBackground(Color.green);
        b3.setForeground(Color.black);

        b4 = new JButton("200");
        b4.setFont(new Font("System", Font.BOLD, 18));
        b4.setBackground(Color.green);
        b4.setForeground(Color.black);

        b5 = new JButton("500");
        b5.setFont(new Font("System", Font.BOLD, 18));
        b5.setBackground(Color.green);
        b5.setForeground(Color.black);

        b6 = new JButton("1000");
        b6.setFont(new Font("System", Font.BOLD, 18));
        b6.setBackground(Color.green);
        b6.setForeground(Color.black);

        b7 = new JButton("RETURN");
        b7.setFont(new Font("System", Font.BOLD, 18));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.white);

        setLayout(null);


        l1.setBounds(190, 400, 700, 35);
        l3.add(l1);

        b1.setBounds(170, 499, 150, 35);
        l3.add(b1);

        b2.setBounds(390, 499, 150, 35);
        l3.add(b2);

        b3.setBounds(170, 543, 150, 35);
        l3.add(b3);

        b4.setBounds(390, 543, 150, 35);
        l3.add(b4);

        b5.setBounds(170, 588, 150, 35);
        l3.add(b5);

        b6.setBounds(390, 588, 150, 35);
        l3.add(b6);

        b7.setBounds(280,627,150,35);
        l3.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setSize(960, 800);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);

    }
 /*   public void actionPerformed(ActionEvent ae){
    	if(ae.getSource()==b7){
    		 
    		this.setVisible(false);
    		new Tansactions().setVisible(true);

        }
    	if(ae.getSource()==b1){
   		 
    	byte montant= (byte) 0x14;
        }

    }*/

    public void actionPerformed(ActionEvent ae){
    	short r,amount;
            if(ae.getSource()==b1)
            {
            	amount=20;
            	r=Login.a.creditAmount(amount);
            	if(r==0)
            	{
            		JOptionPane.showMessageDialog(null, "error");
            	}
            	else if(r==-1)
            	{
            		JOptionPane.showMessageDialog(null, "Error: Exceeded Maximum Balance Limit");
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null, "Success: Amount Credited ");
            	}
            	
            }
            else if(ae.getSource()==b2)
            {
            	amount=50;
            	r=Login.a.creditAmount(amount);
            	if(r==0)
            	{
            		JOptionPane.showMessageDialog(null, "error");
            	}
            	else if(r==-1)
            	{
            		JOptionPane.showMessageDialog(null, "Error: Exceeded Maximum Balance Limit");
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null, "Success: Amount Credited ");
            	}
            }
            else if(ae.getSource()==b3)
            {
            	amount=100;
            	r=Login.a.creditAmount(amount);
            	if(r==0)
            	{
            		JOptionPane.showMessageDialog(null, "error");
            	}
            	else if(r==-1)
            	{
            		JOptionPane.showMessageDialog(null, "Error: Exceeded Maximum Balance Limit");
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null, "Success: Amount Credited ");
            	}
            }
            else if(ae.getSource()==b4)
            {
            	amount=200;
            	r=Login.a.creditAmount(amount);
            	if(r==0)
            	{
            		JOptionPane.showMessageDialog(null, "error");
            	}
            	else if(r==-1)
            	{
            		JOptionPane.showMessageDialog(null, "Error: Exceeded Maximum Balance Limit");
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null, "Success: Amount Credited ");
            	}
            }
            else if(ae.getSource()==b5)
            {
            	amount=500;
            	r=Login.a.creditAmount(amount);
            	if(r==0)
            	{
            		JOptionPane.showMessageDialog(null, "error");
            	}
            	else if(r==-1)
            	{
            		JOptionPane.showMessageDialog(null, "Error: Exceeded Maximum Balance Limit");
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null, "Success: Amount Credited ");
            	}

            }
            else if(ae.getSource()==b6)
            {
            	amount=1000;
            	r=Login.a.creditAmount(amount);
            	if(r==0)
            	{
            		JOptionPane.showMessageDialog(null, "error");
            	}
            	else if(r==-1)
            	{
            		JOptionPane.showMessageDialog(null, "Error: Exceeded Maximum Balance Limit");
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null, "Success: Amount Credited ");
            	}

            }
            else if(ae.getSource()==b7)
            {
            	this.setVisible(false);
                if (transactions != null) {
                    transactions.setVisible(true);
                }
                else 
                {System.out.print("bbb");}
            }


    }

}
