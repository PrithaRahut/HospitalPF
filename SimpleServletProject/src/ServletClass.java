import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class ServletClass extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("userName");
		HttpSession session=request.getSession();
		if(name!="" && name!=null){
			session.setAttribute("savedName",name);
		}
		out.println("Request " + name);
		out.println("session "+ (String)session.getAttribute("savedName"));
		
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("userName");
		out.println("Hello! from the POST method"+ name);
		String[] location=request.getParameterValues("location");
		for (int i=0;i<location.length;i++){
			out.println("You are "+ location[i]);
		}
	}
}
