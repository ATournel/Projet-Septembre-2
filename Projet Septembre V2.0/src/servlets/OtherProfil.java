package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfilController;
import models.User;

/**
 * Servlet implementation class OtherProfil
 */
@WebServlet("/OtherProfil")
public class OtherProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtherProfil() {
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

		String otherPseudo = request.getParameter("otherUserPseudo");
		
		request.setAttribute("otherPseudo", otherPseudo);
		
		ProfilController otherProfil = new ProfilController();
		
		User otherUser = otherProfil.checkOtherProfil(request);
		
		request.setAttribute("otherUser", otherUser);
		
		request.getRequestDispatcher("/otherProfil.jsp").forward(request, response);
		
	}

}
