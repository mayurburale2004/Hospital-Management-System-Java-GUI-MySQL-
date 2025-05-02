package hospital.manegement.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connec {

    Connection connection ;
    public Statement statement ;
    public  Connec(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system", "root","Mayur@123");
            statement = connection.createStatement();


        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Failed to establish connection!");
        }
    }
}
