package base;

import java.io.IOException;

import javax.swing.text.Utilities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import utils.UtilitySpicejet;

public class ProjectSpicejet extends UtilitySpicejet {
	
	
	@BeforeMethod
	public void browserLaunch() throws IOException {
		driver=intializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@AfterMethod
	public void browserClose() {
		driver.quit();
	}
	
	@DataProvider(name="ReadfromExcel")
	public String[][] excelread() throws IOException{
		String[][] datas=readExcel(excelFile, sheetName);
		return datas;
	}
	

}
