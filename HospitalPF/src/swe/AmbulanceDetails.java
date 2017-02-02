package swe;
import java.sql.*;
public class AmbulanceDetails{
	private DConnection db=new DConnection();
	public ResultSet getAmbulanceDetails(){
		String qry= "select * from ambulanceDetails;";
		ResultSet rst = db.executeSelect(qry);
		return rst;
	}
}