package swe;
import java.sql.*;
public class Signupcheck {
	private DConnection db=new DConnection();
	public void addDriver(String name,String emailid,String mobileno,String password,String cabno)
	{	
		int n=db.executeOther("insert into drivers(driver_name, emailid,mobileno, password, cabno) values('"+name+"','"+emailid+"','"+mobileno+"','"+password+"','"+cabno+"')");
		db.close();
	}
	
	public void addHospital(String name,String email,String hospital,String mobile,String hospital_no,String password,String beds,String address)
	{	
		db.executeOther("insert into manager(name, email,hospital,mobile,hospitalno,password,address,totalBeds) values('"+name+"','"+email+"','"+hospital+"','"+mobile+"','"+hospital_no+"','"+password+"','"+address+"','"+beds+"')");
		db.close();
	}
	

}
