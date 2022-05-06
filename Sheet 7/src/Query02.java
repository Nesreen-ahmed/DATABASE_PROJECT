
import java.sql.*;

public class Query02 {

    public static void main(String[] args) {
        try {
            String myDriver = "com.mysql.cj.jdbc.Driver";
            Class.forName(myDriver);
            String myUrl = "jdbc:mysql://localhost/COMPANY_MODEL";
            String userName = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(myUrl, userName, password);
            ResultSet rs2 = conn.createStatement().executeQuery("SELECT * FROM department");
            while (rs2.next()) {
                System.out.println("*************************" + rs2.getString("Dname")+"*************************");
                ResultSet rs1 = conn.createStatement().executeQuery("SELECT * FROM employee");
                
                while (rs1.next()) {
                    if (rs2.getInt("Dnumer") != rs1.getInt("Dno")) {
                    continue;
                }
                    System.out.println("" + rs1.getString("Fname")+"  "+rs1.getString("Dno"));
                }
            }
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            e.getStackTrace();
        }

    }

}
