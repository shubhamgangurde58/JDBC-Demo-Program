import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class DBConnection7{

    public static void main(String args[]){

          
            try{
                    //Register the Driver
                    Driver d = new oracle.jdbc.driver.OracleDriver();
                    DriverManager.registerDriver(d);
                    System.out.println("Driver Registration Succesfully!!");
                    
                    //Get Connection
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
                    System.out.println("Get connection Succesfully!!!!");

                    //Create statement object 
                    Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    System.out.println("Statement Object Created Succefully!!!");

                    //Create PreparedStatement Object
                   // PreparedStatement pstmt = con.prepareStatement("insert into employeeInfo values(?,?,?)");
                    //System.out.println("Preapared Statement Object Created Succesfully!!");

                    // Scanner scanner = new Scanner(System.in);
                    // System.out.println("Enter the employee Id,name and salary:=");
                    // int id = scanner.nextInt();
                    // String name = scanner.next();
                    // int salary = scanner.nextInt();


                    //Execute the query
                   // stmt.executeUpdate("create table employeeInfo(eid number(5),ename varchar2(10),esalary number(5))");
                    //stmt.executeUpdate("insert into employeeInfo values("+id+",'"+name+"',"+salary+")");
                   //stmt.executeUpdate("delete from employeeInfo where eid=2");

                    // pstmt.setInt(1,id);
                    // pstmt.setString(2,name);
                    // pstmt.setInt(3,salary);
                    // pstmt.executeUpdate();
                    // System.out.println("Query Executed Succesfully!!!");

                    //Result Set to get data from database
                    ResultSet rs = stmt.executeQuery("select * from employeeInfo"); 
                    while(rs.next()){

                        System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3));

                    }

                    rs.first();
                    System.out.println("\nFirst Row="+rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3));

                    rs.last();
                     System.out.println("\nLast Row="+rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3));

                    rs.absolute(3);
                     System.out.println("\nAbsolute Row="+rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3));


                    //Close the connection
                    con.close();
                    System.out.println("Close Connection Succesfully!!!");

            }catch(SQLException ex){

                System.out.println("error in database connection "+ex.getMessage());

            }
              

    }
    
}