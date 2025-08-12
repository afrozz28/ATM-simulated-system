package atm.simulated.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JButton submit, cancel;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    String formno, selected;
    JPanel optionsPanel;
    private HashSet<String> existingAccounts = new HashSet<>();

    SignupThree(String formno, String selected) {

        this.selected = selected;
        this.formno = formno;
        setLayout(null);

        JLabel l1 = new JLabel("Page 3: ACCOUNT Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 20));
        l1.setBounds(290, 25, 400, 30);
        add(l1);

        JLabel AccountType = new JLabel("Account Type ");
        AccountType.setFont(new Font("Raleway", Font.BOLD, 20));
        AccountType.setBounds(100, 150, 150, 30);
        add(AccountType);

        r1 = new JRadioButton("Saving Account");
        r1.setBounds(100, 180, 250, 30);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Fixed Deposite");
        r2.setBounds(450, 180, 540, 30);
        r2.setBackground(Color.WHITE);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setBounds(100, 220, 250, 30);
        r3.setBackground(Color.WHITE);
        add(r3);

        r4 = new JRadioButton("Recurring Account");
        r4.setBounds(450, 220, 540, 30);
        r4.setBackground(Color.WHITE);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel("Card Number ");
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(100, 270, 320, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4106 ");
        number.setFont(new Font("Raleway", Font.BOLD, 20));
        number.setBounds(330, 270, 320, 30);
        add(number);

        JLabel cardDetails = new JLabel("This is Your 16 Digit Card Number ");
        cardDetails.setFont(new Font("Raleway", Font.BOLD, 11));
        cardDetails.setBounds(100, 300, 320, 17);
        add(cardDetails);

        JLabel pin = new JLabel("PIN Number ");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 340, 200, 30);
        add(pin);

        JLabel pinDetails = new JLabel("This is Your 4 Digit PIN Number ");
        pinDetails.setFont(new Font("Raleway", Font.BOLD, 11));
        pinDetails.setBounds(100, 370, 320, 17);
        add(pinDetails);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 20));
        pnumber.setBounds(330, 340, 200, 30);
        add(pnumber);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        services.setBounds(100, 430, 400, 30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 470, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Backing");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 470, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 520, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 520, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 570, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 570, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declear that the above entered details are correct to thr best of  my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.addActionListener(this);
        c7.setBounds(100, 650, 600, 30);
        add(c7);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setForeground(Color.WHITE);
        submit.setBounds(220, 690, 100, 30);
        submit.setVisible(false);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(450, 690, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        existingAccounts.add(selected); // Add this to "existing"

        optionsPanel = new JPanel();
        optionsPanel.setBounds(200, 70, 400, 60);
        add(optionsPanel);

        JLabel label = new JLabel("You can create the following accounts:");
        optionsPanel.add(label);

        String[] allAccounts = {"Saving", "Current", "FD", "Recurring"};

        for (String acc : allAccounts) {
            if (!existingAccounts.contains(acc)) {
                JLabel accBtn = new JLabel("• " + acc + " Account\n");
                optionsPanel.add(accBtn);
            }
        }

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == c7) {
            submit.setVisible(true);
        }

        if (e.getSource() == submit) {
            String accountType = null;
             if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposite";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Reccuring Deposite Account";
            }
             
            if (selected.equals("Saving") && r1.isSelected()) {
                JOptionPane.showMessageDialog(this, "You cannot Create same account multiple times.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }else if (selected.equals("Current") && r3.isSelected()) {
                JOptionPane.showMessageDialog(this, "You cannot Create same account multiple times.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }else if (selected.equals("FD") && r2.isSelected()) {
                JOptionPane.showMessageDialog(this, "You cannot Create same account multiple times.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }else if (selected.equals("Recurring")&& r4.isSelected()) {
                JOptionPane.showMessageDialog(this, "You cannot Create same account multiple times.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 8604546000000000L);

            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (c1.isSelected()) {
                facility += " ATM Card";
            } else if (c2.isSelected()) {
                facility += " Internet Banking";
            } else if (c3.isSelected()) {
                facility += " Mobile Banking";
            } else if (c4.isSelected()) {
                facility += " Email & SMS Alerts";
            } else if (c5.isSelected()) {
                facility += " Cheque Book";
            } else if (c6.isSelected()) {
                facility += " E-Statement";
            }

            try {
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Acount Type is Required");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree(Account_Type, card_no, PIN_no, Facility) values( '" + accountType + "', '" + cardnumber + "', '" + pinnumber + "', '" + facility + "')";
                    String query2 = "insert into login(card_no, PIN_no) values( '" + cardnumber + "', '" + pinnumber + "')";
                    conn.s.execute(query1);
                    conn.s.execute(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n PIN: " + pinnumber);
                    setVisible(false);
                    new Login().setVisible(true);
                }
            } catch (Exception a) {
                System.out.println(a);
            }

        } else if (e.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new SignupThree("", "");
    }

}
