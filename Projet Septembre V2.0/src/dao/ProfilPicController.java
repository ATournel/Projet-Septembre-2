package dao;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ProfilPicController {

	public boolean addProfilPic(HttpServletRequest request) {
		boolean imgSuccess = false;
		
		SqlConnection imageCon = new SqlConnection();
		Connection con = (Connection) imageCon.SqlConectionStart();

		String imgUrl = (String) request.getAttribute("userImage");
		String pseudo = (String) request.getAttribute("pseudo");

		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("INSERT INTO user (img) value (?) WHERE pseudo='" + pseudo + "'");
			ps.setString(1, imgUrl);
			
			imgSuccess = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imgSuccess;
	}

}
