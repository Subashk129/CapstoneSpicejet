package project1spicejet;


import org.testng.annotations.Test;

import base.ProjectSpicejet;

import pages.LoginSpicejet;

public class TS002_LoginTest extends ProjectSpicejet{
	
//	@BeforeTest
//	public void filesetup() {
//		excelFile="spicejetdata";
//		sheetName="LoginTest";
//		
//	}
	@Test(priority=1)
	public void LoginwithvalidCredentials() throws InterruptedException {
		
		
		LoginSpicejet obj=new LoginSpicejet(driver);
		obj.loginHomeButton();
		Thread.sleep(2000);
		obj.popupdisable();
		obj.emailboxselect();
		obj.loginmail(prop.getProperty("Email"));
		obj.loginpass(prop.getProperty("Password"));
		obj.loginButton();
		
		}

	@Test(priority=2)
	public void LoginwithInvalidCredentials() {
		LoginSpicejet obj=new LoginSpicejet(driver);
		obj.loginHomeButton();
		obj.popupdisable();
		obj.emailboxselect();
		obj.loginmail(prop.getProperty("Email"));
		obj.invalidpassword(prop.getProperty("invalidpass"));
		obj.loginButton();
	}
}
