package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EventsController;
import models.Event;

/**
 * Servlet implementation class EventsPage
 */
@WebServlet("/EventsPage")
public class EventsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EventsPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EventsController pageEventsController = new EventsController();

		ArrayList<Event> EventPage = pageEventsController.fullPageEvents(request);
		String titre = "Tous les évenements:";
		request.setAttribute("EventPage", EventPage);
		request.setAttribute("titre", titre);
		
		request.getRequestDispatcher("eventPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EventsController filteredEventsController = new EventsController();

		String searchNom = request.getParameter("eventNameSearch");
		String searchType = request.getParameter("categorie");

		request.setAttribute("searchNom", searchNom);
		request.setAttribute("searchType", searchType);
		
		String titre = "Les évenements pour la recherche '"+searchNom+"' dans la catégorie '"+searchType+"' :";
		
		ArrayList<Event> pageEventList = filteredEventsController.filteredPageEvents(request);
		
		request.setAttribute("EventPage", pageEventList);
		request.setAttribute("titre", titre);
		
		request.getRequestDispatcher("eventPage.jsp").forward(request, response);

	}

}
