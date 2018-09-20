package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EventsController;
import models.Event;

/**
 * Servlet implementation class EventDetail
 */
@WebServlet("/EventDetail")
public class EventDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idEvent = Integer.parseInt(request.getParameter("idEvent"));
		request.setAttribute("idEvent", idEvent);
		
		EventsController detailEventsController = new EventsController();
		Event detailedEvent = detailEventsController.detailEvents(request);
		
		request.setAttribute("detailedEvent", detailedEvent);
		
		request.getRequestDispatcher("/ficheEvent.jsp").forward(request, response);
		
	}

}
