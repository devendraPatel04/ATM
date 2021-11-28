import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Deposit extends JFrame implements ActionListener{
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2;
    String pin;
    Deposit(String pin){
        setLayout(null);        //always set Layout before  setting up Bounds
        this.pin=pin;
        JLabel ll=new JLabel("ATM");
        ll.setBounds(20,20,30,40);
        add(ll);
        
        l1=new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        //l1.setForeground(Color.white);
        
        t1=new JTextField();
        t1.setFont(new Font("Raleway",Font.BOLD,22));
        
        b1=new JButton("DEPOSIT");
        b2=new JButton("BACk");
        
        l1.setBounds(85,100,400,35);
        add(l1);
        
        t1.setBounds(85,150,330,28);
        add(t1);
        
        b1.setBounds(160,200,150,35);
        add(b1);
        
        b2.setBounds(160,250,150,35);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        //setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(450,100);
        setVisible(true);
        setTitle("Deposite Page");
        setSize(500,400);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            String amount = t1.getText();
            if(ae.getSource()==b1){
                if(t1.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"Please Enter Some Amount");
                else{
                    conn c1 = new conn();
                    c1.s.executeUpdate("INSERT INTO `bank` (`pin`, `deposit`, `withdraw`, `balance`) VALUES ('"+pin+"', 'Deposit', NULL, '"+amount+"');");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposited Successfully");
                
                    new Transactions(pin).setVisible(true);
                    setVisible(false);  
                }
            }else if(ae.getSource()==b2){
                new Transactions(pin).setVisible(true);
                setVisible(false);
                
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static void main(String args[]){
        new Deposit("").setVisible(true);
    }
}
