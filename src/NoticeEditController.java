import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

@WebServlet("/customer/notice-edit")
public class NoticeEditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String c = request.getParameter("c");
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String sql = "SELECT * FROM NOTICE WHERE CODE=\'" + c + "\'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			/* 임시변수 - 모델 (Model) */
			String title = "";
			String writer = "";
			Date regdate = null;
			int hit = 0;
			String content = "";

			if (rs.next()) {

				title = rs.getString("TITLE");
				regdate = rs.getDate("REGDATE");
				hit = rs.getInt("HIT");
				writer = rs.getString("WRITER");
				content = rs.getString("CONTENT");
			}

			request.setAttribute("code", c);
			request.setAttribute("title", title);
			request.setAttribute("regdate", regdate);
			request.setAttribute("hit", hit);
			request.setAttribute("writer", writer);
			request.setAttribute("content", content);

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("notice-edit.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String code = request.getParameter("code");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");

			// 게시글 등록부분
			String sql = "UPDATE NOTICE SET TITLE=?,CONTENT=? WHERE CODE=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, title);
			pst.setString(2, content);
			pst.setString(3, code);

			pst.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("notice-detail?c=" + code);
	}
}
