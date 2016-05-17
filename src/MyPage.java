

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mypage")
public class MyPage extends HttpServlet {
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		
		ServletContext application = request.getServletContext();
		
		out.printf("application: %d <br />", application.getAttribute("sum"));
		out.write("session : 0 <br />");
		out.write("cookies : 0 <br />");
		out.write("<a href= \"add\">계산하기 </a>");
		
	}

}
