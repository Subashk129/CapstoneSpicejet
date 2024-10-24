package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpicejet;

public class LoginSpicejet extends ProjectSpicejet {

	public LoginSpicejet(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[text()='Login']")
	WebElement login;
	
	@FindBy(xpath ="(//*[name()='circle'])[12]")
	WebElement emailclick;


	@FindBy(xpath="(//input[@type='email'])[1]")
	WebElement maildidfield;
	
	@FindBy(xpath="(//input[@type='email'])[1]")
	WebElement enterEmailid;

	@FindBy(xpath="//input[@type='password']")
	WebElement enterpass;

	@FindBy(xpath="//input[@type='password']")
	WebElement enterinvalidpass;
	
	@FindBy(xpath="//div[@data-testid='login-cta']")
	WebElement loginbtn;

	


	//method to login and click on button
	public void loginHomeButton() {
		login.click();
	}

	public void emailboxselect() {
		emailclick.click();
	}
//	public void  maildidfield() {
//		emailclick.click();
//	}
	
	//method loginmailid
	public void loginmail(String email) {
		enterEmailid.sendKeys(email);
	}
	//method password
	public void loginpass(String password) {
		enterpass.sendKeys( password);
	}
	public void invalidpassword(String invalidpassword) {
		enterinvalidpass.sendKeys(invalidpassword);
	}
	//click action
	public void loginButton() {
		loginbtn.click();
	}
	public void waitele() {
		wait(enterEmailid);
	}
	
}
