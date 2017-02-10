<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.prueba.beans.User" %>
<%@ page import="com.prueba.beans.Document" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage d'un user</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
    	<% User user = (User) request.getAttribute("user"); %>
        <%-- Affichage de la chaîne "message" transmise par la servlet --%>
        <%-- Puis affichage des données enregistrées dans le bean "client" transmis par la servlet --%>
        <p>Firstname : <% user.getFirstname();%></p>
        <p>Password : <% user.getPassword();%></p>
        <p>Mail : <% user.getMail();%></p>
        <p>Identification Code : <% user.getCodeidentification();%></p>
        <p>Status : <% user.getStatus();%></p>
        <p>Date of expirement : <% user.getExpiration_date();%></p>

        
<table border="1" cellpadding="5">
            <caption><h2>List of Documents</h2></caption>
            <tr>
                <th>ID_Document</th>
                <th>Enter Date</th>
                <th>Exit Date</th>
                <th>Status</th>
                <th>Commentary</th>
            </tr>
            <%
            List<Document> listDocument = (List<Document>) request.getAttribute("listDocument");
            for(Document d : listDocument) {%>
<tr>
<td><%= d.getId() %></td>
<td><%= d.getEnter_date() %></td>
<td><%= d.getExit_date() %></td>
<td><%= d.getStatus() %></td>
<td><%= d.getCommentary() %></td>
</tr>
<%
}
%>
        </table>        
        
        
    </body>
</html>