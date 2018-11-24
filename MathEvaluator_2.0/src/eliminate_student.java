

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
 * Servlet implementation class eliminate_student
 */
@WebServlet(description = "This servlet's function is to eliminate students from database", urlPatterns = { "/eliminate_student" })
public class eliminate_student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection to the USA database
			//Connection con = DriverManager.getConnection("jdbc:mysql://mydb.chkafory7bnl.us-east-1.rds.amazonaws.com","capstone","123456?!");
			Connection con = DriverManager.getConnection("jdbc:mysql://mydbcapstone.chkafory7bnl.us-east-1.rds.amazonaws.com","capstone","123456?!");
			Statement stmt = con.createStatement();
			String sql = "DELETE from dbDevil.students WHERE `idstudents`=" + "\'"+request.getParameter("ID").toString() + "\'";
					
			int answer = stmt.executeUpdate(sql);
			if (answer == 1) {
				System.out.println("You were able to successfully eliminate the students!");
			}
			response.sendRedirect("eliminate_student.jsp");

		} catch (Exception e) {
			System.out.print("Student was not located. Try another student ID");
		}

	}

}
