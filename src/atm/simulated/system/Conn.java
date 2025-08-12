package atm.simulated.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        try {
            c= DriverManager.getConnection("jdbc:mysql:///atmsimulatedsystem", "root", "password");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
