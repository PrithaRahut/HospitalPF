<%@page import="swe.Hospital"%>
<%@page import="java.util.List"%>
<%@page import="swe.Home"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	List<Hospital> hospitalList = Home.getHospitalList();
	String driverId = (String)session.getAttribute("driverId");
	if(driverId == null) {
		response.sendRedirect("homePage.jsp");
	}
%>
<!DOCTYPE html>
<html>
  <head>
    <title>Hospitals</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
  </head>
  <body>
  	<nav class="navbar navbar-inverse" style="padding: 0px; margin:0px;">
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
  	
    <div id="map"></div>
    <script>
      // Note: This example requires that you consent to location sharing when
      // prompted by your browser. If you see the error "The Geolocation service
      // failed.", it means you probably did not give permission for the browser to
      // locate you.

      function initMap() {
	    var defaultPosition = {lat: 26.7999454, lng: 75.8138096};
        var map = new google.maps.Map(document.getElementById('map'), {
          center: defaultPosition,
          zoom: 17
        });
		
    	var locations = [];
    	var infoWindows = [];
    	<%
    	    	for(Hospital hospital : hospitalList) {
    	%>
    	    		var coordi={};
    				coordi["lat"] = <%=hospital.lat%>;
    				coordi["lng"] = <%=hospital.lng%>;
    				locations.push(coordi);
    				
    				// Creating infowindows
    				var infoWindow = new google.maps.InfoWindow({map: map});
    				var content =
    				'<div>' +
                    	'<div class="iw_title"><%=hospital.name%></div>' +
	                    '<div class="iw_content">'+
		                    'Beds Available = <%=hospital.bedsAvailable%>'+
		                    '<br/>'+
		                    '<form action="ReserveBeds" method="POST">'+
			                    '<input type="hidden" name="hid" value="<%=hospital.id%>">' +
			                    '<input type="hidden" name="driverId" value="<%=driverId%>">' +
			                    '<input type="number" name="beds" min="1" max="<%=hospital.bedsAvailable%>" placeholder="Beds required"/>'+
			                    '<input type="submit"/>'+
		                    '</form>'+
	                    '</div>' +
                    '</div>';
              		infoWindow.setContent(content);
              		infoWindows.push(infoWindow);
    	<%
    	    	}
    	%>
    			locations.map(function(coordi, i) {
    				infoWindows[i].setPosition(coordi);
    			    return new google.maps.Marker({
    			      position: coordi,
    			      animation: google.maps.Animation.DROP,
    			      map: map
    		        });
    			    
    		   /*  var markerCluster = new MarkerClusterer(map, markers,
    		            {imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'});
 */
    	        });
        //var infoWindow = new google.maps.InfoWindow({map: map});

        // Try HTML5 geolocation.
        if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function(position) {
            var pos = {
              lat: position.coords.latitude,
              lng: position.coords.longitude
            };
            
			var currentPositionMarker = new google.maps.Marker({
			  position: pos,
			  map: map,
			  animation: google.maps.Animation.DROP,
			  icon: 'http://maps.google.com/mapfiles/ms/icons/green-dot.png'
			});
			
          //  infoWindow.setPosition(pos);
		  //  var content = '<div id="iw_container">' +
          //        '<div class="iw_title">SWE Hospital</div>' +
          //        '<div class="iw_content">Description.<br/><form action="ReserveBeds"><input type="hidden" name="hid"><input type="number" min="0" placeholder="Beds required"/><input type="submit"/> </form></div>' +
          //        '</div>';
          //  infoWindow.setContent(content);
            map.setCenter(pos);
          }, function() {
            handleLocationError(true, infoWindow, map.getCenter());
          });
        } else {
          // Browser doesn't support Geolocation
          handleLocationError(false, infoWindow, map.getCenter());
        }
      }

      function handleLocationError(browserHasGeolocation, infoWindow, pos) {
        infoWindow.setPosition(pos);
        infoWindow.setContent(browserHasGeolocation ?
                              'Error: The Geolocation service failed.' :
                              'Error: Your browser doesn\'t support geolocation.');
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAVi-WNNwr2xYZTAWEbeUYgj__QHe_itRc&callback=initMap">
    </script>
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