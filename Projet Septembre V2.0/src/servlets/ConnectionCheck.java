package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ConnectionController;
import models.User;

/**
 * Servlet implementation class ConnectionCheck
 */
@WebServlet("/ConnectionCheck")
public class ConnectionCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnectionCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("mdp");

		request.setAttribute("pseudo", pseudo);
		request.setAttribute("mdp", mdp);

		ConnectionController loginSession = new ConnectionController();
		boolean status = loginSession.connectionStatusUpdate(request);

		if (status) {
			HttpSession session = request.getSession();

			session.setAttribute("pseudo", pseudo);
			ArrayList<User> userList = loginSession.connectionInfos(request);
			session.setAttribute("nom", userList.get(0).getNom());
			session.setAttribute("prenom", userList.get(0).getPrenom());
			session.setAttribute("mail", userList.get(0).getMail());
			session.setAttribute("id", userList.get(0).getId());
			session.setAttribute("isConnected", true);
			
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		} else {
			request.setAttribute("status", "Mauvais Login ou Mot de Passe");
			request.getRequestDispatcher("/connectionForm.jsp").forward(request, response);
		}
	}

}
