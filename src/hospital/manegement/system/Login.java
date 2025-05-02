package hospital.manegement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1 ,b2;
    Login(){
        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40,20,110,40);
        namelabel.setFont(new Font("Tahoma",Font.BOLD,18));
        namelabel.setForeground(Color.black);
        add(namelabel);
        JLabel password = new JLabel("Password");
        password.setBounds(40,80,110,40);
        password.setFont(new Font("Tahoma",Font.BOLD,18));
        password.setForeground(Color.black);
        add(password);
        textField = new JTextField();
        textField.setBounds(150,20,150,40);
        textField.setFont(new Font("Tahoma",Font.PLAIN,16));
        textField.setBackground(new Color(255,179,0));
        add(textField);
jPasswordField = new JPasswordField();
jPasswordField.setBounds(150,80,150,40);
jPasswordField.setFont(new Font("Tahoma",Font.PLAIN,16));
     jPasswordField.setBackground(new Color(255,179,0));
add(jPasswordField);

ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/HospitalSymbole-removebg-preview.png"));
Image i1 = imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
ImageIcon imageIcon1 = new ImageIcon(i1);
JLabel label = new JLabel(imageIcon1);
label.setBounds(360,-20,400,300);
add(label);
b1= new JButton("Login");
b1.setBounds(40,140,120,30);
b1.setFont(new Font("serif",Font.BOLD,15));
b1.setBackground(Color.black);
b1.setForeground(Color.white);
b1.addActionListener(this);
add(b1);
        b2= new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);


        getContentPane().setBackground(new Color(109,164,170));
 setSize(750,300);
 setLocation(400,270);
 setLayout(null);
 setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==b1){
             try {
                 Connec c = new Connec();
                 String user = textField.getText();

                 String pass= jPasswordField.getText();
                 String q = "select * from login where ID = '"+user+"' and  Pw= '"+pass+"'";
                 ResultSet resultSet = c.statement.executeQuery(q);
                 if(resultSet.next()){
                     new Reception();
                     setVisible(false);
                 }
                 else {
                     JOptionPane.showMessageDialog(null," Invalid");
                 }
             }
             catch (Exception E){
                 E.printStackTrace();
             }
         }
         else {
             System.exit(10);
         }


    }

    public static void main(String... args) {
        new Login();
    }
}
