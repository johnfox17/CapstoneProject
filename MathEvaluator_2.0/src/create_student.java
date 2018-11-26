
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class create_student
 */
@WebServlet("/create_student")
public class create_student extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Accessing the session information
			HttpSession session = request.getSession();
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Connection to the USA database
			// Connection con =
			// DriverManager.getConnection("jdbc:mysql://mydb.chkafory7bnl.us-east-1.rds.amazonaws.com","capstone","123456?!");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://mydbcapstone.chkafory7bnl.us-east-1.rds.amazonaws.com", "capstone", "123456?!");
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO dbDevil.students (`idstudents`, `name`,`age`, `level`) VALUES " + "(" + "\'"
					+ request.getParameter("ID").toString() + "\'" + "," + "\'"
					+ request.getParameter("name").toString() + "\'" + "," + "\'"
					+ request.getParameter("age").toString() + "\'" + "," + "\'" + '0' + "\'" + ")";
			int answer = stmt.executeUpdate(sql);
			if (answer == 1) {
				session.setAttribute("name", request.getParameter("name").toString());
				session.setAttribute("level", "0");
				session.setAttribute("problem", "");
				response.sendRedirect("lesson.jsp");
				System.out.println("The student was successfully added to the database system");
			}
		} catch (Exception e) {
			System.out.print(e);
		}
	}

}
