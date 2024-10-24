package project1spicejet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpicejet;

import pages.SignupSpicejet;

public class TS001_SignupTest extends ProjectSpicejet {


	@Test
	public void  SignupTest()  {
		
		SignupSpicejet signup = new SignupSpicejet(driver);
		signup.signup();
		switchwindow();
		popupdisable();
		signup.mrclick();
		signup.Firstname(prop.getProperty("FirstName"));
		signup.Lastname(prop.getProperty("LastName"));
		scroll();
		signup.signupDob(prop.getProperty("DOB"));
		signup.signupmobileNo(prop.getProperty("MobileNumber"));
		signup.signupEmailid(prop.getProperty("Email"));
		signup.signupPassword(prop.getProperty("Password"));
		signup.signupConPassword(prop.getProperty("Confirmpassword"));
		signup.signupAgreecheck();
		signup.signupsubmitButton();
	}
}
		//created for datadriverntesting
//		//validate the testcases using assertion
//		if(datamatch.equals("newUser")) {
//			Thread.sleep(2000);
//			Alert alert=driver.switchTo().alert();
//			String text=driver.switchTo().alert().getText();
//			alert.accept();
//			AssertJUnit.assertEquals(text, "Sign up successful.");
//		}else if(datamatch.equals("ExistingUser")) {
//			Thread.sleep(2000);
//			Alert alert=driver.switchTo().alert();
//			String text=driver.switchTo().alert().getText();
//			alert.accept();
//			AssertJUnit.assertEquals(text, "Enter vaild details");
//		}else if(datamatch.equals("invalidusername")) {
//			Thread.sleep(2000);
//			Alert alert=driver.switchTo().alert();
//			String text=driver.switchTo().alert().getText();
//			alert.accept();
//			AssertJUnit.assertEquals(text, "Please Enter firstname lastname");
//		}else if(datamatch.equals("invalidpassword")) {
//			Thread.sleep(2000);
//			Alert alert=driver.switchTo().alert();
//			String text=driver.switchTo().alert().getText();
//			alert.accept();
//			AssertJUnit.assertEquals(text, "Please Enter Password conformpassword");
//		}else if(datamatch.equals("invaliddateofbirth")) {
//			Thread.sleep(2000);
//			Alert alert=driver.switchTo().alert();
//			String text=driver.switchTo().alert().getText();
//			alert.accept();
//			AssertJUnit.assertEquals(text, "Please Enter DateofBirth");
//		}else if(datamatch.equals("invalidMoblileno")) {
//			Thread.sleep(2000);
//			Alert alert=driver.switchTo().alert();
//			String text=driver.switchTo().alert().getText();
//			alert.accept();
//			AssertJUnit.assertEquals(text, "Please Enter valid Mobile Number");
//		}else {
//			Thread.sleep(2000);
//			Alert alert=driver.switchTo().alert();
//			String text=driver.switchTo().alert().getText();
//			alert.accept();
//			AssertJUnit.assertEquals(text, "Please Enter valid Details");
//		}
//	}
	
		

