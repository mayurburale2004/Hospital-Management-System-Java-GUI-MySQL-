package hospital.manegement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class NEW_PATIENT extends JFrame implements ActionListener {
    JComboBox comboBox ;
    JTextField textFieldNumber,textname ,textFieldDiseas ,textFieldDepodite;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;
    JButton b1 ,b2;
    NEW_PATIENT(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Pationt.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel labelname =new JLabel("NEW PATIENT FORM");
        labelname .setBounds(118,11,260,53);
        labelname.setFont(new Font("tahoma", Font.BOLD, 20));
        panel.add(labelname);
        JLabel labelid =new JLabel("ID : ");
        labelid .setBounds(35,76,200,14);
        labelid.setFont(new Font("tahoma", Font.BOLD, 14));
        labelid.setForeground(Color.white);
        panel.add(labelid);
        comboBox = new JComboBox(new String[]{"Aadhar Card","Voter Id","Driving License"});
        comboBox.setBounds(271,73,150,20);
        comboBox.setBackground(new Color(3, 45, 48));
        comboBox.setFont(new Font("tahoma", Font.BOLD, 14));
        comboBox.setForeground(Color.white);
        panel.add(comboBox);

        JLabel labelnumber =new JLabel("Number : ");
        labelnumber.setBounds(35,111,200,14);
        labelnumber.setFont(new Font("tahoma", Font.BOLD, 14));
        labelnumber.setForeground(Color.white);
        panel.add(labelnumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        panel.add(textFieldNumber);

        JLabel labelname1 =new JLabel("Name : ");
        labelname1.setBounds(35,151,200,14);
        labelname1.setFont(new Font("tahoma", Font.BOLD, 14));
        labelname1.setForeground(Color.white);
        panel.add(labelname1);

        textname = new JTextField();
        textname.setBounds(271,151,150,20);
        panel.add(textname);

        JLabel labelgender =new JLabel("Gender : ");
        labelgender.setBounds(35,191,200,14);
        labelgender.setFont(new Font("tahoma", Font.BOLD, 14));
        labelgender.setForeground(Color.white);
        panel.add(labelgender);
        r1=new JRadioButton("Male");
        r1.setFont(new Font("tahoma", Font.BOLD, 14));
        r1.setForeground(Color.white);
        r1.setBackground(new Color(109, 164, 170));
        r1.setBounds(271,191,80,16);
        panel.add(r1);
        r2=new JRadioButton("Female");
        r2.setFont(new Font("tahoma", Font.BOLD, 14));
        r2.setForeground(Color.white);
        r2.setBackground(new Color(109, 164, 170));
        r2.setBounds(350,191,80,16);
        panel.add(r2);

        JLabel lableDiseas =new JLabel("Disease : ");
        lableDiseas .setBounds(35,231,200,14);
        lableDiseas.setFont(new Font("tahoma", Font.BOLD, 14));
        lableDiseas.setForeground(Color.white);

        panel.add(lableDiseas);
        textFieldDiseas = new JTextField();
        textFieldDiseas.setBounds(271,231,150,20);
        panel.add(textFieldDiseas);

        JLabel lablroom =new JLabel("Room : ");
        lablroom .setBounds(35,274,200,14);
        lablroom.setFont(new Font("tahoma", Font.BOLD, 14));
        lablroom.setForeground(Color.white);
        panel.add(lablroom);
        c1 = new Choice();
        try{
            Connec c = new Connec();
            ResultSet resultSet = c.statement.executeQuery("select *  from Room");
            while (resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        c1.setBounds(271,274,150,20);
        c1.setFont(new Font("tahoma", Font.BOLD, 14));
        c1.setBackground(new Color(3,45,48));
    c1.setForeground(Color.white);
        panel.add(c1);
        JLabel labldate =new JLabel("Time : ");
        labldate.setBounds(35,316,200,14);
        labldate.setFont(new Font("tahoma", Font.BOLD, 14));
        labldate.setForeground(Color.white);
        panel.add(labldate);
        Date  date1 = new Date();
        date= new JLabel(""+date1);
        date.setBounds(271,316,250,14);
        date.setFont(new Font("tahoma", Font.BOLD, 14));
        date.setForeground(Color.white);
        panel.add(date);

        JLabel lableDieposite=new JLabel("Deposite : ");
        lableDieposite .setBounds(35,359,200,18);
        lableDieposite.setFont(new Font("tahoma", Font.BOLD, 14));
        lableDieposite.setForeground(Color.white);
        panel.add(lableDieposite);
        textFieldDepodite = new JTextField();
        textFieldDepodite.setBounds(271,359,150,20);
        panel.add(textFieldDepodite);
        b1 = new JButton("ADD");
        b1.setBounds(100,430,120,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.addActionListener(this);
        panel.add(b1);
        b2 = new JButton("Back");
        b2.setBounds(260,430,120,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        panel.add(b2);



        setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(300,250);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            Connec c = new Connec();
            String gender = r1.isSelected() ? "Male" : "Female";
            String idType = (String) comboBox.getSelectedItem();
            String idNumber = textFieldNumber.getText();
            String name = textname.getText();
            String disease = textFieldDiseas.getText();
            String roomNumber = c1.getSelectedItem();
            String timestamp = date.getText();
            String deposit = textFieldDepodite.getText();

            if (idNumber.isEmpty() || name.isEmpty() || disease.isEmpty() || deposit.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all required fields.");
                return;
            }

            try {
                // Insert patient data
                String insertQuery = "INSERT INTO patient_info (ID, Number, Name, Gender, Patient_Disease, " +
                        "Room_Number, Time, Deposite) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = c.connection.prepareStatement(insertQuery)) {
                    pstmt.setString(1, idType);
                    pstmt.setString(2, idNumber);
                    pstmt.setString(3, name);
                    pstmt.setString(4, gender);
                    pstmt.setString(5, disease);
                    pstmt.setString(6, roomNumber);
                    pstmt.setString(7, timestamp);
                    pstmt.setString(8, deposit);
                    pstmt.executeUpdate();
                }

                // Update room availability
                String updateQuery = "UPDATE Room SET Availability = 'Occupied' WHERE room_no = ?";
                try (PreparedStatement pstmt2 = c.connection.prepareStatement(updateQuery)) {
                    pstmt2.setString(1, roomNumber);
                    pstmt2.executeUpdate();
                }

                JOptionPane.showMessageDialog(null, "Patient added successfully.");
                setVisible(false);

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        } else if (e.getSource() == b2) {
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new NEW_PATIENT();
    }
}

