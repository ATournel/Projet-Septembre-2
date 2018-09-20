package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProfilController;

/**
 * Servlet implementation class AddProfilPic
 */
@WebServlet("/AddProfilPic")
public class AddProfilPic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProfilPic() {
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
		HttpSession session = request.getSession();
		
		String imageUrl = request.getParameter("userPic");
		String pseudo = request.getParameter("pseudo");
		
		request.setAttribute("imageUrl", imageUrl);
		request.setAttribute("pseudo", pseudo);

		ProfilController addImgController = new ProfilController();

		boolean imgSuccess = addImgController.addProfilPic(request);

		if (imgSuccess) {
					
			session.setAttribute("userImage", imageUrl);
			request.getRequestDispatcher("/userProfil.jsp").forward(request, response);
		} else {
			
			request.setAttribute("wrongUrl", "Veuillez renseigner une Url valide!");
			request.getRequestDispatcher("/addProfilPicForm.jsp").forward(request, response);
		}

	}

}
