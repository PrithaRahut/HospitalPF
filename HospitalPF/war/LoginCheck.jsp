<%@page import="java.sql.SQLException"%>
<%@page import="swe.*"%>
<%@  page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.sql.* "%>
<!DOCTYPE html>
<html>
<head>
<br><br>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
<%
		LoginCheck c1=new LoginCheck();
		String emailid= request.getParameter("emailid");
		String pass= request.getParameter("pass");
		String type1=request.getParameter("type");
		if("driver".equalsIgnoreCase(type1)){
				//rs=st.executeQuery("select * from driver where emailid='"+emailid+"' and password='"+pass+"'");
				boolean check=c1.checkLogin(emailid,pass,type1);
				if(check){
					response.sendRedirect("driverpage.jsp");
					out.println("welcome driver");
				}
				else{
					out.println("Not a authorised user,register first");
					%>
						<jsp:include page="index.jsp"></jsp:include>
					<%
				}
			}
		else if("manager".equalsIgnoreCase(type1)){
				//rs=st.executeQuery("select * from manager where emailid='"+emailid+"' and password='"+pass+"'");
				boolean check=c1.checkLogin(emailid,pass,type1);
				if(check){
					response.sendRedirect("update.jsp");
					out.println("welcome manager");
				}
				else{
					out.println("Not a authorised user,register first");
					%>
						<jsp:include page="index.jsp"></jsp:include>
					<%
				}
			}
%>
		

</body>
</html>