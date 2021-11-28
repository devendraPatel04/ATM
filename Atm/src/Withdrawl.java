import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener{
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2;
    String pin;
    Withdrawl(String pin){
        setTitle("WITHDRAWL");
        setLayout(null);
        this.pin=pin;
        JLabel ll = new JLabel("ATM");
        ll.setBounds(20,20,40,25);
        
        l1=new JLabel("MAXIMUM WITHDRAWL IS 10,000");
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        
        l2=new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setFont(new Font("Raleway",Font.BOLD,16));
        
        t1=new JTextField();
        t1.setFont(new Font("Raleway",Font.BOLD,25));
        
        b1=new JButton("WITHDRAW");
        b2=new JButton("BACK");
        
        l1.setBounds(120,100,400,20);
        add(l1);
        
        l2.setBounds(125,150,400,30);
        add(l2);
        
        t1.setBounds(90,50,330,30);
        add(t1);
        
        b1.setBounds(70,220,150,35);
        add(b1);
        
        b2.setBounds(280,220,150,35);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setVisible(true);
        setSize(500,350);
        setLocation(450,130);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"Please Enter the Amount");
                else{
                    conn c1 = new conn();
                    ResultSet rs = c1.s.executeQuery("select * from bank where pin='"+pin+"'");
                    int balance =0;
                    while(rs.next()){
//                        if(rs.getString("mode").equals("Deposit"))
//                            balance += Integer.parseInt(rs.getString("amount"));
//                        else
                            balance -=Integer.parseInt(rs.getString("amount"));
                    }
                    if(balance<Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return ;
                    }
                    c1.s.executeUpdate("insert into bank('pin', 'withdraw', 'balance') values('"+pin+"', 'Withdrawl', '"+amount+"');");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");
                    
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
        new Withdrawl("").setVisible(true);
    }
}
