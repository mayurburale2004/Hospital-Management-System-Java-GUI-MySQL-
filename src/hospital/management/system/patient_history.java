
package hospital.management.system;

import hospital.manegement.system.Connec;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class patient_history extends JFrame {

    public patient_history() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 940, 490);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JLabel heading = new JLabel("Patient History");
        heading.setBounds(350, 10, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        String[] columns = {"ID", "Number", "Name", "Gender", "Disease", "Room No", "In Time", "Out Time", "Deposit"};
        String[][] data = new String[50][9];

        try {
            Connec c = new Connec();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM discharged_patients");

            int i = 0;
            while (rs.next()) {
                data[i][0] = String.valueOf(rs.getInt("ID"));
                data[i][1] = rs.getString("Number");
                data[i][2] = rs.getString("Name");
                data[i][3] = rs.getString("Gender");
                data[i][4] = rs.getString("Patient_Disease");
                data[i][5] = rs.getString("Room_Number");
                data[i][6] = rs.getString("In_Time");
                data[i][7] = rs.getString("Out_Time");
                data[i][8] = rs.getString("Deposit");
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JTable table = new JTable(data, columns);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 50, 900, 400);
        panel.add(sp);

        JButton back = new JButton("Back");
        back.setBounds(400, 460, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);

        back.addActionListener(e -> setVisible(false));

        setUndecorated(true);
        setSize(960, 520);
        setLayout(null);
        setLocation(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new patient_history();
    }
}
