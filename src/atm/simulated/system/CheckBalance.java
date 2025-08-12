package atm.simulated.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CheckBalance extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;
    
    CheckBalance(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Your Account Balance is");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(190, 320, 400, 35);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        back = new JButton("Back");
        back.setBounds(360, 520, 150, 30);
        back.addActionListener(this);
        back.setFont(new Font("System", Font.BOLD, 14));
        image.add(back);
        int balance=0;
        Conn conn = new Conn();
        try{
                ResultSet rs = conn.s.executeQuery("Select * from bank where PIN_no = '"+pinnumber+"'");
                while(rs.next()){
                    if(rs.getString("Type").equals("Deposite")){
                        balance += Integer.parseInt(rs.getString("Amount"));
                    } else {
                        balance -=Integer.parseInt(rs.getString("Amount"));
                    }
                }
        }catch (Exception a){
                System.out.println(a);
            }
        
        JLabel text1 = new JLabel(""+balance);
        text1.setFont(new Font("System", Font.BOLD, 16));
        text1.setBounds(300, 365, 400, 35);
        text1.setForeground(Color.WHITE);
        image.add(text1);
        
        setSize(900,900);
        setLocation(300, 0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
    
    public static void main(String args[]){
        new CheckBalance("");
    }
    
}
