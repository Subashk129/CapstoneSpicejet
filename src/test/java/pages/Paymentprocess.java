package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpicejet;

public class Paymentprocess extends ProjectSpicejet {
	
	public Paymentprocess(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[.='Continue']")
	WebElement cardSelection;

	@FindBy(xpath="//input[@class='card_number']")
	WebElement cardnumber;

	@FindBy(xpath="//input[@class='name_on_card']")
	WebElement cardName;

	@FindBy(xpath="//input[@class='card_exp_month']")
	WebElement cardExpmonth;

	@FindBy(xpath="//input[@class='card_exp_year']")
	WebElement cardExpyear;

	@FindBy(xpath="//input[@class='security_code']")
	WebElement cardCVV;

	@FindBy(xpath="//div[contains(text(),'Proceed to pay')]")
	WebElement proceedbtn;

	
	public Paymentprocess cardfieldselection() {
		cardSelection.click();
		return this;
	}
	public Paymentprocess cardNumfield(String number) {
		findElementAndSendkeys("cardnumber", number);
		return this;
	}
	public Paymentprocess cardNamefield(String name) {
		findElementAndSendkeys("cardName", name );
		return this;
	}
	public Paymentprocess cardExpmonthfield(String num) {
		cardExpmonth.click();
		return this;
	}
	public Paymentprocess cardExpyearfield(String year) {
		cardExpyear.click();
		return this;
	}
	public Paymentprocess cardcvvfield(String digit) {
		cardCVV.click();
		return this;
	}
	public Paymentprocess proceedbutton() {
		proceedbtn.click();
		return this;
	}
	public Paymentprocess Paymentwait () {
		visiblityofElement(cardnumber, 20);
		return this;
	}
	
	

}
