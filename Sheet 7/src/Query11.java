import java.sql.*;
public class Query11 {
    public static void main(String[] args) {
    try {
            String myDriver = "com.mysql.cj.jdbc.Driver";
            Class.forName(myDriver);
            String myUrl = "jdbc:mysql://localhost/COMPANY_MODEL";
            String userName = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(myUrl, userName, password);
            System.out.println("Hello===================");
            
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            e.getStackTrace();
        }

        
    }
    
}
