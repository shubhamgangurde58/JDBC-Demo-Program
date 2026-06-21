
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;

class DatabaseConnection2{

    public static void main(String args[])
    {

        try{
            //Step 1 : Register the Driver
            Driver d = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(d);
            System.out.println("Driver Register Successfully ! ");

            //Step 2 : Get the Connection
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","root");
            System.out.println("Connection Get Successfully ! ");

            //Step 3 : Create Statement object 
            //Statement stmt = con.createStatement();
            //System.out.println("Statement Object Created ");

            CallableStatement cstmt = con.prepareCall(" { CALL dbPro() }");
            System.out.println("Procedure Call Successfully ! ");

            //Step 4 : Executed the Query 
           // stmt.executeUpdate("insert into stud values(107,'raj')");
            //System.out.println("Query Executed Successfully ! ");
            cstmt.execute();

            //Step 5 : Close the Connection 
            con.close();
            System.out.println("Connection close Successfully ! ");

        }catch(SQLException ex){

            System.out.println("ERROR in Connection "+ex.getMessage());
        }


    }
}