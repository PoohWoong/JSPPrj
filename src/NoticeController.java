import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.answeris.web.dao.JdbcNoticeDao;
import net.answeris.web.model.Notice;

@WebServlet("/customer/notice")
public class NoticeController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int page=1;
		String field="TITLE";
		String query="";
		String _page = request.getParameter("pg");
		String _field=request.getParameter("f");
		String _query=request.getParameter("q");
		
		if(_page!=null && !_page.equals(""))
			page=Integer.parseInt(_page);
		if(_field!=null && !_field.equals(""))
			field=_field;
		if(_query!=null && !_field.equals(""))
			query=_query;

		List<Notice> list = new JdbcNoticeDao().getList(field, query, page);

		request.setAttribute("list", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("notice.jsp");
		dispatcher.forward(request, response);

	}

}
