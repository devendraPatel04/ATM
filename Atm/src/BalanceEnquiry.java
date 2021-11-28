import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JTextField t1, t2;
    JButton b1;
    JLabel l1, l2;
    String pin;
    
    BalanceEnquiry(String pin){
        setLayout(null);
        setLocation(450,50);
        setSize(500,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        this.pin=pin;
        
        l1=new JLabel();
        l1.setFont(new Font("System",Font.BOLD,16));
        
        b1 = new JButton("BACK");
        l1.setBounds(90, 80, 400, 35);
        add(l1);

        b1.setBounds(160, 200, 150, 35);
        add(b1);
        int balance = 0;
       try{
            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"';");
            while (rs.next()) {
                if (rs.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){}
        
        l1.setText("Your Current Account Balance is Rs : "+balance);

        b1.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae){
        new Transactions(pin).setVisible(true);
        setVisible(false);
    }
    public static void main(String args[]){
        new BalanceEnquiry("").setVisible(true);
    }
}
