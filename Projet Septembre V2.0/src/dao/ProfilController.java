package dao;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ProfilController {

	public boolean addProfilPic(HttpServletRequest request) {
		boolean imgSuccess = false;

		SqlConnection imageCon = new SqlConnection();
		Connection con = (Connection) imageCon.SqlConectionStart();

		String imgUrl = (String) request.getAttribute("imageUrl");
		String pseudo = (String) request.getAttribute("pseudo");

		
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("UPDATE user SET img='" + imgUrl + "' WHERE pseudo='" + pseudo + "'");
			ps.executeUpdate();

			imgSuccess = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imgSuccess;
	}

}
