package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpicejet;

public class TwowayTrips extends ProjectSpicejet {


	@FindBy(xpath="//div[contains(text(),'round trip')]")
	WebElement Twowaytrip;
	
	@FindBy(xpath="(//div//div/div/input)[1]")
	WebElement Fromplace;
	
	@FindBy(xpath="(//div//div/div/input)[2]")
	WebElement Toplace;
	
	@FindBy(xpath="//div[normalize-space()='Departure Date']")
	WebElement Departdate;
	
	@FindBy(xpath="//div[normalize-space()='Return Date']")
	WebElement returndate;
	
	
	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[3]/div[3]/div[4]/div[1]")
	WebElement returndateSelection;
	
	@FindBy(xpath="//div[text()='Search Flight']")
	WebElement searchbutton;
	
	public  TwowayTrips(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//method entering from details
	public void Twowayfromplace(String fromplace) {
		Fromplace.click();
		Fromplace.sendKeys(fromplace);
	}
	//method entering to details
	public void Twowaytoplace(String toplace) {
		Toplace.click();
		Toplace.sendKeys(toplace);
	}
	//method to click onewaytrip radiobutton
	public void twowayradiobtn() {
		Twowaytrip.click();
		
	}
	public void departdate() {
		Departdate.click();
		
	}
	public void returndate() {
		returndate.click();
		
	}
	public void dateselection() {
		returndateSelection.click();
	}
	public void selectsearchbtn() {
		searchbutton.click();
	}
	public TwowayTrips waits() {
		visiblityofElement(Fromplace, 20);
		return this;
	}

}

