package swe;
import java.util.List;

import com.googlecode.objectify.Key;


public class Home {
  
  // Get all hospital objects
  public static List<Hospital> getHospitalList() {
    return OfyService.ofy().load().type(Hospital.class).list();
  }
  
  // Get hospital objects which have city = given city value
  public static List<Hospital> getHospitalsInCity(String city) {
    return OfyService.ofy().load()
    		.type(Hospital.class)
    		.filter("city=", city)
    		.list();
  }
  
  public static List<Hospital> getHospitalsWithAvailableBeds() {
    return OfyService.ofy().load()
    		.type(Hospital.class)
    		.filter("bedsAvailable>", 0)
    		.list();
  }
  
  // Get a specific hospital based on the primary key
  public static Hospital getHospitalsById(long id) {
    return OfyService.ofy().load().key(Key.create(Hospital.class, id)).now();
  }
  public static  void saveHospital(Hospital h){
	  OfyService.ofy().save().entity(h);
  }
  
  public static boolean isDrivernameAvailable(String username) { 
	Driver user = OfyService.ofy().load().key(Key.create(Driver.class, username)).now();
	if(user == null) {
		return true;
	} else {
		return false;
	}
  }
  
  public static boolean createDriver(Driver d) {
	if(isDrivernameAvailable(d.email)) {
		OfyService.ofy().save().entity(d);
		return true;
	} else {
		return false;
	}
  }
  public static long createHospital(Hospital h) {
	  return OfyService.ofy().save().entity(h).now().getId();
  }
  
  public static Driver checkDriver(String email,String pass){
	  Driver user = OfyService.ofy().load().key(Key.create(Driver.class, email)).now();
	  if(user == null){
		  return null;
	  }
	  else {
		  if(pass.equals(user.pwd)){
			 return user; 
		  }
		  else{
			  return null;
		  }
	  }
  }
  public static Manager checkManager(String email,String pass){
	  Manager user = OfyService.ofy().load().key(Key.create(Manager.class, email)).now();
	  if(user == null){
		  return null;
	  }
	  else {
		  if(pass.equals(user.pwd)){
			 return user; 
		  }
		  else{
			  return null;
		  }
	  }
  }
  
  public static boolean isManagernameAvailable(String username) { 
		Manager user = OfyService.ofy().load().key(Key.create(Manager.class, username)).now();
		if(user == null) {
			return true;
		} else {
			return false;
		}
	  }
	  
	  public static boolean createManager(Manager m) {
		if(isManagernameAvailable(m.email)) {
			OfyService.ofy().save().entity(m);
			return true;
		} else {
			return false;
		}
	  }
	 
  
  public static boolean isBedAvailable(Reservation r){
	  Hospital h=getHospitalsById(r.hid);
	  if(h.bedsAvailable>=r.beds){
		  h.bedsAvailable=h.bedsAvailable-r.beds;
		  saveHospital(h);
		  return true;
	  }else{
		  return false;
	  }
  }
  
  synchronized public static boolean reserveBeds(Reservation r){
	  if(isBedAvailable(r)){
		  OfyService.ofy().save().entity(r);
		  return true;
	  } else {
		  return false;
	  }
  }
  public static List<Reservation> getReservationList(Long hid) {
	    return OfyService.ofy().load().type(Reservation.class).filter("hid", hid).list();
  }
  
  public static void updateBeds(long hid, int beds) {
	  Hospital hospital = OfyService.ofy().load().key(Key.create(Hospital.class, hid)).now();
	  hospital.bedsAvailable = beds;
	  OfyService.ofy().save().entity(hospital).now();
  }
}
