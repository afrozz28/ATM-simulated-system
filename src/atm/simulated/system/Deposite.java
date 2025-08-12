package atm.simulated.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposite extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposite, back, clear;
    String pinnumber;
    
    Deposite(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to deposite");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(180, 300, 400, 20);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("System", Font.BOLD, 16));
        amount.setBounds(180, 350, 320, 28);
        image.add(amount);
        
        deposite = new JButton("Deposite");
        deposite.setBounds(360, 485, 150, 30);
        deposite.addActionListener(this);
        deposite.setFont(new Font("System", Font.BOLD, 14));
        image.add(deposite);
        
        back = new JButton("Back");
        back.setBounds(360, 520, 150, 30);
        back.addActionListener(this);
        back.setFont(new Font("System", Font.BOLD, 14));
        image.add(back);
        
        clear = new JButton("CLEAR");
        clear.setBounds(160, 520, 150, 30);
        clear.addActionListener(this);
        clear.setFont(new Font("System", Font.BOLD, 14));
        image.add(clear);
        
        
        setSize(900,900);
        setLocation(300, 0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == deposite){
            String number= amount.getText();
            Date date= new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Plz Enter the amount");
            }else {
                try{
                    Conn conn = new Conn();
                    String query = "Insert into bank values('"+pinnumber+"', '"+date+"', 'Deposite', '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+number+" Deposite Successfully");
                    
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } catch (Exception a){
                    System.out.println(e);
                }
            }
        }else if (e.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);  
        } else if(e.getSource() == clear){
            amount.setText("");
        }
    }
    
    public static void main(String args[]){
        new Deposite("");
    }
    
}
