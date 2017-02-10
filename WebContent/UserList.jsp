<%@page import="com.prueba.beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.prueba.beans.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="inc/style.css">
<link rel="stylesheet" type="text/css" href="inc/bootstrap/css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Prueba Tecnica</title>
</head>
<body>
<center>
        <h1>Prueba Tecnica Servisoft S.A.S</h1>
        	<form>
        	<select>
        	<%
            List<User> listUser = (List<User>) request.getAttribute("listUser");
            for(User u : listUser) {%>
            <option value="<%= u.getId() %>"><%= u.getFirstname() %></option>
            
            <%
}
%>
        	</select>
        	<!--  Ancien code pour les liens vers les vues -->
        	<td><a href="/Prueba_tecnica/display?id=<%u.getId();%>&estado=P/>">Show Pendientes</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/Prueba_tecnica/display?id=<%u.getId();%>&estado=E/>">Show Evacuados</a>  </td>
             <!--  fin code -->
        	</form>
    </div>   
    </center>
</body>
</html>