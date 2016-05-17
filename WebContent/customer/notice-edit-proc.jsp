<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% request.setCharacterEncoding("UTF-8"); %>
    
 <%
 	String code=request.getParameter("c");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	String url="jdbc:oracle:thin:@211.238.142.251:1521:orcl";
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
	
	
	//게시글 등록부분
	String sql = "UPDATE NOTICE SET TITLE=?,CONTENT=? WHERE CODE=?";
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setString(1, title);
	pst.setString(2, content);
	pst.setString(3, code);
	
	pst.executeUpdate();
	
	
	response.sendRedirect("notice-detail.jsp?c="+code);
 
 
 
 %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>