import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;
public class Signup3 extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JRadioButton r1,r2,r3,r4;
    JButton b1,b2,b3;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formno;
    
    Signup3(String formno){
         setLayout(null);
        
        this.formno=formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        JLabel ll = new JLabel("ATM");
        ll.setBounds(150,0,100,100);
        add(ll);
        
        l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        
        l2=new JLabel("Account type");
        l2.setFont(new Font("Raleway",Font.BOLD,18));
        
        l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l4 = new JLabel("XXXX-XXXX-XXXX-4184");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l5 = new JLabel("(Your 16-digit Card number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
        
        l6 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        l6.setFont(new Font("Raleway", Font.BOLD, 12));
        
        l7 = new JLabel("PIN:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l8 = new JLabel("XXXX");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
    
        l9 = new JLabel("(4-digit password)");
        l9.setFont(new Font("Raleway", Font.BOLD, 12));
    
        l10 = new JLabel("Services Required:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l11 = new JLabel("Form No:");
        l11.setFont(new Font("Raleway", Font.BOLD, 14));
        
        l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
          
        b1=new JButton("Submit");
        b1.setFont(new Font("Raleway",Font.BOLD,14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        
        b2 = new JButton("Cancel");
        b2.setFont(new Font("Raleway", Font.BOLD, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        
        c2= new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBackground(Color.white);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.white);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        
        l11.setBounds(700,10,70,30);
        add(l11);
        
        l12.setBounds(770,10,40,30);
        add(l12);
        
        l1.setBounds(280,20,400,40);
        add(l1); 
        
        l2.setBounds(100,120,200,30);
        add(l2);
        
        r1.setBounds(100,160,150,30);
        add(r1);
        
        r2.setBounds(350,160,300,30);
        add(r2);
        
        r3.setBounds(100,200,250,30);
        add(r3);
        
        r4.setBounds(350,200,250,30);
        add(r4);
        
        l3.setBounds(100,260,200,30);
        add(l3);
        
        l4.setBounds(330,260,250,30);
        add(l4);
        
        l5.setBounds(100,280,200,20);
        add(l5);
        
        l6.setBounds(330,280,500,20);
        add(l6);
        
        l7.setBounds(100,330,200,30);
        add(l7);
        
        l8.setBounds(330,330,200,30);
        add(l8);
        
        l9.setBounds(100,350,200,20);
        add(l9);
        
        l10.setBounds(100,380,200,30);
        add(l10);
        
        c1.setBounds(100,430,200,30);
        add(c1);
        
        c2.setBounds(350,430,200,30);
        add(c2);
        
        c3.setBounds(100,470,200,30);
        add(c3);
        
        c4.setBounds(350,470,200,30);
        add(c4);
        
        c5.setBounds(100,520,200,30);
        add(c5);
        
        c6.setBounds(350,520,200,30);
        add(c6);
        
        c7.setBounds(100,580,600,20);
        add(c7);
        
        b1.setBounds(250,650,100,30);
        add(b1);
        
        b2.setBounds(500,650,100,30);
        add(b2);
        
       /* b3.setBounds(500,650,100,30);
        add(b3);                */        //button b2 is not visible without this add who know why
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setVisible(true);
        setSize(850,730);
       
        setLocation(250,0);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        String atype = null;
        if(r1.isSelected())
            atype="Saving Account";
        else if(r2.isSelected())
            atype="Fixed Diposit Account";
        else if(r3.isSelected())
            atype="Current Account";
        else if(r4.isSelected())
            atype="Racuuring Deposi Account";
        
        Random ran = new Random();
        long first7 = (ran.nextLong()%90000000L)+50409360000000000L;
        String cardno =""+Math.abs(first7);
        
        long first3 = (ran.nextLong()%9000L)+1000L;
        String pin=""+Math.abs(first3);
        
             String facility = "";
        if(c1.isSelected()){ 
            facility = facility + " ATM Card";
        }
        if(c2.isSelected()){ 
            facility = facility + " Internet Banking";
        }
        if(c3.isSelected()){ 
            facility = facility + " Mobile Banking";
        }
        if(c4.isSelected()){ 
            facility = facility + " EMAIL Alerts";
        }
        if(c5.isSelected()){ 
            facility = facility + " Cheque Book";
        }
        if(c6.isSelected()){ 
            facility = facility + " E-Statement";
        }
        
        try{
            if(ae.getSource()==b1){
                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null,"fill all required info");
                }
                else{
                    conn  c1 = new conn();
                    String q1 = "insert into signup3 values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"','"+facility+"');";  
                    String q2 = "insert into login values('"+cardno+"','"+pin+"','"+formno+"');";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Card Number: " + cardno + "\n Pin:"+ pin);
                    
                    new Deposit(pin).setVisible(true);
                    setVisible(false);
                } 
            }else if(ae.getSource()==b2){
                System.exit(0);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public static void main(String args[]){
    new Signup3("").setVisible(true);
    }
}
