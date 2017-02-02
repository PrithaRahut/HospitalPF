package swe;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReserveBeds extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		long hid = Long.parseLong(request.getParameter("hid"));
		String driverId = request.getParameter("driverId");
		int beds = Integer.parseInt(request.getParameter("beds"));
		Driver driver = (Driver)request.getSession().getAttribute("driver");
		if(driver == null) {
			response.sendRedirect("homePage.jsp");
		}
		
		String msg = null;
		
		Reservation reservation = new Reservation();
		reservation.hid = hid;
		reservation.driver = driver;
		reservation.beds = beds;
		boolean status=Home.reserveBeds(reservation);
		if(status==true){
			msg="Request has been sent";
		}
		else{
			msg="Error occured! Beds not available";
		}
			
		request.setAttribute("msg", msg);
		RequestDispatcher reqDisp = request.getRequestDispatcher("reservationStatus.jsp");
		reqDisp.forward(request, response);
	}

}
