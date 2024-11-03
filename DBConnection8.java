
import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.Statement;

class DBConnection8{

    public static void main(String args[]){

        try{

                Driver d = new oracle.jdbc.driver.OracleDriver();
                DriverManager.registerDriver(d);
                System.out.println("Driver Registration Succesfully!!!");

                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
                System.out.println("Get connection Succefully!!");

                Statement stmt = con.createStatement();
                System.out.println("Statement object Create Succesfully!!");

                DatabaseMetaData databasemetadata = con.getMetaData();
                System.out.println("DB version="+databasemetadata.getDatabaseProductVersion());
                System.out.println("DB Product name="+databasemetadata.getDatabaseProductName());
                System.out.println("DB Major version="+databasemetadata.getDatabaseMajorVersion());
                System.out.println("DB Minor version="+databasemetadata.getDatabaseMinorVersion());
                System.out.println("JDBC Major version="+databasemetadata.getJDBCMajorVersion());
                System.out.println("JDBC Minor version="+databasemetadata.getJDBCMinorVersion());
                System.out.println("\n----------------------------------------------\n");

                ResultSet rs = stmt.executeQuery("select * from employeeInfo");

                ResultSetMetaData resultsetmetadata = rs.getMetaData();
                System.out.println("Total Column = "+resultsetmetadata.getColumnCount());
                System.out.println("Column name="+resultsetmetadata.getColumnName(1)+"\t"+resultsetmetadata.getColumnName(2)+"\t"+resultsetmetadata.getColumnName(3));
                System.out.println("Column Type="+resultsetmetadata.getColumnType(1)+"\t"+resultsetmetadata.getColumnType(2)+"\t"+resultsetmetadata.getColumnType(3));
                System.out.println("Column Type Name="+resultsetmetadata.getColumnTypeName(1)+"\t"+resultsetmetadata.getColumnTypeName(2)+"\t"+resultsetmetadata.getColumnTypeName(3));
                


        }catch(SQLException ex){

            System.out.println("error in database connection"+ex.getMessage());

        }

    }

}