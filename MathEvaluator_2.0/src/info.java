
import java.sql.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class info
 */
@WebServlet("/info")
public class info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection to the USA database
			//Connection con = DriverManager.getConnection("jdbc:mysql://mydb.chkafory7bnl.us-east-1.rds.amazonaws.com","capstone","123456?!");
			boolean found = false;
			HttpSession session = request.getSession();
			Connection con = DriverManager.getConnection("jdbc:mysql://mydbcapstone.chkafory7bnl.us-east-1.rds.amazonaws.com","capstone","123456?!");
			Statement stmt = con.createStatement();
			String sql = "select * from dbDevil.students where idstudents="+request.getParameter("ID").toString();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) 
			{
				if(Integer.toString(rs.getInt("idstudents")).equals(request.getParameter("ID").toString())) {
					//HttpSession session = request.getSession();
					session.setAttribute("name", rs.getString("name"));
					session.setAttribute("level", rs.getString("level"));
					session.setAttribute("problem", "");
					//response.sendRedirect("lesson.jsp");
					found = true;
				}				
			}
			
			sql = "select * from dbDevil.levels where level=" + session.getAttribute("level").toString();
			rs = stmt.executeQuery(sql);
			
			found = false;
			// iterating to find lesson name with lesson id
			while (rs.next()) {
				if (Integer.toString(rs.getInt("level")).equals(session.getAttribute("level").toString())) {
					session.setAttribute("chapter", rs.getString("chapter"));
					session.setAttribute("difficulty", rs.getString("difficulty"));
					found = true;
					System.out.println(session.getAttribute("lesson"));
				}
			}
			
			response.sendRedirect("lesson.jsp");
			if(!found) {
				System.out.println("Student was not found!");
				response.sendRedirect("index.jsp");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
