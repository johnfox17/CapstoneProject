
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class lesson
 */
@WebServlet(description = "The lesson is selected depending on the level of the student and presented for him to solve.", urlPatterns = {
		"/lesson" })
public class lesson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Accessing the session information
			HttpSession session = request.getSession();
			// creating connection to the database
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://mydbcapstone.chkafory7bnl.us-east-1.rds.amazonaws.com", "capstone", "123456?!");
			Statement stmt = con.createStatement();
			String sql = "select * from dbDevil.levels where level=" + session.getAttribute("level").toString();
			ResultSet rs = stmt.executeQuery(sql);
			boolean found = false;
			// iterating to find lesson name with lesson id
			while (rs.next()) {
				if (Integer.toString(rs.getInt("level")).equals(session.getAttribute("level").toString())) {
					session.setAttribute("lesson_name", rs.getString("name"));
					response.sendRedirect("problem_display.jsp");
					found = true;
					System.out.println(session.getAttribute("lesson_name"));
				}
			}
			if (!found) {
				System.out.println("Lesson was not found");
			}
			// here is where we should send lesson name to get number of available problems
			LinkedHashSet<Integer> num = problem_order();
			System.out.println(num);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//This function returns a linkedhashset of integers with a random order of problem set
	public LinkedHashSet<Integer> problem_order() {
		int num_problems=0;
		LinkedHashSet<Integer> prob_order = new LinkedHashSet<Integer>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://mydbcapstone.chkafory7bnl.us-east-1.rds.amazonaws.com", "capstone", "123456?!");
			Statement stmt = con.createStatement();
			
			// Calculate the number of problems available in specific lesson
			String sql = "SELECT COUNT(*) FROM dbDevil.integers";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				num_problems = rs.getInt("COUNT(*)");
			}
			
			//Create random order linkedhashset
			while(prob_order.size()<num_problems) {
				int randomNum = ThreadLocalRandom.current().nextInt(1, num_problems+1);
				prob_order.add(randomNum-1);	
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return prob_order;
	}
}
