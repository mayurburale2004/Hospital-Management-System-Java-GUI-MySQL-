package hospital.manegement.system;

import hospital.management.system.UpdatePatientDetails;
import hospital.management.system.patient_history;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    Reception(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1525,970);
        panel.setBackground(new Color(109,164,170));
        add(panel);
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1525,150);
        panel1.setBackground(new Color(109,164,170));
        add(panel1);
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icon/Dr..jpg"));
        Image image =i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i2=  new ImageIcon(image);
        JLabel label = new JLabel(i2);

        label.setBounds(1300,0,250,250);
       panel1.add(label);

        ImageIcon i11 =new ImageIcon(ClassLoader.getSystemResource("icon/Hospital_name.png"));
        Image image1 =i11.getImage().getScaledInstance(600,250,Image.SCALE_DEFAULT);
        ImageIcon i22=  new ImageIcon(image1);
        JLabel label1 = new JLabel(i22);
        label1.setBounds(695,0,600,200);
        panel1.add(label1);

        JButton btn1 = new JButton("Add New Patient");
        btn1.setBounds(10,15,160,30);
        btn1.setBackground(new Color(246,215,118));
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NEW_PATIENT();
            }
        });

        JButton btn2 = new JButton("Room");
        btn2.setBounds(10,58,160,30);
        btn2.setBackground(new Color(246,215,118));
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();

            }
        });

        JButton btn3 = new JButton("Department");
        btn3.setBounds(10,100,160,30);
        btn3.setBackground(new Color(246,215,118));
        panel1.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             new Depatment();
            }
        });
        JButton btn4 = new JButton("All Employee Info");
        btn4.setBounds(180,15,160,30);
        btn4.setBackground(new Color(246,215,118));
        panel1.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
  new Employee();
            }
        });
        JButton btn5 = new JButton("Patient Info");
        btn5.setBounds(180,58,160,30);
        btn5.setBackground(new Color(246,215,118));
        panel1.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        new All_Patient_Info();
            }
        });
        JButton btn6 = new JButton("Patient Discharge");
        btn6.setBounds(180,100,160,30);
        btn6.setBackground(new Color(246,215,118));
        panel1.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new patient_discharge();

            }
        });
        JButton btn7 = new JButton("Update Patient Details");
        btn7.setBounds(350,15,160,30);
        btn7.setBackground(new Color(246,215,118));
        panel1.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              new UpdatePatientDetails();

            }
        });
        JButton btn8 = new JButton("Hospital Ambulance");
        btn8.setBounds(350,58,160,30);
        btn8.setBackground(new Color(246,215,118));
        panel1.add(btn8);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
     new Ambulance();
            }
        });
        JButton btn9 = new JButton("Search Room");
        btn9.setBounds(350,100,160,30);
        btn9.setBackground(new Color(246,215,118));
        panel1.add(btn9);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
          new SearchRoom();
            }
        });
        JButton btn10 = new JButton("Logout");
        btn10.setBounds(520,15,160,30);
        btn10.setBackground(new Color(246,215,118));
        panel1.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });

/*
        JButton btn11 = new JButton("Patient History");
        btn11.setBounds(520,58,160,30);
        btn11.setBackground(new Color(246,215,118));
        panel1.add(btn11);

        btn11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new patient_history();
            }
        });
*/


        setSize(1950,1090);
               getContentPane().setBackground(Color.white);
               setLayout(null);
               setVisible(true);
    }
    public static void main(String[] args) {
        new Reception();
    }
}
