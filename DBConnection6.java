
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class DBConnection6{

    public static void main(String args[]){

       try{

            //Step 1.register the Driver
                Driver d = new oracle.jdbc.driver.OracleDriver();
                DriverManager.registerDriver(d);
                System.out.println("Driver registration Succesfully !!!");

            //Step 2.get the Connection
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
                System.out.println("get Connection Succesfully !!");

            //Step 3.create Statement Object
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                System.out.println("Statement Object Created !!");

                // Scanner scanner = new Scanner(System.in);
                // System.out.println("Enter the eid , ename and esalary =");
                // int eid = scanner.nextInt();
                // String ename = scanner.next();
                // int esalary = scanner.nextInt();

           // Step 3.1 create prepareStatement Object
                PreparedStatement pstmt = con.prepareStatement("insert into employeeInfo values(?,?,?)");
                System.out.println("PreparedStatement Object Created !!");

                // pstmt.setInt(1,eid);
                // pstmt.setString(2,ename);
                // pstmt.setInt(3,esalary);
                // pstmt.executeUpdate();

            //Step 3.2 ResultSet 

            ResultSet rs = stmt.executeQuery("select eid,ename,esalary from employeeInfo1");
           
            while(rs.next()){
                      System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
            }


            rs.first();
             System.out.println("\nFirst value = "+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
            
            rs.last();
             System.out.println("\nLast value = "+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));

            rs.absolute(4);
             System.out.println("\nAbsolute value = "+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));


            rs.first();
            System.out.println("\nBefore Updating the value :");
             System.out.println("First value = "+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));


            //update data in table 
            // rs.updateInt("eid",1);
            // rs.updateString("ename","rohan");
            // rs.updateInt("esalary",15000);
            // rs.updateRow();
            // System.out.println("\nAfter Updating the value :");
            // System.out.println("First value = "+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));

            // insert data in table 
            // rs.moveToInsertRow();
            // rs.updateString(2,"dipak");
            // rs.moveToCurrentRow();
            
            //System.out.println("\nAfter inserting a new data :");
           // System.out.println("inserted row data  = "+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));

            

            //Step 4.Execute the Query
               //stmt.executeUpdate("create table employeeInfo(eid number(5),ename varchar2(10),esalary number(5))");
              //  stmt.executeUpdate("insert into employeeInfo values("+eid+",'"+ename+"',"+esalary+")");
              //  System.out.println("Query executed succesfully !!!!");

            //Step 5. close Connection 
                con.close();
                System.out.println("close Connection !!");

       }catch(SQLException ex ){

            System.out.println("error in database connection !!!"+ex.getMessage());

       }

    }

}