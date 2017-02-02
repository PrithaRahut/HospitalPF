<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String msg=(String)request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Status</title>
</head>
<body>
	<% if(msg!=null){ %>
	        
	  	<h2><strong><%=msg %></strong></h2>
			
	<%} %>
	<div>
		<form action="maps.jsp" method="POST">
			<button type="submit"> Go Back to Map</button>
		</form>
	</div>
</body>
</html>