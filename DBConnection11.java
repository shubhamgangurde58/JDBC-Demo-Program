
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;


class DBConnection11{

    public static void main(String args[]){

        try{

             Driver d = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(d);
            System.out.println("Driver Register succesfully!!");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
            System.out.println("Get connection Succesfully!!");

            CallableStatement cstmt = con.prepareCall("{CALL myProcedure1(?,?)}");

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id and name=");
		int id = sc.nextInt();
		String name = sc.next();

            cstmt.setInt(1,id);
            cstmt.setString(2,name);

            cstmt.execute();
            System.out.println("Procedure Executed Succesfully!!!!");

            con.close();
            System.out.println("Connection close Succesfully!!");



        }catch(SQLException ex){

                System.out.println("error in database connection"+ex.getMessage());

        }
          
    }

}