package hospital.manegement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class patient_discharge extends JFrame {
    patient_discharge(){
        JPanel panel =new JPanel();
        panel.setBounds(5, 5, 790, 390);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/dis.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel labeld = new JLabel(imageIcon1);
        labeld.setBounds(550,150,200,200);
        panel.add(labeld);
        JLabel label = new JLabel("CHECK-OUT");
        label.setBounds(100, 20, 150, 20);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.setForeground(Color.white);
        panel.add(label);
        JLabel label1 = new JLabel("Customer Id");
        label1.setBounds(30, 80, 150, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        label1.setForeground(Color.white);
        panel.add(label1);
        Choice choice = new Choice();
        choice.setBounds(200, 80, 150, 25);
        panel.add(choice);
        try {
            Connec c = new Connec();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()){
                choice.add(resultSet.getString("number"));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }




        JLabel label2 = new JLabel("Room Number");
        label2.setBounds(30, 130, 150, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        label2.setForeground(Color.white);
        panel.add(label2);
        JLabel label3 = new JLabel();
        label3.setBounds(200, 130, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 20));
        label3.setForeground(Color.white);
        panel.add(label3);
        JLabel label4 = new JLabel("In Time");
        label4.setBounds(30, 180, 150, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        label4.setForeground(Color.white);
        panel.add(label4);
        JLabel INTime = new JLabel();
        INTime.setBounds(200,180,250,20);
        INTime.setFont(new Font("Tahoma",Font.BOLD,14));
        INTime.setForeground(Color.white);
        panel.add(INTime);
        JLabel label6 = new JLabel("Out Time");
        label6.setBounds(30, 230, 150, 20);
        label6.setFont(new Font("Tahoma", Font.BOLD, 14));
        label6.setForeground(Color.white);
        panel.add(label6);
        Date date = new Date();


        JLabel label7 = new JLabel(""+date);
        label7.setBounds(200, 230, 220, 20);
        label7.setFont(new Font("Tahoma", Font.BOLD, 14));
        label7.setForeground(Color.white);
        panel.add(label7);
        JButton Dis = new JButton("Discharge");
        Dis.setBounds(30, 300, 120, 30);
        Dis.setBackground(Color.black);
        Dis.setForeground(Color.WHITE);
        panel.add(Dis);
        Dis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connec c = new Connec();
                try {


                    c.statement.executeUpdate("delete from patient_info where number = '" + choice.getSelectedItem() + "'");
                    c.statement.executeUpdate("update room set Availability = 'Available' where room_no = '" + label3.getText() +
                            "'");
                    JOptionPane.showMessageDialog(null, "Done");
                    setVisible(false);
                }
                catch (Exception E){
                    E.printStackTrace();
                }
            }
        });



        JButton check = new JButton("Check");
        check.setBounds(170, 300, 120, 30);
        check.setBackground(Color.black);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connec c = new Connec();
                try {
                    ResultSet resultSet = c.statement.executeQuery("select * from  patient_info where number = '"+choice.getSelectedItem()+"'");

                    while (resultSet.next()){
                        label3.setText(resultSet.getString("Room_Number"));
                        INTime.setText(resultSet.getString("Time"));
                    }
                }
                catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        JButton cback = new JButton("Back");
        cback.setBounds(300, 300, 120, 30);
        cback.setBackground(Color.black);
        cback.setForeground(Color.WHITE);
        panel.add(cback);
        cback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

            }
        });


        setUndecorated(true);
        setSize(800, 400);
        setLayout(null);
        setLocation(400, 250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new patient_discharge();

    }
}