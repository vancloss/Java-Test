<%@page import="com.prueba.beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.prueba.beans.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Prueba Tecnica</title>
</head>
<body>
<center>
        <h1>User Management</h1>
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
        	</form>
    </div>   
    </center>
</body>
</html>