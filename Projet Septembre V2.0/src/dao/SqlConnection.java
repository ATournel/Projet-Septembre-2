package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class SqlConnection {

	public Connection SqlConectionStart() {

		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/eventTech?useSSL=false";
			String user = "root";
			String pwd = "Ioplop88";

			con = (Connection) DriverManager.getConnection(url, user, pwd);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

}
