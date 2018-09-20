package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import models.Event;

public class EventsController {

	public ArrayList<Event> homePageEvents(HttpServletRequest request) {

		ArrayList<Event> homeEventList = new ArrayList<Event>();

		SqlConnection homeCon = new SqlConnection();
		Connection con = homeCon.SqlConectionStart();

		try {
			Statement st = (Statement) con.createStatement();

			String sql = "SELECT * FROM evenement ORDER BY id_evenement DESC LIMIT 6";

			ResultSet result = st.executeQuery(sql);

			while (result.next()) {
				Event homeEvent = new Event();

				homeEvent.setId_evenement(result.getInt("id_evenement"));
				homeEvent.setId_createur(result.getInt("id_createur"));
				homeEvent.setNom(result.getString("nom"));
				homeEvent.setCategorie(result.getString("categorie"));
				homeEvent.setLieu(result.getString("lieu"));
				homeEvent.setDateDebutEvenement(result.getString("dateDebutEvenement"));
				homeEvent.setDateFinEvenement(result.getString("dateFinEvenement"));
				homeEvent.setHeureDebutEvenement(result.getString("heureDebutEvenement"));
				homeEvent.setHeurefinEvenement(result.getString("heurefinEvenement"));
				homeEvent.setDescription(result.getString("description"));
				homeEvent.setAge_mini(result.getInt("age_mini"));
				homeEvent.setCapacite(result.getInt("capacite"));

				homeEventList.add(homeEvent);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return homeEventList;
	}

	public Event detailEvents(HttpServletRequest request) {

		int idEvent = (int) request.getAttribute("idEvent");
		Event detailedEvent = new Event();

		SqlConnection detailCon = new SqlConnection();
		Connection con = detailCon.SqlConectionStart();

		try {
			Statement st = (Statement) con.createStatement();

			String sql = "SELECT * FROM evenement WHERE id_evenement='" + idEvent + "'";

			ResultSet result = st.executeQuery(sql);

			while (result.next()) {

				detailedEvent.setId_evenement(idEvent);
				detailedEvent.setId_createur(result.getInt("id_createur"));
				detailedEvent.setNom(result.getString("nom"));
				detailedEvent.setCategorie(result.getString("categorie"));
				detailedEvent.setLieu(result.getString("lieu"));
				detailedEvent.setDateDebutEvenement(result.getString("dateDebutEvenement"));
				detailedEvent.setDateFinEvenement(result.getString("dateFinEvenement"));
				detailedEvent.setHeureDebutEvenement(result.getString("heureDebutEvenement"));
				detailedEvent.setHeurefinEvenement(result.getString("heurefinEvenement"));
				detailedEvent.setDescription(result.getString("description"));
				detailedEvent.setAge_mini(result.getInt("age_mini"));
				detailedEvent.setCapacite(result.getInt("capacite"));

			}
			
			Statement st2 = (Statement) con.createStatement();
			
			String sql2 = "SELECT pseudo FROM user INNER JOIN evenement ON evenement.id_createur=user.id_user WHERE id_evenement='" + idEvent + "'";

			ResultSet result2 = st2.executeQuery(sql2);
			
			while(result2.next()) {
				detailedEvent.setPseudoCreateur(result2.getString("pseudo"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return detailedEvent;
	}
}
