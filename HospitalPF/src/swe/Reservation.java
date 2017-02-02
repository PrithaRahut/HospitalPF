package swe;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Reservation {

	@Id
	public Long id;
	@Index
	public Long hid;
	public Driver driver;
	public Integer beds;
}
