package atm.simulated.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw, back, clear;
    String pinnumber;

    Withdrawal(String pinnumber) {

        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(180, 300, 400, 20);
        text.setForeground(Color.WHITE);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("System", Font.BOLD, 16));
        amount.setBounds(180, 350, 320, 28);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(360, 485, 150, 30);
        withdraw.addActionListener(this);
        withdraw.setFont(new Font("System", Font.BOLD, 14));
        image.add(withdraw);

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

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdraw) {
            String number = amount.getText();
            Date date = new Date();

            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount");
            } else {
                try {
                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery("Select * from bank where PIN_no = '" + pinnumber + "'");
                    int balance = 0;

                    while (rs.next()) {
                        if (rs.getString("Type").equals("Deposite")) {
                            balance += Integer.parseInt(rs.getString("Amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("Amount"));
                        }
                    }

                    int withdrawAmount = Integer.parseInt(number);
                    if (balance < withdrawAmount) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    String query = "Insert into bank values('" + pinnumber + "', '" + date + "', 'Withdraw', '" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdrawn Successfully");

                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } catch (Exception a) {
                    a.printStackTrace(); // Corrected to print the actual error
                }
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else if (e.getSource() == clear) {
            amount.setText("");
        }
    }

}
