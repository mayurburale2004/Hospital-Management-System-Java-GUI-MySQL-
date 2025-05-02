package hospital.management.system;

import hospital.manegement.system.Connec;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdatePatientDetails extends JFrame {

    public UpdatePatientDetails() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/img.png"));
        Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124, 11, 260, 25);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25, 88, 100, 14);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248, 85, 140, 25);
        panel.add(choice);

        try {
            Connec c = new Connec();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM patient_info");
            while (resultSet.next()) {
                choice.add(resultSet.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(25, 129, 150, 14);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textField = new JTextField();
        textField.setBounds(248, 129, 140, 20);
        panel.add(textField);

        JLabel label4 = new JLabel("In-Time :");
        label4.setBounds(25, 174, 100, 14);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textField1 = new JTextField();
        textField1.setBounds(248, 174, 140, 20);
        panel.add(textField1);

        JLabel label5 = new JLabel("Amount Paid (Rs):");
        label5.setBounds(25, 216, 150, 20);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textField2 = new JTextField();
        textField2.setBounds(248, 216, 140, 20);
        panel.add(textField2);

        JLabel label6 = new JLabel("Pending Amount (Rs):");
        label6.setBounds(25, 261, 190, 20);
        label6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textField3 = new JTextField();
        textField3.setBounds(248, 261, 140, 20);
        panel.add(textField3);

        JButton check = new JButton("CHECK");
        check.setBounds(281, 378, 89, 23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "SELECT * FROM patient_info WHERE Name = '" + id + "'";

                try {
                    Connec c = new Connec();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    if (resultSet.next()) {
                        textField.setText(resultSet.getString("Room_Number"));
                        textField1.setText(resultSet.getString("Time"));
                        textField2.setText(resultSet.getString("Deposite"));

                        // Calculate pending amount
                        ResultSet resultSet1 = c.statement.executeQuery(
                                "SELECT * FROM Room WHERE room_no = '" + textField.getText() + "'");

                        if (resultSet1.next()) {
                            String price1 = resultSet1.getString("price");
                            double amountPaid = Double.parseDouble(price1) -
                                    (textField3.getText().isEmpty() ? 0 : Double.parseDouble(textField3.getText()));
                            textField3.setText(String.format("%.2f", amountPaid));
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error retrieving data");
                }
            }
        });

        JButton update = new JButton("UPDATE");
        update.setBounds(56, 378, 89, 23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connec c = new Connec();
                    String q = choice.getSelectedItem();
                    String room = textField.getText();
                    String time = textField1.getText();
                    String amount = textField2.getText();

                    c.statement.executeUpdate("UPDATE patient_info SET Room_Number = '" + room +
                            "', Time = '" + time + "', Deposite = '" + amount + "' WHERE Name = '" + q + "'");
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error updating data");
                }
            }
        });
        setUndecorated(true);
        setSize(950, 500);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);

    }

    public static void main(String[] args) {
        new UpdatePatientDetails();
    }
}
