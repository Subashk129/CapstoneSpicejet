package project1spicejet;

import org.testng.annotations.Test;

import base.ProjectSpicejet;
import pages.Paymentprocess;

public class TS006_PaymentTest extends ProjectSpicejet {
	
	@Test
	public void Payment() {
		
		Paymentprocess payment = new Paymentprocess(driver);
		payment.cardfieldselection();
		payment.Paymentwait();
		payment.cardNumfield("1234567890123456");
		payment.cardNamefield("Hulk");
		payment.cardExpmonthfield("12");
		payment.cardExpyearfield("35");
		payment.cardcvvfield("123");
		payment.proceedbutton();
		
		
	}

}
