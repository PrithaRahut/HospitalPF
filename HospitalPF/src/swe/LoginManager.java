package swe;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginDriver
 */

public class LoginManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	
		String email=request.getParameter("mail");
		String pass=request.getParameter("pwd");
		
		String msg=null;
		
		Manager manager = Home.checkManager(email, pass);
		if(manager != null){
			HttpSession session = request.getSession();
			session.setAttribute("managerId", email);
			session.setAttribute("manager", manager);
			response.sendRedirect("manager.jsp");
			//RequestDispatcher reqDisp = request.getRequestDispatcher("maps.jsp");
			//reqDisp.forward(request, response);
		}
		else {
			msg="Incorrect email or password";
			request.setAttribute("msg", msg);
			RequestDispatcher reqDisp = request.getRequestDispatcher("homePage.jsp");
			reqDisp.forward(request, response);
		}
		
	
	}

}
