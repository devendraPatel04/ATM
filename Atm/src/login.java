import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class login extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3;
    login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        JLabel l11 = new JLabel("ATM");
        l11.setBounds(70,10,100,100);
        add(l11);
        
        l1=new JLabel("WELL-COME TO ATM");
        l1.setFont(new Font("Osward",Font.BOLD,38));
        l1.setBounds(200,40,450,40);
        add(l1);
        
        l2=new JLabel("Card No. : ");
        l2.setFont(new Font("Ralway",Font.BOLD,28));
        l2.setBounds(125,150,375,30);
        add(l2);
        
        tf1=new JTextField(15);
        tf1.setBounds(300,150,230,30);
        tf1.setFont(new Font("Arial",Font.BOLD,14));
        add(tf1);
        
        l3 = new JLabel("PIN :");
        l3.setFont(new Font("Raleway",Font.BOLD,28));
        l3.setBounds(125,220,375,30);
        add(l3);
        
        pf2=new JPasswordField("");
        pf2.setFont(new Font("Arial",Font.BOLD,14));
        pf2.setBounds(300,220,230,30);
        add(pf2);
        
        b1=new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setBounds(300,300,100,30);
        b1.setFont(new Font("Arial",Font.BOLD,14));
        add(b1);
        
        b2= new JButton("Clear");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(430,300,100,30);
        b2.setFont(new Font("Arial",Font.BOLD,14));
        add(b2);
        
        b3= new JButton("SIGN UP");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(300,350,230,30);
        b3.setFont(new Font("Arial",Font.BOLD,14));
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        setSize(800,480);
        setLocation(250,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==b1){
                conn c1 = new conn();
                String cardno = tf1.getText();
                String pin = pf2.getText();
                String q = "SELECT * FROM login WHERE cardno = '"+cardno+"' and pin = '"+pin+"';";
                ResultSet rs =c1.s.executeQuery(q);
                if(rs.next()){
                    new Transactions(pin).setVisible(true);
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN ");
                }
            }else if(e.getSource()==b2){
                tf1.setText("");
                pf2.setText("");
            }else if(e.getSource()==b3){
                new Signup().setVisible(true);
                setVisible(false);
                
            }
        }catch(Exception ae){
            System.out.println(ae);
        }
    }
    public static void main(String args[]){
        new login().setVisible(true);
    }
}
