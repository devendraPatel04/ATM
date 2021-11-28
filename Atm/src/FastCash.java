import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    JLabel l1,l2;
    String pin;
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    JTextField t1;
    
    FastCash(String pin){
        this.pin=pin;
        setLayout(null);
        
        l1=new JLabel("SELCT WITHDRAWL AMOUNT");
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        
        b1 = new JButton("Rs 100");
        b2 = new JButton("Rs 500");
        b3 = new JButton("Rs 1000");
        b4 = new JButton("Rs 2000");
        b5 = new JButton("Rs 5000");
        b6 = new JButton("Rs 10000");
        b7 = new JButton("BACK");
        
        l1.setBounds(235, 50, 700, 35);
        add(l1);

        b1.setBounds(170, 120, 150, 35);
        add(b1);

        b2.setBounds(390, 120, 150, 35);
        add(b2);

        b3.setBounds(170, 170, 150, 35);
        add(b3);

        b4.setBounds(390, 170, 150, 35);
        add(b4);

        b5.setBounds(170, 220, 150, 35);
        add(b5);

        b6.setBounds(390, 220, 150, 35);
        add(b6);

        b7.setBounds(280, 280, 150, 35);
        add(b7);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        setSize(700,400);
        setLocation(350,100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            conn c1 = new conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin='"+pin+"';");
            int balance=0;
             
            while(rs.next()){
                if(rs.getString("mode").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
                String num="17";
                if(ae.getSource()!=b7 && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                if(ae.getSource()==b7){
                    new Transactions(pin).setVisible(true);
                    setVisible(false);
                }
                else{
                    Date date = new Date();
                    c1.s.executeUpdate("insert into bank('pin', 'withdraw', 'balance') values('"+pin+"', 'Withdrawl', '"+amount+"');");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");
                    
                    new Transactions(pin).setVisible(true);
                    setVisible(false);
                }
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    } 
    
    public static void main(String args[]){
        new FastCash("").setVisible(true);
    }
}
