package Login;

import dbConn.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel { //responsible for connecting to the database
	Connection connection;
	
	public LoginModel() {
		try {
			this.connection = DatabaseConnection.getConnection();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		if(this.connection == null) {
			System.exit(1);
		}
	}
	
	public boolean isConnected() { //checks to see if user is connected to database
		return this.connection != null;
	}
	public boolean isLogin(String user, String pass) throws Exception{ //checks the string in usernameFIeld and passwordField with database
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="SELECT * FROM login where username = ? and password = ?";
				
		try {
			ps= this.connection.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			
			rs = ps.executeQuery();
			
			boolean boll1;
			
			if(rs.next()) {
				return true;
			}
			return false;
		}
		catch (SQLException ex) {
			return false;
		}
		finally {
			ps.close();
			rs.close();
		}
	}
}
