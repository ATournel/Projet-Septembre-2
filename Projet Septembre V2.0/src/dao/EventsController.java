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
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return homeEventList;
	}

	public ArrayList<Event> fullPageEvents(HttpServletRequest request) {

		ArrayList<Event> homeEventList = new ArrayList<Event>();

		SqlConnection eventCon = new SqlConnection();
		Connection con = eventCon.SqlConectionStart();

		try {
			Statement st = (Statement) con.createStatement();

			String sql = "SELECT * FROM evenement ORDER BY id_evenement";

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
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return homeEventList;

	}

	public ArrayList<Event> filteredPageEvents(HttpServletRequest request) {

		String searchNom = (String) request.getAttribute("searchNom");
		String searchType = (String) request.getAttribute("searchType");
		SqlConnection eventCon = new SqlConnection();

		ArrayList<Event> pageEventList = new ArrayList<Event>();

		Connection con = eventCon.SqlConectionStart();

		try {
			Statement st = (Statement) con.createStatement();

			String sql = "SELECT * FROM evenement WHERE nom LIKE '%" + searchNom + "%' AND categorie='" + searchType
					+ "'";

			ResultSet result = st.executeQuery(sql);

			while (result.next()) {
				Event pageEvent = new Event();

				pageEvent.setId_evenement(result.getInt("id_evenement"));
				pageEvent.setId_createur(result.getInt("id_createur"));
				pageEvent.setNom(result.getString("nom"));
				pageEvent.setCategorie(result.getString("categorie"));
				pageEvent.setLieu(result.getString("lieu"));
				pageEvent.setDateDebutEvenement(result.getString("dateDebutEvenement"));
				pageEvent.setDateFinEvenement(result.getString("dateFinEvenement"));
				pageEvent.setHeureDebutEvenement(result.getString("heureDebutEvenement"));
				pageEvent.setHeurefinEvenement(result.getString("heurefinEvenement"));
				pageEvent.setDescription(result.getString("description"));
				pageEvent.setAge_mini(result.getInt("age_mini"));
				pageEvent.setCapacite(result.getInt("capacite"));

				pageEventList.add(pageEvent);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pageEventList;
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

			String sql2 = "SELECT pseudo FROM user INNER JOIN evenement ON evenement.id_createur=user.id_user WHERE id_evenement='"
					+ idEvent + "'";

			ResultSet result2 = st2.executeQuery(sql2);

			while (result2.next()) {
				detailedEvent.setPseudoCreateur(result2.getString("pseudo"));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return detailedEvent;
	}
}
