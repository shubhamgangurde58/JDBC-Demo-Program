
import java.util.Scanner;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class DBConnection10{

	public static void main(String args[]){

		try{

			//Step 1:Register the Driver
			Driver d = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(d);
			System.out.println("Driver Register Succesfully!!");

			//Step 2:Get the Connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			System.out.println("Get Connection Succesfully!!");			

			//Step 3:Create Statement Object
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			System.out.println("Statement object Created Succesfully!!");

			PreparedStatement pstmt = con.prepareStatement("insert into mytable values(?,?)");
			System.out.println("PreparedStatement object is created!!");

			//Scanner scanner = new Scanner(System.in);
			//System.out.println("Enter the id and name :=");
			//int  id = scanner.nextInt();
			//String name  = scanner.next();

			//pstmt.setInt(1,id);
			//pstmt.setString(2,"name");
			//pstmt.executeUpdate();

			//Step 4:Execute the Query
			//stmt.executeUpdate("create table mytable(id number(5),name varchar2(10))");
			//stmt.executeUpdate("insert into mytable values(1,'vishal')");
			//stmt.executeUpdate("update mytable  set id=103 where name='satyam'");
			//stmt.executeUpdate("insert into  mytable values("+id+",'"+name+"')");
			//stmt.executeUpdate("delete from mytable where id=5");
			System.out.println("Query Execute Succesfully!!");

			ResultSet rs = stmt.executeQuery("select id,name from mytable");
			System.out.println("Access data from database using ResultSet!!!");
		
			while(rs.next()){
		
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\n");
			}

			rs.first();
			
				System.out.println("First Row Data="+rs.getInt(1)+"\t"+rs.getString(2)+"\n");
		
			rs.last();

				System.out.println("Last Row Data="+rs.getInt(1)+"\t"+rs.getString(2)+"\n");	

			rs.absolute(3);
				
				System.out.println("Absolute Row Data="+rs.getInt(1)+"\t"+rs.getString(2)+"\n");

			//Update data

			rs.absolute(2);
				System.out.println("Before Updating the data of 2nd row="+rs.getInt(1)+"\t"+rs.getString(2)+"\n"); 
				rs.updateInt("id",102);
				rs.updateString("name","kunal");		
				rs.updateRow();	
				System.out.println("After Updating the data of 2nd row="+rs.getInt(1)+"\t"+rs.getString(2)+"\n"); 

			//new data insert into database
			rs.first();
			System.out.println("Before inserting a new record !!");
			while(rs.next()){
		
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\n");
			}
		
			rs.moveToInsertRow();
			rs.updateInt(1,107);
			rs.updateString(2,"rashi");
			rs.insertRow();
			rs.moveToCurrentRow();

			rs.first();
			System.out.println("After inserting a new record !!");
			while(rs.next()){
		
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\n");
			}


			//Step 5:Close the Connection
			con.close();
			System.out.println("Connection close Succesfully!!");	

	
		}catch(SQLException ex){

			System.out.println("error in database connection"+ex.getMessage());
	
		}	
	
	}
}