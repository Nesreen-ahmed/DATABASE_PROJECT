import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class main {

    
    public static void main(String[] args) {
        try {
            String myDriver = "com.mysql.cj.jdbc.Driver";
            Class.forName(myDriver);
            String myUrl = "jdbc:mysql://localhost/COMPANY_MODEL";
            String userName = "root";
            String password = "";
            try {
                Connection conn = DriverManager.getConnection(myUrl, userName, password);
            } catch (SQLException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
}
