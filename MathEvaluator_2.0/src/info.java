
import java.sql.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			Connection con = DriverManager.getConnection("jdbc:mysql://mydbcapstone.chkafory7bnl.us-east-1.rds.amazonaws.com","capstone","123456?!");
			Statement stmt = con.createStatement();
			String sql = "select * from dbDevil.students where idstudents="+request.getParameter("ID").toString();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) 
			{
				System.out.println(rs.getInt("idstudents")+"\t"+rs.getString("name")+"\t"+rs.getString("level"));
			}
		}catch(Exception e) {
			System.out.print(e);
		}
	}

}
