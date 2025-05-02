package hospital.manegement.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Depatment extends JFrame {
    Depatment(){
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 690, 490);

        panel.setLayout(null);
        panel.setBackground(new Color(90, 156, 163));
        add(panel);
        JTable table = new JTable();
        table.setBounds(0, 40, 700, 350);
        table.setFont(new Font("Tahoma", Font.BOLD, 14));
        table.setBackground(new Color(90, 156, 163));
        panel.add(table);
        try{
            Connec c =new Connec();
            String q = "select * from Department";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        }
        catch (Exception e){
            e.printStackTrace();
        }
        JLabel label1 = new JLabel("Department");
        label1.setBounds(145, 11, 105, 20);
label1.setFont(new Font("Tahoma", Font.BOLD, 14));
panel.add(label1);
        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(431, 11, 150, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);
        JButton btn = new JButton("Back");
        btn.setBounds(400, 410, 100, 20);
        btn.setForeground(Color.WHITE);
        btn.setBackground(Color.black);
        panel.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


setUndecorated(true);
        setSize(700, 500);
        setLayout(null);
        setLocation(350, 250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Depatment();
    }
}
