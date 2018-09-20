package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConnectionController;

/**
 * Servlet implementation class ConnectionCreate
 */
@WebServlet("/ConnectionCreate")
public class ConnectionCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnectionCreate() {
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
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String pseudo = request.getParameter("pseudo");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");

		request.setAttribute("nom", nom);
		request.setAttribute("prenom", prenom);
		request.setAttribute("pseudo", pseudo);
		request.setAttribute("mail", mail);
		request.setAttribute("pass", pass);

		ConnectionController signUpControl = new ConnectionController();

		boolean pseudoLibre = signUpControl.connectionCreation(request);

		if (pseudoLibre) {
			response.sendRedirect("HomePage");
		} else {
			request.setAttribute("invalid", "Pseudo déjà pris!");
			request.getRequestDispatcher("/singUpForm.jsp").forward(request, response);
		}
	}

}
