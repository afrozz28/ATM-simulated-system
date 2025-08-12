package atm.simulated.system;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton login, clear, signup;
     JTextField card_number;
     JPasswordField pin_number;

    Login() {

        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 40));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel card_no = new JLabel("Card No:");
        card_no.setFont(new Font("Raleway", Font.BOLD, 28));
        card_no.setBounds(120, 150, 150, 40);
        add(card_no);

        card_number = new JTextField();
        card_number.setFont(new Font("Arial", Font.BOLD, 16));
        card_number.setBounds(300, 150, 230, 40);
        add(card_number);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 210, 250, 40);
        add(pin);

        pin_number = new JPasswordField();
        pin_number.setBounds(300, 210, 230, 40);
        pin_number.setFont(new Font("Arial", Font.BOLD, 16));
        add(pin_number);

        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == clear){
            card_number.setText("");
            pin_number.setText("");
        } else if (e.getSource() == login){
            Conn conn = new Conn();
            String cardnumber = card_number.getText();
            String pinnumber = pin_number.getText(); //20:45 sec 7/12
            String query = "Select * From login where Card_no = '"+cardnumber+"' and PIN_no = '"+pinnumber+"'";
            
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(null, "Card Number or PIN is incorrect");
                }
            } catch (Exception a){
                System.out.println(a);
            }
            
        } else if (e.getSource() == signup){
            setVisible(false);
            new Signup().setVisible(true);
        }
        
    }

    public static void main(String[] args) {
        new Login();
    }

}
