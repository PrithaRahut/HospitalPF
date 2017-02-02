<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	String msg=(String)request.getAttribute("msg");
%>

<!DOCTYPE html>
<html>
<head>
	<title>Home Page</title>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Proza+Libre:500,700" rel="stylesheet"> 
    <link href="https://fonts.googleapis.com/css?family=Muli" rel="stylesheet">
    
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
    <div id="first">
        <div class='content'>
        	<% if(msg!=null){ %>
	        <div class="alert alert-warning">
	            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	  			<strong><%=msg %></strong>
			</div>
			<%} %>
            <div class="page-header row" style="background-color: rgba(51,153,255,0.3); border: none;">
                <div class="col-sm-12 text-center">
                    <h1>Hospital Path Finder</h1>
                        
                </div>
            </div>
            <p>&nbsp;</p>
            <div id="about" class="col-sm-12 text-center">
                <p>
                Hospital path finder aims to decrease the time<br>
                wasted in admitting a patient in a hospital during calamities<br>
                when there are large number of patients to be<br>
                treated by allowing you to locate the nearest<br>
                hospital.
                </p>

            </div>
            <p>&nbsp;</p>
<!-- 
            <div class="btnDiv">
                <button type="submit" class="myBtn loginBtn" data-toggle="modal" data-target="#loginModal">Login</button>
                <button type="submit" class="myBtn registerBtn" data-toggle="modal" data-target="#signupModal">Register</button>
            </div>
             -->
             <div class="row text-center">
                   <div class="btn-group logRegBtn">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#loginModal">Login</button>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#signupModal">Register</button>
                    </div>
             </div>
            <div id="loginModal" class="modal fade" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <div class="text-center"><h3 class="modal-title">Login</h3></div>
                             <div>
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#driverLogin" data-toggle="tab">Driver</a></li>
                                    <li><a a href="#managerLogin" data-toggle="tab">Manager</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="modal-body">
                           <div class="tab-content">
                           		<div id="driverLogin" class="tab-pane fade in active">
                           			 <form role="form" action="LoginDriver" method="POST">
                                		<div class="form-group">
                                    		<label for="mail">Email </label>
                                    		<input type="email" class="form-control" id="mail" style="border-radius: 0px;" name="mail" required>
                                		</div>
                                		<div class="form-group">
                                    		<label for="pwd">Password </label>
                                    		<input type="password" class="form-control" id="pwd" style="border-radius: 0px;" name="pwd" required>
                               			</div>
                                		<button type="submit" class="btn btn-primary btn-block" style="border-radius: 0px;">Sign in</button>
                           			 </form>
                           		</div>
                           		<div id="managerLogin" class="tab-pane fade">
                           			 <form role="form" action="LoginManager" method="POST">
                                		<div class="form-group">
                                    		<label for="mail">Email </label>
                                    		<input type="email" class="form-control" id="mail" style="border-radius: 0px;" name="mail" required>
                                		</div>
                                		<div class="form-group">
                                    		<label for="pwd">Password </label>
                                    		<input type="password" class="form-control" id="pwd" style="border-radius: 0px;" name="pwd" required>
                               			</div>
                                		<button type="submit" class="btn btn-primary btn-block" style="border-radius: 0px;">Sign in</button>
                           			 </form>
                           		</div>
                           </div>
                        </div>
                        
                    </div>
                    
                </div>
                
            </div>
            <div id="signupModal" class="modal fade" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <div>
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#driverSignup" data-toggle="tab">Driver</a></li>
                                    <li><a a href="#managerSignup" data-toggle="tab">Manager</a></li>
                                </ul>
                            </div>
                        </div>
	                        <div class="modal-body">
	                        	<div class="tab-content">
	                        		<div id="driverSignup" class="tab-pane fade in active">
	                            		<form role="form" action="SignupDriver" method="POST">
	                                		<div class="form-group">
	                                   			 <label for="name">Full Name </label>
	                                    		<input type="text" class="form-control" id="name" style="border-radius: 0px;" name="name" required>
	                                		</div>
	                                		<div class="form-group">
	                                    		<label for="email">Email </label>
	                                    		<input type="email" class="form-control" id="email" style="border-radius: 0px;" name="email" required>
	                                		</div>
	                                		<div class="form-group">
	                                    		<label for="pwd">Password </label>
	                                    		<input type="password" class="form-control" id="pwd" style="border-radius: 0px;" name="pwd" required>
	                                		</div>
	                                		<div class="form-group">
	                                			<label for="cpwd">Confirm Password </label>
	                                    		<input type="password" class="form-control" id="cpwd" style="border-radius: 0px;" name="cpwd" required>
	                                		</div>
	                                		<div class="form-group">
	                                    		<label for="cnum">Cab</label>
	                                    		<input type="text" class="form-control" id="cnum" style="border-radius: 0px;" name="cnum" required>
	                                		</div>
	                                		<div class="form-group">
	                                    		<label for="contact">Contact Number</label>
	                                    		<input type="text" class="form-control" id="contact" style="border-radius: 0px;" name="contact" required>
	                                		</div>
	                                		<button type="submit" class="btn btn-primary btn-block" style="border-radius: 0px;">Sign up</button>
	                            		</form>
	                        		</div>
	                          		<div id="managerSignup" class="tab-pane fade">
	                            	<form role="form" action="SignupManager" method="POST">
	                                <div class="form-group">
	                                    <label for="name">Full Name </label>
	                                    <input type="text" class="form-control" id="name" style="border-radius: 0px;" name="name" required>
	                                </div>
	                                <div class="form-group">
	                                    <label for="email">Email </label>
	                                    <input type="email" class="form-control" id="email" style="border-radius: 0px;" name="email" required>
	                                </div>
	                                <div class="form-group">
	                                    <label for="pwd">Password </label>
	                                    <input type="password" class="form-control" id="pwd" style="border-radius: 0px;" name="pwd" required>
	                                </div>
	                                <div>
	                                	<label for="cpwd">Confirm Password </label>
	                                    <input type="password" class="form-control" id="cpwd" style="border-radius: 0px;" name="cpwd" required>
	                                </div>
	                                <div class="form-group">
	                                    <label for="hname">Hospital Name</label>
	                                    <input type="text" class="form-control" id="hname" style="border-radius: 0px;" name="hname" required>
	                                </div>
	                                <div class="form-group">
	                                    <label for="hAdd">Hospital Address</label>
	                                    <input type="text" class="form-control" id="hAdd" style="border-radius: 0px;" name="hAdd" required>
	                                </div>
	                                 <div class="form-group">
	                                    <label for="beds">Total Beds</label>
	                                    <input type="number" class="form-control" id="beds" style="border-radius: 0px;" name="beds" required>
	                                </div>
	                                <div class="form-group">
	                                    <label for="contact">Contact Number</label>
	                                    <input type="text" class="form-control" id="contact" style="border-radius: 0px;" name="contact" required>
	                                </div>
	                                <button type="submit" class="btn btn-primary btn-block" style="border-radius: 0px;">Sign up</button>
	                            </form>
	                        </div>
	                        </div>
	                        </div>
                        
                    </div>
                    
                </div>
                
            </div>
        </div>
    </div>
	

</body>
</html>