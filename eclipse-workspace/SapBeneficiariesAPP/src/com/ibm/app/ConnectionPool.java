package APP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionPool {
	private static ConnectionPool connectionPool;
	
	private ConnectionPool() {}
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ConnectionPool getInstance() {
		if(connectionPool == null) {
			connectionPool = new ConnectionPool();
		}
		return connectionPool;
		
	}
	public Connection getConnection(){
		
		Connection connection = null;
		String userNameDB = "root";
		String passwordDB = "root";
		String databaseURL = "jdbc:mysql://localhost:3306/sap?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow";
		try {
			connection = DriverManager.getConnection(databaseURL,userNameDB,passwordDB);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}	
	
	public void closeConnection(Connection con, PreparedStatement preparedStatement,ResultSet resultSet) {
		try {
			if (resultSet != null) {resultSet.close();}
			closeConnection(con, preparedStatement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		public void closeConnection(Connection con, PreparedStatement preparedStatement) {
			try {
				if (preparedStatement != null) {preparedStatement.close();}
				if (con != null) {con.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
}
