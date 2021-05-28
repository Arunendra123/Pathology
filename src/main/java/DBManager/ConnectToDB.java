package DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class ConnectToDB {
	Statement statement;
	Connection connection;
	public ConnectToDB(){
		this.statement=this.creatConnection();
	}  
    public Statement creatConnection() {
        String connectionUrl = "jdbc:sqlserver://10.204.103.84:1433;"
                        + "database=pathDB;"
                        + "user=sqlArun;"
                        + "password=Control123;"
                        + "loginTimeout=30;";
         try{
        		connection = DriverManager.getConnection(connectionUrl);
        		statement = connection.createStatement(); 
                return statement;
        }
        catch (SQLException e) {
            System.out.print("Unable to connect............");
            return null;
        }
    }
    
    public Statement getConnection(){
    	return this.statement;
    }
    
    public void close() {
    	try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.out.print("Unable to close DB connection");
		}
    }
}
