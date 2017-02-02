<%@page import="swe.Hospital"%>
<%@page import="java.util.List"%>
<%@page import="swe.Manager"%>
<%@page import="swe.Reservation"%>
<%@page import="swe.Home"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	Manager manager = (Manager) request.getSession().getAttribute("manager");

	if(manager == null) {
		response.sendRedirect("homePage.jsp");
	} else {
		Hospital hospital = Home.getHospitalsById(manager.hid);
		List<Reservation> list = Home.getReservationList(manager.hid);
		
		String beds = request.getParameter("beds");
		System.out.println(beds);
		boolean bedsUpdated = false;
		if(beds != null) {
			int noOfBeds = Integer.parseInt(beds);
			Home.updateBeds(manager.hid, noOfBeds);
			bedsUpdated = true;
		}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<title>Manager Account</title>
		<!--<style type="text/css">
		body{
			background-image=url(../doctor.jpg);
			background-size:cover;
			background-repeat:no-repeat;
		}
		</style>-->
	</head>
<body>
	 <nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">HospitalPathFinder</a>
	    </div>
	    <!-- <ul class="nav navbar-nav">
	      <li class="active"><a href="#">Home</a></li>
	      <li><a href="#">Page 1</a></li>
	      <li><a href="#">Page 2</a></li>
	    </ul> 
	    -->
	    <form action="Logout" method="POST">
	    <ul class="nav navbar-nav navbar-right">
	      <!-- <li><a href="#"><span class="glyphicon glyphicon-user"></span> Profile</a></li> -->
	      <li><a href="javascript:void(0)" class="logout-button"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
	    </ul>
	    </form>
	  </div>
	</nav>
<%
	if(bedsUpdated) {
%>
	<div class="alert alert-success">
	  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	  <strong>Beds successfully updated.</strong>
	</div>
<%		
	}
%>
	 <div class="container">
	 	<h2><u><%=manager.hospital %></u></h2>
	 	<div class="row text-center">
			 <form class="form-inline" action="manager.jsp" method="POST">
			  <div class="form-group">
			    <label for="beds">Beds Available (<%=hospital.bedsAvailable %>) :</label>
			    <input type="number" class="form-control" min="0" id="beds" name="beds" required />
			  </div>
			  <button type="submit" class="btn btn-default">Update</button>
			</form>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<h3>Driver Requests</h3>
		</div>
		<%
		if(list.isEmpty()) {
			%>
			<div>
			<h4 class="text-danger">No Requests</h4>
			</div>
			<%
		} else {
		%>
		<div class="row">
			<div class="table-responsive">
				<table class="table">
					<tr>
						<th>Driver name</th>
						<th>Driver contact</th>
						<th>Cab Number</th>
						<th>Beds Required</th>
					</tr>
					
<%
					for(Reservation res : list) {
						%>
					<tr>
						<td><%=res.driver.name %></td>
						<td><%=res.driver.contact %></td>
						<td><%=res.driver.cabNo %></td>
						<td><%=res.beds %></td>
					</tr>
						<%
					}
%>
				</table>
			</div>
		</div>
		<%} %>
	</div>
	<script>
	$(document).ready(function(){
		   $(document).on("click",".logout-button",function(){
		     var form = $(this).closest("form");
		     //console.log(form);
		     form.submit();
		   });
		});
	</script>
</body>
</html>
<% } %>