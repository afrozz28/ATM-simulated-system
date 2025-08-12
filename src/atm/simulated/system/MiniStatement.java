package atm.simulated.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
 
public class MiniStatement extends JFrame {
    
    String pinnumber;
    
    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);
        
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 50, 100, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        Conn conn = new Conn();
        int bal = 0;
       try{
            ResultSet rs = conn.s.executeQuery("Select * From login where PIN_no = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+ rs.getString("Card_no").substring(0, 4) + "-XXXX-XXXX-" + rs.getString("Card_no").substring(12) );
            }
        } catch (Exception a){
            System.out.println(a);
        }
       
       try{
           ResultSet rs = conn.s.executeQuery("Select * From bank where PIN_no = '"+pinnumber+"'");
           
           while(rs.next()){
               mini.setText(mini.getText() + "<html>" + rs.getString("Date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Amount") + "<br><br><html>");
               
                if(rs.getString("Type").equals("Deposite")){
                        bal += Integer.parseInt(rs.getString("Amount"));
                    } else {
                        bal -=Integer.parseInt(rs.getString("Amount"));
                    }
           }
           
           balance.setText("Your current account balance is: " + bal);
           
       }catch (Exception a){
           System.out.println(a);
       }
        
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new MiniStatement("");
    }
}
