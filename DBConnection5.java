
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;

class DBConnection5{

	public static void main(String args[]){
	
		try{

			//Step 1. Register the Driver
			Driver d = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(d);
			System.out.println("Driver Register Succesfully...");

			//Step 2. Get Connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","root");
			System.out.println("Get Connection Succesfully..");

			//Step 3. Create Statement  Object
			Statement stmt = con.createStatement();
			System.out.println("Statement Object Created..");

			//Step 3.1 create PreparedStatement Object;
			PreparedStatement pstmt = con.prepareStatement("insert into empInfo values(?,?,?)");
			System.out.println("PreparedStatement Object Create ..");
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please Enter eid , ename and esalary=");
			int eid = scanner.nextInt();
			String ename = scanner.next();
			int esalary = scanner.nextInt();

			pstmt.setInt(1,eid);
			pstmt.setString(2,ename);
			pstmt.setInt(3,esalary);
			pstmt.executeUpdate();

			
			//Step 4. Executed the Query
			//stmt.executeUpdate("create table empInfo(eid number(2),ename varchar2(10),esalary number(10))");
			//stmt.executeUpdate("insert into empInfo values("+eid+",'"+ename+"',"+esalary+")");
			//stmt.executeUpdate("delete from empInfo where eid=3");
			System.out.println("Query Execute Succesfully.. ");

			//step 4.1 Get Data using ResultSet
			ResultSet rs = 	stmt.executeQuery("select eid,ename,esalary from empInfo");

			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
			}

			//Step 5. Close Connection
			con.close();
			System.out.println("Connection close Succesfully..");

		}catch(SQLException ex){

			System.out.println("error in database Connection...");
		}
				
	}
}