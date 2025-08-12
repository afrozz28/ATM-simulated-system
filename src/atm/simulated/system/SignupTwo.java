package atm.simulated.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField panText, aadharText;
    JRadioButton syes, sno, eyes, eno;
    JButton next;
    JComboBox religion, Category, Income, Edu_qua, occupation, existingBox;
    String formno, selected;
    JLabel acc_type, additionlaDetails, Religion_name, category, income, Education, qualification, Occupation, Existing_acc, pan, Aadhar, Senior;

    SignupTwo(String formno) {
        this.formno = formno;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        additionlaDetails = new JLabel("Page 2: Additional Details");
        additionlaDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        additionlaDetails.setBounds(290, 80, 400, 30);
        add(additionlaDetails);

        Religion_name = new JLabel("Religion: ");
        Religion_name.setFont(new Font("Raleway", Font.BOLD, 20));
        Religion_name.setBounds(100, 140, 100, 30);
        add(Religion_name);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        category = new JLabel("Category: ");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

        String valCategory[] = {"General", "OBC", "NT", "SC", "ST", "other"};
        Category = new JComboBox(valCategory);
        Category.setBounds(300, 190, 400, 30);
        Category.setBackground(Color.WHITE);
        add(Category);

        income = new JLabel("Income: ");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String valIncome[] = {"NULL", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000", "above 10,00,000"};
        Income = new JComboBox(valIncome);
        Income.setBounds(300, 240, 400, 30);
        Income.setBackground(Color.WHITE);
        add(Income);

        Education = new JLabel("Education: ");
        Education.setFont(new Font("Raleway", Font.BOLD, 20));
        Education.setBounds(100, 290, 200, 30);
        add(Education);

        qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315, 200, 30);
        add(qualification);

        String Edu_values[] = {"Non-Graduation", "Graduation", "Post Graduation", "Doctrate", "other"};
        Edu_qua = new JComboBox(Edu_values);
        Edu_qua.setBounds(300, 315, 400, 30);
        Edu_qua.setBackground(Color.WHITE);
        add(Edu_qua);

        Occupation = new JLabel("Occupation: ");
        Occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        Occupation.setBounds(100, 390, 200, 30);
        add(Occupation);

        String occupationVal[] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "other"};
        occupation = new JComboBox(occupationVal);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        pan = new JLabel("PAN Number: ");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);

        panText = new JTextField();
        panText.setFont(new Font("Raleway", Font.BOLD, 14));
        panText.setBounds(300, 440, 400, 30);
        add(panText);

        Aadhar = new JLabel("Aadhar Number: ");
        Aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        Aadhar.setBounds(100, 490, 200, 30);
        add(Aadhar);

        aadharText = new JTextField();
        aadharText.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharText.setBounds(300, 490, 400, 30);
        add(aadharText);

        Senior = new JLabel("Senior Citizen: ");
        Senior.setFont(new Font("Raleway", Font.BOLD, 20));
        Senior.setBounds(100, 540, 200, 30);
        add(Senior);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 120, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup citizengroup = new ButtonGroup();
        citizengroup.add(syes);
        citizengroup.add(sno);

        Existing_acc = new JLabel("Existing Account: ");
        Existing_acc.setFont(new Font("Raleway", Font.BOLD, 20));
        Existing_acc.setBounds(100, 590, 200, 30);
        add(Existing_acc);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        eyes.addActionListener(this);
        add(eyes);

        acc_type = new JLabel("Account Type ");
        acc_type.setFont(new Font("Raleway", Font.BOLD, 20));
        acc_type.setBounds(120, 640, 200, 30);
        add(acc_type);
        acc_type.setVisible(false);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        eno.addActionListener(this);
        add(eno);

        ButtonGroup accgroup = new ButtonGroup();
        accgroup.add(eyes);
        accgroup.add(eno);

        String[] accounts = {"", "Saving", "Current", "FD", "Recurring", "Joint"};
        existingBox = new JComboBox<>(accounts);
        existingBox.setBounds(450, 640, 200, 30);
        add(existingBox);
        existingBox.setVisible(false);

        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setForeground(Color.WHITE);
        next.setBounds(620, 720, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == eyes) {

            acc_type.setVisible(true);
            existingBox.setVisible(true);

        } else if (e.getSource() == eno) {
            acc_type.setVisible(false);
        } else if (e.getSource() == next) {
            String sreligion = (String) religion.getSelectedItem();
            String scategory = (String) Category.getSelectedItem();
            String sIncome = (String) Income.getSelectedItem();
            String seducation = (String) Edu_qua.getSelectedItem();
            String soccupation = (String) occupation.getSelectedItem();
            selected = (String) existingBox.getSelectedItem();

            String seniorcitizen = null;
            if (syes.isSelected()) {
                seniorcitizen = "Yes";
            } else if (sno.isSelected()) {
                seniorcitizen = "No";
            }

            String existingacc = null;
            if (eyes.isSelected()) {
                existingacc = "Yes";
            } else if (eno.isSelected()) {
                existingacc = "No";
            }
            String pan = panText.getText();
            String aadhar = aadharText.getText();

            if (aadhar.length() < 12 || aadhar.length() > 12) {
                JOptionPane.showMessageDialog(this, "Aadhar number must be 12 digits.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Conn c = new Conn();
                String query = " insert into signuptwo(Religion, Category, Income, Education, Occupation, PAN, Aadhar, SeniorCitizen, ExistanceAccount) values('" + sreligion + "', '" + scategory + "', '" + sIncome + "','" + seducation + "', '" + soccupation + "','" + pan + "', '" + aadhar + "', '" + seniorcitizen + "', '" + existingacc + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupThree(formno, selected).setVisible(true);
            } catch (Exception a) {
                System.out.println(a);
            }
        }

    }

    public static void main(String args[]) {
        new SignupTwo("");
    }

}
