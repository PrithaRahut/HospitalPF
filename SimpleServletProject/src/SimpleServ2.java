

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServ2
 */
@WebServlet("/SimpleServ2")
public class SimpleServ2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		String name=request.getParameter("username");
		HttpSession session=request.getSession();
		if(name!="" && name!=null){
			session.setAttribute("savedname",name);
		}
		
		writer.println("Requested: "+ name);
		writer.println("session created: "+ (String)session.getAttribute("savedname"));
	}

}
