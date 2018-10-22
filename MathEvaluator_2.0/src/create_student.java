
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://mydbinstance.ciydcc3zf6bp.us-east-1.rds.amazonaws.com", "jfox",
					"j1234567?");
			Statement stmt = con.createStatement();
			String sql = "insert into CapstoneDB.students (`idstudents`, `name`, `level`) VALUES " + "(" + "\'"
					+ request.getParameter("ID").toString() + "\'" + "," + "\'"
					+ request.getParameter("name").toString() + "\'" + ","+"\'"
					+ '0' + "\'" +")";

			int answer = stmt.executeUpdate(sql);
			if (answer == 1) {
				System.out.println("The student was successfully added to the database system");
			}

		} catch (Exception e) {
			System.out.print(e);
		}
	}

}
