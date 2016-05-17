 <%
    int x = 3;
   int y = 4;
   int sum=x+y;
%>
 
 
 
  <!DOCTYPE html> 
        <html> 
        <head> 
        <meta charset= "UTF-8 "> 
        <title>Insert title here</title> 
        </head> 
        <body> 

        <form action= "add" method= "post"> 
           <ul> 
        <li><label for= "x ">X:</label><input name= "x " /></li> 
        <li><label for= "y ">Y:</label><input name= "y " /></li> 
        
        </ul> 
        
        <p>
              <input type= "submit" value = "덧셈 " /> 
             <input type= "hidden" name= "sum " value = "sum " />
              <input type= "submit" name= "btn " value = "application " /> 
              <input type= "submit" name= "btn " value = "session " /> 
              <input type= "submit" name= "btn " value = "cookie " />
              </p> 

        </form> 
        <p>result :  
            <% out.println(sum); %>
        </p> 
        <p><a href= "mypage ">마이페이지</a></p> 
        </body> 
        </html> 