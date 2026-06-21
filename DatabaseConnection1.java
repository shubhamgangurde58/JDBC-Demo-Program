

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;


class DatabaseConnection1{

    public static void main(String args[]){

            try{

                //Step 1 : Register the Driver
                Driver d = new oracle.jdbc.driver.OracleDriver();
                DriverManager.registerDriver(d);
                System.out.println("Driver Register Successfully ! ");


                //Step 2 : Get the Connection
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","root");
                System.out.println("Get Connection Successfully ! ");

                //Step 3 : Create Statement Object
                //Statement stmt = con.createStatement();
                //System.out.println("Statement object create Successfully ! ");

                PreparedStatement pstmt = con.prepareStatement("select id,name from stud",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                // PreparedStatement pstmt = con.prepareStatement("select * from stud");
                System.out.println("PreparedStatement Object Created Successfully ");

                // Scanner sc = new Scanner(System.in);
                // System.out.println("Enter the Stud ID & Name  : ");
                // int id = sc.nextInt();
                // String name = sc.next();

                // pstmt.setInt(1, id);
                // pstmt.setString(2, name);

                //Step 4 : Executed the query
                //stmt.executeUpdate("create table stud(id number(10), name varchar2(20))");
                //stmt.executeUpdate("insert into stud values("+id+",'"+name+"')");

                ResultSet rs = pstmt.executeQuery();
                System.out.println("*** Stud Table ****\n");
                while(rs.next()){
                    System.out.println("ID  : "+rs.getInt(1)+"\t"+"Name : "+rs.getString(2));
                }
                //System.out.println("\nTable Create Sucessfully ! ");

                rs.first();
                System.out.println("\n First Row ID : "+rs.getInt(1)+"\t"+" Name : "+rs.getString(2));

                rs.last();
                System.out.println("\n last Row ID : "+rs.getInt(1)+"\t"+" Name : "+rs.getString(2));
                
                rs.absolute(2);
                System.out.println("\n 2 Row ID : "+rs.getInt(1)+"\t"+" Name : "+rs.getString(2));
                
                //rs.updateString("NAME", "gopal");
                //rs.updateRow();

                rs.moveToInsertRow();
                rs.updateInt("ID", 110);
                rs.updateString("NAME","ROHIT");
                rs.insertRow();
                rs.moveToCurrentRow();
    


                //Step 5 : Close the Connection
                con.close();
                System.out.println("Connection close Successfully ! ");
    

            }catch(SQLException ex){

                System.out.println("ERROR in Connection ! "+ex.getMessage());

            }


    }

}