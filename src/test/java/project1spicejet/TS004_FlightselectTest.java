package project1spicejet;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import base.ProjectSpicejet;
import pages.Flightselect;

public class TS004_FlightselectTest extends ProjectSpicejet {

	@Test
	public void Flightselect() {
		
		Flightselect fselect=new Flightselect(driver);
		fselect.selectFlights();
		fselect.waitingforselection();
		fselect.flightcontinuebtn();
}
}