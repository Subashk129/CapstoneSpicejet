package project1spicejet;

import org.testng.annotations.Test;

import base.ProjectSpicejet;
import pages.TwowayTrips;
public class TS007_TwowayTest extends ProjectSpicejet{

	
	@Test
	public void TwowayTrips() {
		
		TwowayTrips twotrip= new TwowayTrips(driver);
		twotrip.twowayradiobtn();
		twotrip.waits();
		twotrip.Twowayfromplace(prop.getProperty("From"));
		twotrip.Twowaytoplace(prop.getProperty("To"));
		twotrip.departdate();
		twotrip.returndate();
		twotrip.dateselection();
		twotrip.selectsearchbtn();
		
	}
	}
	
	

