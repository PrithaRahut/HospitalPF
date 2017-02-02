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

public class LoginDriver extends HttpServlet {
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
		
		Driver driver=Home.checkDriver(email, pass);
		if(driver != null){
			HttpSession session = request.getSession();
			session.setAttribute("driverId", email);
			session.setAttribute("driver", driver);
			response.sendRedirect("maps.jsp");
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
