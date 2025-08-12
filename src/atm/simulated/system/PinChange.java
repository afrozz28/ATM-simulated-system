package atm.simulated.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField rePin, pin;
    JButton change, back, clear;
    String pinnumber;
    
    PinChange(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Change Your PIN");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 295, 400, 35);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JLabel pintext = new JLabel("Enter New PIN");
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(160, 370, 200, 25);
        pintext.setForeground(Color.WHITE);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setBounds(360, 370, 155, 25);
        image.add(pin);
        
        JLabel reEnter = new JLabel("Re-Enter Your New PIN");
        reEnter.setFont(new Font("System", Font.BOLD, 16));
        reEnter.setBounds(160, 420, 200, 25);
        reEnter.setForeground(Color.WHITE);
        image.add(reEnter);
        
        
        rePin = new JPasswordField();
        rePin.setFont(new Font("Raleway", Font.BOLD, 16));
        rePin.setBounds(360, 420, 155, 28);
        image.add(rePin);
        
        change = new JButton("CHANGE");
        change.setBounds(360, 485, 150, 30);
        change.addActionListener(this);
        change.setFont(new Font("System", Font.BOLD, 14));
        image.add(change);
        
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
        if(e.getSource() == change){
            try{
                String npin= pin.getText();
                String repin=rePin.getText();
                
                if(!npin.equals(repin)){
                    JOptionPane.showMessageDialog(null, "Re-Entered PIN does not match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                if(repin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-entered new PIN");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set PIN_no = '"+repin+"' where PIN_no = '"+pinnumber+"'";
                String query2 = "update login set PIN_no = '"+repin+"' where PIN_no = '"+pinnumber+"'";
                String query3 = "update signupthree set PIN_no = '"+repin+"' where PIN_no = '"+pinnumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                
            } catch (Exception a){
                System.out.println(a);
            }
        }else if (e.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);  
        } else if(e.getSource() == clear){
            pin.setText("");
            rePin.setText("");
        }
    }
    
    public static void main(String args[]){
        new PinChange("");
    }
    
}
