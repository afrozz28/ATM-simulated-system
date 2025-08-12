package atm.simulated.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {

    JTextField nameText, FnameText, emailText, addressText, cityText, stateText, pinText;
    JRadioButton male, female, married, unmarried, other;
    JButton next, submitButton;
    JDateChooser datechooser;
    long random;

    Signup() {

        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("Application Form No. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 36));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel persnalDetails = new JLabel("Page 1: Persnal Details");
        persnalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        persnalDetails.setBounds(290, 80, 400, 30);
        add(persnalDetails);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameText = new JTextField();
        nameText.setFont(new Font("Raleway", Font.BOLD, 14));
        nameText.setBounds(300, 140, 400, 30);
        add(nameText);

        JLabel Fname = new JLabel("Father's Name: ");
        Fname.setFont(new Font("Raleway", Font.BOLD, 20));
        Fname.setBounds(100, 190, 200, 30);
        add(Fname);

        FnameText = new JTextField();
        FnameText.setFont(new Font("Raleway", Font.BOLD, 14));
        FnameText.setBounds(300, 190, 400, 30);
        add(FnameText);

        JLabel DOB = new JLabel("Date of Birth: ");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(100, 240, 200, 30);
        add(DOB);

        datechooser = new JDateChooser();
        datechooser.setBounds(300, 240, 400, 30);
        datechooser.setForeground(new Color(105, 105, 105));
        add(datechooser);

        submitButton = new JButton("Validate Age");
        submitButton.setFont(new Font("Raleway", Font.BOLD, 20));
        submitButton.setBounds(525, 280, 170, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 320, 200, 30);
        add(gender);

        male = new JRadioButton("MALE");
        male.setBounds(300, 320, 80, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("FEMALE");
        female.setBounds(450, 320, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 370, 200, 30);
        add(email);

        emailText = new JTextField();
        emailText.setFont(new Font("Raleway", Font.BOLD, 14));
        emailText.setBounds(300, 370, 400, 30);
        add(emailText);

        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 420, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 420, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 420, 120, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(630, 420, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 470, 200, 30);
        add(address);

        addressText = new JTextField();
        addressText.setFont(new Font("Raleway", Font.BOLD, 14));
        addressText.setBounds(300, 470, 400, 30);
        add(addressText);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 520, 200, 30);
        add(city);

        cityText = new JTextField();
        cityText.setFont(new Font("Raleway", Font.BOLD, 14));
        cityText.setBounds(300, 520, 400, 30);
        add(cityText);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 570, 200, 30);
        add(state);

        stateText = new JTextField();
        stateText.setFont(new Font("Raleway", Font.BOLD, 14));
        stateText.setBounds(300, 570, 400, 30);
        add(stateText);

        JLabel pincod = new JLabel("PIN Code: ");
        pincod.setFont(new Font("Raleway", Font.BOLD, 20));
        pincod.setBounds(100, 620, 200, 30);
        add(pincod);

        pinText = new JTextField();
        pinText.setFont(new Font("Raleway", Font.BOLD, 14));
        pinText.setBounds(300, 620, 400, 30);
        add(pinText);

        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setForeground(Color.WHITE);
        next.setBounds(620, 690, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            String formno = "" + random;
            String name = nameText.getText();
            String Fname = FnameText.getText();
            String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
            String gender = null;
            if (male.isSelected()) {
                gender = "MALE";
            } else if (female.isSelected()) {
                gender = "FEMALE";
            }

            String email = emailText.getText();
            String marital = null;
            if (married.isSelected()) {
                marital = "Married";
            } else if (unmarried.isSelected()) {
                marital = "Unmarried";
            } else if (other.isSelected()) {
                marital = "Other";
            }

            String address = addressText.getText();
            String city = cityText.getText();
            String state = stateText.getText();

            String pin = pinText.getText();

            try {
                if (name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Name is Required");
                } else if (dob.equals("")) {
                    JOptionPane.showMessageDialog(null, "Date is Required");
                }

                Date selectedDate = datechooser.getDate();

                Calendar dobb = Calendar.getInstance();
                dobb.setTime(selectedDate);

                Calendar today = Calendar.getInstance();
                int age = today.get(Calendar.YEAR) - dobb.get(Calendar.YEAR);

                if (today.get(Calendar.DAY_OF_YEAR) < dobb.get(Calendar.DAY_OF_YEAR)) {
                    age--; // if the birthday hasn't occurred yet this year
                }

                if (age < 18) {
                    JOptionPane.showMessageDialog(null, "You must be at least 18 years old.", "Underage", JOptionPane.ERROR_MESSAGE);
                } else {
                    Conn c = new Conn();
                    String query = " insert into signup(name, Fname, dob, gender, marital, email, address, city, pin, state )values('" + name + "', '" + Fname + "', '" + dob + "', '" + gender + "','" + marital + "', '" + email + "', '" + address + "', '" + city + "','" + pin + "', '" + state + "')";
                    c.s.executeUpdate(query);

                    setVisible(false);
                    new SignupTwo(formno).setVisible(true);
                }
            } catch (Exception a) {
                System.out.println(a);
            }
        } else if (e.getSource() == submitButton) {
            Date selectedDate = datechooser.getDate();
            if (selectedDate == null) {
                JOptionPane.showMessageDialog(this, "Please select a date.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Calendar dob = Calendar.getInstance();
            dob.setTime(selectedDate);

            Calendar today = Calendar.getInstance();
            int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

            if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
                age--; // if the birthday hasn't occurred yet this year
            }

            if (age < 18) {
                JOptionPane.showMessageDialog(null, "You must be at least 18 years old.", "Underage", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Age is valid: " + age + " years.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String args[]) {
        
        new Signup();
        
    }

}
