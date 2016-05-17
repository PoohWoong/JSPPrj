import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.answeris.web.model.Notice;

@WebServlet("/customer/notice-detail")
public class NoticeDetailController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//Controller
		String c = request.getParameter("c");
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String sql = "SELECT * FROM NOTICE WHERE CODE=\'" + c + "\'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			//Model
			Notice n= new Notice();

			if (rs.next()) {
				
				n.setCode(c);
				n.setTitle(rs.getString("TITLE"));
				n.setRegdate(rs.getDate("REGDATE"));
				n.setHit(rs.getInt("HIT"));
				n.setWriter(rs.getString("WRITER"));
				n.setContent(rs.getString("CONTENT"));
			}

			rs.close();
			st.close();
			con.close();
			
			request.setAttribute("n", n);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("notice-detail.jsp");
		dispatcher.forward(request, response);
	
	}

}
