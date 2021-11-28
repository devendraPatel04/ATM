import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener{
    JPasswordField t1,t2;
    JButton b1,b2;                               
    JLabel l1,l2,l3;
    String pin;
    
    Pin(String pin){
        super("PIN CHANGE");
        this.pin=pin;
        setLayout(null);
        
        l1= new JLabel("Change Your PIN");
        l1.setFont(new Font("System",Font.BOLD,16));
        
        l2=new JLabel("New PIN :");
        l2.setFont(new Font("System",Font.BOLD,16));
         
        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        
        b1 = new JButton("CHANGE");
        b2 = new JButton("BACK");
        
        l1.setBounds(180,50,200,35);
        add(l1);
        
        l2.setBounds(50,130,150,35);
        add(l2);
        
        l3.setBounds(50,180,200,35);
        add(l3);
        
        t1.setBounds(250,130,180,25);
        add(t1);
        
        t2.setBounds(250,180,180,25);
        add(t2);
        
        b1.setBounds(80,260,150,35);
        add(b1);
        
        b2.setBounds(250,260,150,35);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
                
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(450,100);
        setSize(500,400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae ){
        try{
            String npin = t1.getText();
            String rpin = t2.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Entered Pin Are not Same");
                return ;
            }
            
            if(ae.getSource()==b1){
                if(t1.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"Enter new Pin");
                if(t2.getText().equals(""))
                    JOptionPane.showMessageDialog(null,"Re_Enter new Pin");
                
                conn c1 = new conn();
                String q1 = "update bank set pin ='"+rpin+"'where pin = '"+pin+"';";
                String q2 = "update login set pin ='"+rpin+"' where pin = '"+pin+"';";
                String q3 = "update signup3 set pin = '"+rpin+"' where pin ='"+pin+"';";
            
                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);
                
                JOptionPane.showMessageDialog(null,"PIN Chaged successfully");
                new Transactions(rpin).setVisible(true);
                setVisible(true);
            }
            else if(ae.getSource()==b2){
                new Transactions(pin).setVisible(true);
                setVisible(false);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static void main(String args[]){
        new Pin("").setVisible(true);
    }
}
