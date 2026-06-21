import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.Statement;

class DatabaseConnection3{

    public static void main(String args[]){


            try {

                Driver d = new oracle.jdbc.driver.OracleDriver();
                DriverManager.registerDriver(d);
                System.out.println("Driver Register Successfully ! ");

                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","root");
                System.out.println("Connection Get Successfully ! ");   

                DatabaseMetaData dbmd = con.getMetaData();
                System.out.println("Database Information:");
                System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
                System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());
                System.out.println("Driver Name: " + dbmd.getDriverName());
                System.out.println("Driver Version: " + dbmd.getDriverVersion());

                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from stud"); 

                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                System.out.println("Table Information:");
                System.out.println("Number of Columns: " + columnCount);
                System.out.println("Column Names and Types:");
                System.out.println("-------------------------");
                System.out.println("Column Count: " + columnCount);
                System.out.println("Column Names and Types:");
                System.out.println("-------------------------");
                System.out.println("Column Count: " + columnCount);
                System.out.println("Column Names and Types:");
                System.out.println("-------------------------");
                System.out.println("Column Count: " + columnCount);
                
                for (int i = 1; i <= columnCount; i++) {
                    System.out.println("Column " + i + ": " + rsmd.getColumnName(i) + " (Type: " + rsmd.getColumnTypeName(i) + ")");
                }

            } catch (SQLException e) {

                System.out.println("ERROR in connection "+e.getMessage());

            }

    }

}