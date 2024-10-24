package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpicejet;

public class OnewayTrip extends ProjectSpicejet {

	@FindBy(xpath="//div[text()='one way']")
	WebElement onewaytrip;
	
	@FindBy(xpath="//div[text()='From']")
	WebElement Fromplace;
	
	@FindBy(xpath="//div[text()='To']")
	WebElement Toplace;
	
	@FindBy(xpath="//div[text()='Departure Date']")
	WebElement Departdate;
	
	@FindBy(xpath="//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-156aje7 r-y47klf r-1phboty r-1d6rzhh r-1pi2tsx r-1777fci r-13qz1uu']")
	WebElement dateSelection;
	
	@FindBy(xpath="//div[text()='Search Flight']")
	WebElement searchbutton;
	
	public OnewayTrip(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//method entering from details
	public OnewayTrip onewayfromplace(String fromplace) {
		findElementAndSendkeys("Fromplace", fromplace);
		return this;
	}
	//method entering to details
	public OnewayTrip onewaytoplace(String toplace) {
		findElementAndSendkeys("Toplace", toplace);
		return this;
	}
	//method to click onewaytrip radiobutton
	public OnewayTrip onewayradiobtn() {
		onewaytrip.click();
		return this;
	}
	public OnewayTrip departdate() {
		Departdate.click();
		return this;
	}
	public OnewayTrip dateselection() {
		dateSelection.click();
		return this;
	}
	public OnewayTrip selectsearchbtn() {
		searchbutton.click();
		return this;
	}
	public OnewayTrip waits() {
		visiblityofElement(Fromplace, 20);
		return this;
	}

}
