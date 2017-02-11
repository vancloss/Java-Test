<%@page import="com.prueba.beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="inc/style.css">
<link rel="stylesheet" type="text/css"
	href="inc/bootstrap/css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Prueba Tecnica</title>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-md-8 col-md-offset-2">
        <h1>Prueba Tecnica JAVA Servisoft S.A.S</h1>
</div>
</div>
		<div class="container-fluid">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
        	<form method="post" action="docsUser" class="form-inline">
        	<div class="form-group">
        	<select class="form-control" name ="select_user">
        	<%
            List<User> listUser = (List<User>) request.getAttribute("listUser");
            for(User u : listUser) {%>
            <option value="<%= u.getId() %>"><%= u.getFirstname() %></option>          
            <% } %>
        	</select>
        	</div>
        	<div class="form-group">
             <select class="form-control" name ="select_status">
             <option value="P">Pending</option>
             <option value="E">Evacuated</option>
             </select>
                          </div>
             <button type="submit" class="btn btn-primary">Display the documents</button>
        	</form>
        </div>
        </div>
        </div>
    </div>   
</body>
</html>