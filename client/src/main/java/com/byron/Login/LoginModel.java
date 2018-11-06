package com.byron.Login;

import com.byron.CreateAccount.userInfo;
import com.byron.dbConn.DatabaseConnection;

import java.sql.*;

public class LoginModel { //responsible for connecting to the database
	Connection connection;
	public static int rowNum;
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
	public boolean isLogin(String user, String pass) throws Exception{ //checks the string in usernameField and passwordField with database
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="SELECT * FROM login where username = ? and password = ?";

				
		try {
			ps= this.connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user);
			ps.setString(2, pass);

			rs = ps.executeQuery();
			rowNum =rs.getInt(3);

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
