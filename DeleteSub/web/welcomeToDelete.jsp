<%-- 
    Document   : welcomeToDelete
    Created on : Apr 6, 2017, 10:23:00 AM
    Author     : WIN10_M7
--%>

<%@page import="Servlet.ShowData"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Delete">
        <table border = "1">
            <tr><th>ID</th><th>Your Name</th><th>Surname</th><th>Delete</th></tr>
            
            <%ResultSet rs = ShowData.showData();%>
            <%while(rs.next()){%>
            <tr><td><%out.print(rs.getInt("id"));%></td><td><%out.print(rs.getString("yourname"));%></td><td><%out.print(rs.getString("surname"));%></td>
                <td><input type="checkbox" name = "DeleteBox" value="<%out.print(rs.getInt("id"));%>"></td> 
            </tr>
            <%}%> 
        </table>
        
        <input type="submit" onclick="location.reload(true)">
        </form>    
    </body>
</html>
