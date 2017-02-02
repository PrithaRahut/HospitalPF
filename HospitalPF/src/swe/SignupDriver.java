package swe;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupDriver
 */

public class SignupDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pass=request.getParameter("pwd");
		String confirm=request.getParameter("cpwd");
		String cab=request.getParameter("cnum");
		String contact=request.getParameter("contact");
		
		
		String msg = null;
		
		if(pass.equals(confirm)){
			Driver d=new Driver();
			d.setName(name);
			d.setEmail(email);
			d.setPwd(pass);
			d.setCabNo(cab);
			d.setContact(contact);
			
			boolean value=Home.createDriver(d);
			
			if(value == true) {
				msg = "Successfully registered, continue to login";
			} else {
				msg = "Email not available";
			}
		} else {
			msg = "Passwords do not match";
		}
		
		request.setAttribute("msg", msg);
		RequestDispatcher reqDisp = request.getRequestDispatcher("homePage.jsp");
		reqDisp.forward(request, response);
	}

}
