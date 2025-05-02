package hospital.manegement.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class All_Patient_Info extends JFrame
{
    All_Patient_Info(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);
        JTable table = new JTable();
        table.setBounds(10, 40, 900, 450);
        table.setFont(new Font("Tahoma", Font.BOLD, 10));
        table.setBackground(new Color(90, 156, 163));
        panel.add(table);
        try{
            Connec c= new Connec();
            String q ="select * from patient_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }
        catch (Exception e){
            e.printStackTrace();
        }
        JLabel label = new JLabel("ID");
        label.setBounds(12, 10, 70, 20);
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label);
        JLabel label1 = new JLabel("Number");
        label1.setBounds(124, 10, 70, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);
        JLabel label2 = new JLabel("Name");
        label2.setBounds(235, 10, 70, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);
        JLabel label3 = new JLabel(" Gender");
        label3.setBounds(345, 10, 70, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);
        JLabel label4 = new JLabel(" Disease");
        label4.setBounds(456, 10, 70, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);
        JLabel label5 = new JLabel(" Room Number");
        label5.setBounds(570, 10, 120, 20);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label5);
        JLabel label7 = new JLabel(" Time");
        label7.setBounds(685, 10, 150, 20);
        label7.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label7);
        JLabel label6 = new JLabel(" Deposite");
        label6.setBounds(792, 10, 70, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label6);
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




        setSize(900,600);
        setLocation(300,200);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
      new  All_Patient_Info();
    }
}
