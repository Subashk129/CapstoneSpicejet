package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpicejet;

public class Passenger extends ProjectSpicejet {

	public Passenger(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(xpath="(//*[name()='path'][@fill='currentColor'])[3]")
	WebElement primarypass;


	@FindBy(xpath="//div[.='Continue']")
	WebElement continuebtn2;

	@FindBy(xpath="(//div[.='Continue'])[1]")
	WebElement addoncontinuebtn;

	
	public Passenger primarypassenger() {
		primarypass.click();
		return this;
	}
	public Passenger primarycntbtn() {
		continuebtn2.click();
		return this;
	}
	public Passenger addoncntbtn() {
		addoncontinuebtn.click();
		return this;
	}
	
	public Passenger Passengerwait () {
		visiblityofElement(continuebtn2, 20);
		return this;
	}
	public Passenger Passengerwait1 () {
		visiblityofElement (addoncontinuebtn, 20);
		return this;
	}



}
