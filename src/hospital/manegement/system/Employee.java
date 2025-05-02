package hospital.manegement.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee extends JFrame {
    Employee(){
        setSize(1000,600);
        setLocation(350,230);
        JPanel panel = new JPanel();
                panel.setBounds(5,5,990,590);
                panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        JTable table = new JTable();
        table.setBounds(10, 54, 980, 450);
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        table.setBackground(new Color(109, 164, 170));
        panel.add(table);
        try{
            Connec c = new Connec();
            String q = "select * from Employee";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        }
        catch (Exception e){
            e.printStackTrace();
        }
        JLabel label = new JLabel("Name");
        label.setBounds(14, 15, 70, 20);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label);
        JLabel label1 = new JLabel("Age");
        label1.setBounds(178, 15, 70, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);
        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(342, 15, 150, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);
        JLabel label3 = new JLabel("Salary");
        label3.setBounds(502, 15, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);
        JLabel label4 = new JLabel("Gmail");
        label4.setBounds(663, 15, 150, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);
        JLabel label5 = new JLabel("Adhar Number");
        label5.setBounds(830, 15, 150, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label5);
        JButton b1 =new JButton("Back");
        b1.setBounds(350, 500, 120, 30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        setUndecorated(true);
        add(panel);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
  new Employee();
    }
}
