import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {
    JButton b1,b2;
    JLabel l1;
    MiniStatement(String pin){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(450,50);
        setTitle("Mini Statement");
        getContentPane().setBackground(Color.white);
        setSize(400,600);
        
        l1=new JLabel();
        add(l1);
        
        JLabel l2 = new JLabel("Indian Bank");
        l2.setBounds(150,20,100,20);
        add(l2);
        
        JLabel l3 = new JLabel();
        l3.setBounds(20,80,300,20);
        add(l3);
        
        JLabel l4 = new JLabel();
        l4.setBounds(20,400,300,20);
        add(l4);
        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin ='"+pin+"';");
            while(rs.next())
                l3.setText("Card Number : "+rs.getString("cardno").substring(0,4)+"XXXXXXXX"+rs.getString("cardno").substring(12));
        }catch(Exception ex){
        System.out.println(ex);
        }
        
         try{
            int balance = 0;
            conn c1  = new conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pin+"';");
            while(rs.next()){
                l1.setText(l1.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("mode") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                    balance = Integer.parseInt(rs.getString("amount"));
            }
            l4.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            e.printStackTrace();
        }
       
        b1 = new JButton("Exit");
        add(b1);
        
        b1.addActionListener(this);
        
        l1.setBounds(20, 140, 400, 200);
        b1.setBounds(20, 500, 100, 25);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String args[]){
        new MiniStatement("").setVisible(true);
    }
}
