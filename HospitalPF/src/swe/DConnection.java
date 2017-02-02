package swe;
import java.sql.*;

public class DConnection
{
	Connection conn;
	Statement stmt;
	ResultSet rst;
	public DConnection()
	{
		executeOther("create table if not exists admin(admin_id varchar(255) primary key, password varchar(255), admin_name varchar(255))");
		//close();
/*
		int cnt=0;
		try
		{
			rst=executeSelect("select count(*) from admin");
			rst.next();
			cnt=rst.getInt(1);
			close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(cnt==0)
		{
			executeOther("insert into admin values('admin','admin','admin')");
			close();
		}
		executeOther("create table if not exists hospitals(hospitalno int auto_increment primary key, hospital_name varchar(255))");
		close();
		executeOther("create table if not exists drivers(driver_id int auto_increment primary key, driver_name varchar(255),emailid varchar(255),mobileno varchar(255),password varchar(255),cabno varchar(255))");
		close();
		executeOther("create table if not exists hospital_Admins(admin_id int auto_increment primary key, admin_name varchar(255),hospital_name varchar(255),hospital_id int)");
		close();
		executeOther("create table if not exists ambulances(ambulance_id int auto_increment primary key,ambulance_name varchar(255))");
		close();
*/
	}
	public int executeOther(String qry)//insert,delete,update
	{
		int cnt=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/swe","root","");
			stmt=conn.createStatement();
			cnt=stmt.executeUpdate(qry);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return cnt;
	}
	public ResultSet executeSelect(String qry)//select
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/swe","root","");
			stmt=conn.createStatement();
			rst=stmt.executeQuery(qry);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rst;
	}

	public void close()
	{
		try
		{
			stmt.close();
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
