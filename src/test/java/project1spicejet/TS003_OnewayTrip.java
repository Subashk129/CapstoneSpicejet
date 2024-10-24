package project1spicejet;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpicejet;
import pages.OnewayTrip;

public class TS003_OnewayTrip extends ProjectSpicejet {
	
	
	@Test
	public void OnewayTrip() {
		
		OnewayTrip onetrip=new OnewayTrip(driver);
		onetrip.onewayradiobtn()
		.onewayfromplace(prop.getProperty("From"))
		.waits()
		.onewaytoplace(prop.getProperty("To"))
		.departdate()
		.waits()
		.dateselection()
		.selectsearchbtn();
		
	}
	}
	


