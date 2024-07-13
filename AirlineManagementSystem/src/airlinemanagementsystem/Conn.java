package airlinemanagementsystem;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
           //1.Register the driver
           Class.forName("com.mysql.cj.jdbc.Driver");
           //2.Create the connection string
           c=DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem","root","Rnazneen07#");
           //3.Create the statement
           s=c.createStatement();
           //4.Run the Mysql query
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
