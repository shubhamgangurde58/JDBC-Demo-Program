
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

class DBConnection4{

	public static void main(String args[]){
	
		try{
			//Step.1 Register the Driver
			Driver d = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(d);
			System.out.println("Driver Registraction Succesfully...");
	
			//Step.2 Get Connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","root");
			System.out.println("Get Connection Succesfully...");

			//Step.3 Create Statement Object
			Statement stmt = con.createStatement();	
			System.out.println("Statement object created Succesfully..");

			//Step.4 Execute the Query
			//stmt.executeUpdate("create table imrdInfo(id number(3),name varchar2(10))");
			stmt.executeUpdate("insert into imrdInfo values(5,'darshan')");
			stmt.executeUpdate("delete from imrdInfo where id=5");
			System.out.println("Query Executed Succesfully..");	

			ResultSet rs = stmt.executeQuery("select * from imrdInfo");	
			
			//System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
		
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
			}	
			
			//rs.last();
			//System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
			

			//Step.5 close the Connection 
			stmt.close();
			System.out.println("Connection close..");

		}
		catch(SQLException ex){

			System.out.println("error in database connection..");
	
		}
	}

}