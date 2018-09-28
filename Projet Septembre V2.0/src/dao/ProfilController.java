package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import models.User;

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
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imgSuccess;
	}

	public User checkOtherProfil(HttpServletRequest request) {
		
		String otherPseudo = (String) request.getAttribute("otherPseudo");
		
		SqlConnection sqlCon = new SqlConnection();
		
		Connection con = sqlCon.SqlConectionStart();
		
		User otherUser = new User();
		
		try {
			Statement st = (Statement) con.createStatement();
			
			String sql = "SELECT * FROM user WHERE pseudo='"+otherPseudo+"'";
			
			ResultSet result = st.executeQuery(sql);
			
			while(result.next()) {
				
				otherUser.setPseudo(otherPseudo);
				otherUser.setPrenom(result.getString("prenom"));
				otherUser.setNom(result.getString("nom"));
				otherUser.setMail(result.getString("mail"));
				otherUser.setImgUrl(result.getString("img"));
				
			}
			
			if(otherUser.getImgUrl()==null) {
				otherUser.setImgUrl("images/ghost_person.png");
			}
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return otherUser;
		
	}
	
}
