package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpicejet;

public class Flightselect extends ProjectSpicejet {
	
	
	public Flightselect(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="(//*[name()='circle'])[5]")
	WebElement selectflight;
	
	@FindBy(xpath="(//div[text()='Continue'])[1]")
	WebElement Contibtn1;
	
	
	public Flightselect selectFlights() {
		selectflight.click();
		return this;
	}
	public Flightselect waitingforselection() {
		visiblityofElement(selectflight, 20);
		return this;
	}
	public Flightselect flightcontinuebtn() {
		Contibtn1.click();
		return this;
	}
	
	
	

}
