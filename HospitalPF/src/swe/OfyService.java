package swe;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

public class OfyService {
  static {
  
  // All the classes that you want to load or save.
    factory().register(Manager.class);
    factory().register(Driver.class);
    factory().register(Reservation.class);
    factory().register(Hospital.class);
  }

  public static Objectify ofy() {
    return ObjectifyService.ofy();
  }
 
  public static ObjectifyFactory factory() {
    return ObjectifyService.factory();
  }
} 
