package swe;
import java.sql.*;
public class LoginCheck {
	private DConnection db=new DConnection();
	public boolean checkLogin(String emailid,String password,String type)
	{	
		
		if("driver".equalsIgnoreCase(type)){
			try{
				ResultSet rs=null;
				rs=db.executeSelect("select * from drivers where emailid='"+emailid+"' and password='"+password+"'");
				//boolean t=;
				if(rs.first())
					return true;
				else
					return false;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		else if("manager".equalsIgnoreCase(type)){
			try{
				ResultSet rs=null;
				rs=db.executeSelect("select * from manager where email='"+emailid+"' and password='"+password+"'");
				//boolean t=rs.first();
				if(rs.first())
					return true;
				else
					return false;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return true;
	}


}