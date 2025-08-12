package atm.simulated.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transaction extends JFrame implements ActionListener{
    
    JButton deposite, withdrawl, pin, fastcash, exit, balance, mini;
    String pinnumber;
    
    Transaction(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(225, 300, 700, 35);
        text.setForeground(Color.WHITE);
        image.add(text);
        
        deposite = new JButton("Deposite");
        deposite.setBounds(160, 415, 150, 30);
        deposite.addActionListener(this);
        deposite.setFont(new Font("System", Font.BOLD, 14));
        image.add(deposite);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(360, 415, 150, 30);
        withdrawl.setFont(new Font("System", Font.BOLD, 14));
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(160, 450, 150, 30);
        fastcash.setFont(new Font("System", Font.BOLD, 14));
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        mini = new JButton("Mini-Statement");
        mini.setBounds(360, 450, 150, 30);
        mini.setFont(new Font("System", Font.BOLD, 14));
        mini.addActionListener(this);
        image.add(mini);
        
        pin = new JButton("Pin Change");
        pin.setBounds(160, 485, 150, 30);
        pin.setFont(new Font("System", Font.BOLD, 14));
        pin.addActionListener(this);
        image.add(pin);
        
        balance = new JButton("Check Balance");
        balance.setBounds(360, 485, 150, 30);
        balance.setFont(new Font("System", Font.BOLD, 14));
        balance.addActionListener(this);
        image.add(balance);
        
        exit = new JButton("Exit");
        exit.setBounds(360, 520, 150, 30);
        exit.setFont(new Font("System", Font.BOLD, 14));
        exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(900, 900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == exit){
            System.exit(0);
        } else if (e.getSource() == deposite){
            setVisible(false);
            new Deposite(pinnumber).setVisible(true);
        }else if (e.getSource() == withdrawl){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }else if (e.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if (e.getSource() == pin){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if (e.getSource() == balance){
            setVisible(false);
            new CheckBalance(pinnumber).setVisible(true);
        }else if (e.getSource() == mini){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Transaction("");
    }
    
}
