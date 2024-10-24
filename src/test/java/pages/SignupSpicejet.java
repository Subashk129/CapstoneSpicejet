package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.UtilitySpicejet;

public class SignupSpicejet extends UtilitySpicejet{

	public WebDriver driver;
	public SignupSpicejet(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//locate all object	
	@FindBy(xpath="//div[text()='Signup']")
	WebElement signupbtn;
	//Title
	@FindBy(xpath="//option[@value='MR']")
	WebElement titlefield;
	//FirstName
	@FindBy(css="#first_name")
	WebElement fnamefield;
	//LastName
	@FindBy(css="#last_name")
	WebElement lnamefield;
	//country
	@FindBy(xpath="//select[@class='form-control form-select']")
	WebElement countryfield;
	//DOB
	@FindBy(xpath="(//input[@id='dobDate'])[1]")
	WebElement dobfield;
	//calender
	@FindBy(xpath="//img[@alt='date']")
	WebElement calander; 
	//mobile no
	@FindBy(css ="input[type='tel']")
	WebElement mobilenofield;
	//maild id
	@FindBy(xpath="//input[@id='email_id']")
	WebElement mailIDfield;
	//password
	@FindBy(xpath="//input[@id='new-password']")
	WebElement passwordfield;
	//confm password
	@FindBy(xpath="//input[@id='c-password']")
	WebElement cnfmpassword;
	//checkbox
	@FindBy(xpath="//input[@id='defaultCheck1']")
	WebElement agreecheck;
	//submit button
	@FindBy(xpath="//button[@type='button']")
	WebElement submitbtnsignup;
	
	
	public void signup() {
		signupbtn.click();
	}
	//method to fill firstname
	public void Firstname(String FirstName) {
		fnamefield.sendKeys(FirstName);
	}
	//method to fill Lastname
	public void Lastname(String LastName) {
		lnamefield.sendKeys(LastName);
	}
	//method to fill country
	public void  signupCountry() {
		countryfield.click();
		
	}
	
	public void signupDob(String DOB) {
		dobfield.sendKeys(DOB);
	}
	
	public void signupmobileNo(String MobileNumber) {
		mobilenofield.sendKeys(MobileNumber);
	}
	public void signupEmailid(String Email) {
		mailIDfield.sendKeys(Email);
	}
	public void signupPassword(String Password) {
		passwordfield.sendKeys(Password);
	}
	public void signupConPassword(String Confirmpassword) {
		cnfmpassword.sendKeys(Confirmpassword);		
	}
	public void signupAgreecheck() {
		agreecheck.click();		
	}
	//method to click on button
	public void signupsubmitButton() {
		submitbtnsignup.click();
	}
	public void mrclick() {
		titlefield.click();
		
	}
		    
		    
}
