package swe;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Hospital {

	@Id
	public Long id;
	public String name;
	
	//public String city;
	
	@Index
	public int bedsAvailable;
	
	public double lat;
	public double lng;
}
