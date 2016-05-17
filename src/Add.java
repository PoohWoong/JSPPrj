import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class Add extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
				
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
				
		int x=0;
		int y=0;
		int sum=0;
		String btn="";
				
		if(request.getMethod().equals("POST")){
			
			String _x=request.getParameter("x");
			String _y=request.getParameter("y");
			String _btn=request.getParameter("btn");
			String _sum=request.getParameter("sum");
						
			if(_btn !=null && !_btn.equals(""))
				btn=_btn;
			if(_x !=null&&!_x.equals(""))
				x=Integer.parseInt(_x);
			if(_y !=null&&!_y.equals(""))
				y=Integer.parseInt(_y);
			if(_sum!=null && !_sum.equals(""))
				sum=Integer.parseInt(_sum);
			if(btn.equals("application"))
			{
				ServletContext application = request.getServletContext();
				application.setAttribute("sum", 30);
			}else if(btn.equals("session")){
				HttpSession session = request.getSession();
				session.setAttribute("sum",sum);
			}
			else if(btn.equals("cookie")){
				Cookie cookie = new Cookie("sum", String.valueOf(sum));
				cookie.setMaxAge(5*60);
				response.addCookie(cookie);				
			}			
			else
			{
				sum=x+y;
			}
			
		}
		
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("	<meta charset=\"UTF-8\">");
		out.write("	<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action=\"add\" method=\"post\">");
		out.write("		<ul>");
		out.write("			<li><label for = \"x\">X:</label><input name=\"x\" /></li>");
		out.write("			<li><label for = \"y\">Y:</label><input name=\"y\" /></li>");				
		out.write("		</ul>");
				
		out.write("	<p>");
		out.write("		<input type=\"submit\" value=\"add\" />");
		out.write("		<input type=\"submit\" name=\"btn\" value=\"application\" />");
		//out.write("		<input type=\"submit\" name=\"btn-Session\" value=\"Session\" />");
		//out.write("		<input type=\"submit\" name=\"btn-Cookie\" value=\"Cookie\" />");
		out.write("	</p>");
		out.write("	</form>");
		out.write("	<p> result : ");
		out.write("</p>");
		out.println(sum);
		out.write("<p><a href=\"mypage\">마이페이지</a></p>");
		out.write("</body>");
		out.write("</html>");
		
		
		
	}

}
