import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    Transactions(String pin){
        this.pin=pin;
        
        l1=new JLabel("Please Select Your Transaction : ");
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        l1.setForeground(Color.red);
        
        b1=new JButton("DEPOSITE");
        b2=new JButton("CASH WITHDRAWL");
        b3=new JButton("FAST CASH");
        b4=new JButton("MINI STATEMENT");
        b5=new JButton("PIN CHANGE");
        b6=new JButton("BALANCE ENQUIRY");
        b7=new JButton("EXIT");
        
        setLayout(null);
        l1.setBounds(50,20,400,35);
        add(l1);
        
        b1.setBounds(50,80,150,35);
        add(b1);
        
        b2.setBounds(270,80,150,35);
        add(b2);
        
        b3.setBounds(50,150,150,35);
        add(b3);
        
        b4.setBounds(270,150,150,35);
        add(b4);
        
        b5.setBounds(50,220,150,35);
        add(b5);
        
        b6.setBounds(270,220,150,35);
        add(b6);
        
        b7.setBounds(165,300,150,35);
        add(b7);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        setSize(500,400);
        setLocation(450,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
           new  Deposit(pin).setVisible(true);
           setVisible(false);
        }
        else if(ae.getSource()==b2){
            new Withdrawl(pin).setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==b3){
            new FastCash(pin).setVisible(true);
            setVisible(false);
            
        }
        else if(ae.getSource()==b5){ 
            new Pin(pin).setVisible(true);
            setVisible(false);
            
        }
        else if(ae.getSource()==b6){ 
            new BalanceEnquiry(pin).setVisible(true);
            this.setVisible(false);
            
        }
        else if(ae.getSource()==b4){
            new MiniStatement(pin).setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==b7){ 
            System.exit(0);
        }
    }
    public static void main(String args[]){
        new Transactions("").setVisible(true);
    }
}
