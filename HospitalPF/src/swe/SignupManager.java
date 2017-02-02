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

public class SignupManager extends HttpServlet {
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
		String hospital_name=request.getParameter("hname");
		String address=request.getParameter("hAdd");
		String contact=request.getParameter("contact");
		String bed=request.getParameter("beds");

		int bedsnum=Integer.parseInt(bed);
		String msg = null;
		
		if(pass.equals(confirm)){
			Manager m=new Manager();
			m.setName(name);
			m.setEmail(email);
			m.setPwd(pass);
			m.setHospital(hospital_name);
			m.setAddress(address);
			m.setContact(contact);
			
			double[] coordi = new double[]{0,0};
			
			try {
				
				coordi=Urlconnection.getCoordinates(address);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Hospital h=new Hospital();
			h.lat=coordi[0];
			h.lng=coordi[1];
			
			h.name=hospital_name;
			h.bedsAvailable=bedsnum;
			
			long hid = Home.createHospital(h);
			m.hid = hid;
			boolean value=Home.createManager(m);
			if(value==true){
				msg = "Successfully registered, continue to login";
			}
			else{
				msg = "Email not available";
			}
		}
		else{
			msg = "Passwords do not match";
		}
		request.setAttribute("msg", msg);
		RequestDispatcher reqDisp = request.getRequestDispatcher("homePage.jsp");
		reqDisp.forward(request, response);
			
		

}
}