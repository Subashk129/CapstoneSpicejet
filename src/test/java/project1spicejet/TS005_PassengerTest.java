package project1spicejet;

import org.testng.annotations.Test;

import base.ProjectSpicejet;
import pages.Passenger;

public class TS005_PassengerTest extends ProjectSpicejet {

	@Test
	public void Passengerpage() {
		
		Passenger ppaage=new Passenger(driver);
		ppaage.primarypassenger();
		ppaage.Passengerwait();
		ppaage.primarycntbtn();
		ppaage.Passengerwait1();
		ppaage.addoncntbtn();
		
		
	}
	
}
