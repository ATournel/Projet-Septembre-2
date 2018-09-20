package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import dao.SqlConnection;
import models.User;

public class ConnectionController {

	boolean connectionStatus;

	public boolean isConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(boolean connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	public boolean connectionStatusUpdate(HttpServletRequest request) {

		String pseudo = (String) request.getAttribute("pseudo");
		String mdp = (String) request.getAttribute("mdp");
		String sqlMdp = "";

		SqlConnection signInCheck = new SqlConnection();

		Connection con = (Connection) signInCheck.SqlConectionStart();

		try {
			Statement st = (Statement) con.createStatement();
			String sql = "SELECT mdp FROM user WHERE pseudo='" + pseudo + "'";

			ResultSet result = st.executeQuery(sql);

			while (result.next()) {
				sqlMdp = result.getString("mdp");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (mdp.equals(sqlMdp)) {
			connectionStatus = true;
		} else {
			connectionStatus = false;
		}

		return connectionStatus;

	}

	public boolean connectionCreation(HttpServletRequest request) {

		String nom = (String) request.getAttribute("nom");
		String prenom = (String) request.getAttribute("prenom");
		String mail = (String) request.getAttribute("mail");
		String pseudo = (String) request.getAttribute("pseudo");
		String pass = (String) request.getAttribute("pass");

		boolean pseudoLibre = true;

		SqlConnection signUpCheck = new SqlConnection();

		Connection con = (Connection) signUpCheck.SqlConectionStart();

		try {

			Statement st = (Statement) con.createStatement();
			String sql = "SELECT pseudo FROM user WHERE pseudo='" + pseudo + "'";

			ResultSet result = st.executeQuery(sql);

			while (result.next()) {
				pseudoLibre = false;

			}

			if (pseudoLibre) {

				SqlConnection signUpOk = new SqlConnection();

				Connection cn = (Connection) signUpOk.SqlConectionStart();

				PreparedStatement ps = (PreparedStatement) cn
						.prepareStatement("INSERT INTO user (nom, prenom, mail, pseudo, mdp) values ( ?, ?, ?, ?, ?)");

				ps.setString(1, nom);
				ps.setString(2, prenom);
				ps.setString(3, mail);
				ps.setString(4, pseudo);
				ps.setString(5, pass);

				int i = ps.executeUpdate();

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pseudoLibre;

	}

	public User connectionInfos(HttpServletRequest request) {

		SqlConnection infosConnection = new SqlConnection();
		
		Connection con = infosConnection.SqlConectionStart();
		String pseudo = (String) request.getAttribute("pseudo");
		User userInstance = new User();
		try {
			Statement st = (Statement) con.createStatement();

			String sql = "SELECT * FROM user WHERE pseudo='" + pseudo + "'";

			ResultSet result = st.executeQuery(sql);

			while (result.next()) {
				
				userInstance.setId(result.getInt("id_user"));
				userInstance.setPrenom(result.getString("prenom"));
				userInstance.setNom(result.getString("nom"));
				userInstance.setMail(result.getString("mail"));
				String imgUrl = result.getString("img");

				if (imgUrl != null) {
					userInstance.setImgUrl(imgUrl);
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userInstance;
	}

}
