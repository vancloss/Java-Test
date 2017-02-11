<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.prueba.beans.User"%>
<%@ page import="com.prueba.beans.Document"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="inc/style.css">
<link rel="stylesheet" type="text/css"
	href="inc/bootstrap/css/bootstrap.css">
<meta charset="utf-8" />
<title>View of a User with his documents</title>
</head>
<body>
	<%
		User user = (User) request.getAttribute("user");
	%>
	<%
		List<Document> listDocument = (List<Document>) request.getAttribute("listDocument");
	%>
	<div class="container-fluid grey">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<h1>User Information</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div>
					<label>Firstname :</label> <span><%=user.getFirstname()%></span>
				</div>
				<div>
					<label>Password :</label> <span><%=user.getPassword()%></span>
				</div>
				<div>
					<label>Mail :</label> <span><%=user.getMail()%></span>
				</div>
				<div>
					<label>Identification Code :</label> <span><%=user.getCodeidentification()%></span>
				</div>
				<div>
					<label>Status :</label> <span><%=user.getStatus()%></span>
				</div>
				<div>
					<label>Expiration date :</label> <span><%=user.getExpiration_date()%></span>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid white">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<h1>List of Documents</h1>
			</div>
			<div class="col-md-6 col-md-offset-3">
			<table class="table table-striped table-bordered" cellspacing="0" width="100%">
				<%
					if ("S".equals(user.getStatus())){
				            	if(!listDocument.isEmpty()){
				%>
				<thead>
				<tr>
					<th>ID_Document</th>
					<th>Enter Date</th>
					<th>Exit Date</th>
					<th>Status</th>
					<th>Commentary</th>
				</tr>
				</thead>
				<tbody>
				<%
					for(Document d : listDocument) {
				%>

				<tr>
					<td>
						<%
							out.print(d.getId());
						%>
					</td>
					<td><%=d.getEnter_date()%></td>
					<td><%=d.getExit_date()%></td>
					<td><%=d.getStatus()%></td>
					<td><%=d.getCommentary()%></td>
				</tr>
				<%
					}
				%>
				</tbody>
				<%
				            }
				       else{
				%>
				<div class="alert alert-danger">
					<strong>Error : </strong> No documents to display.
				</div>

				<%
					}  
				            	}
				        else {
				%>
				<div class="alert alert-danger">
					<strong>Error : </strong> The user is inactive, you can't display
					his documents
					</p>
					<%
						}
					%>
				</div>
			</table>
			</div>
			</div>
	</div>
	</div>
</body>
</html>