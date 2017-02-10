<%@page import="com.prueba.beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
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
        	<form method="post" action="ListDocumentbyUserServlet">
        	<select name ="select_user">
        	<%
            List<User> listUser = (List<User>) request.getAttribute("listUser");
            for(User u : listUser) {%>
            <option value="<%= u.getId() %>"><%= u.getFirstname() %></option>
            
            <%
}
%>
        	</select>
             <select name ="select_status">
             <option value="P">Pendiente</option>
             <option value="E">Evacuado</option>
             </select>
             <input type="submit" value="Display the documents">
        	</form>
    </div>   
    </center>
</body>
</html>