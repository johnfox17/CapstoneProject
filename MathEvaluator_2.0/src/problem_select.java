
import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.Iterator;
import java.util.LinkedHashSet;
//import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class problem_select
 */
@WebServlet("/problem_select")
public class problem_select extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LinkedHashSet<String> problemList = new LinkedHashSet<String>();

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
		// TODO Auto-generated method stub
		try {
			// Accessing the session information
			HttpSession session = request.getSession();
			String problem = session.getAttribute("problem").toString();

			
			//session.setAttribute("problemList", problemList);
			System.out.println(problem);
			
			//System.out.println(itrProblem.next());
			ServletContext sc = getServletContext();
			sc.getRequestDispatcher("/problem_display.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Hello yeah yeah");
	}

	
	
}
