package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilitySpicejet {

	//driver instance
	public static WebDriver driver;
	//instance for excel
	public String excelFile;
	//instance for sheet
	public String sheetName;
	//instance for properties
	public Properties prop;
	
	

	public WebDriver intializeDriver() throws IOException {
		
		prop=new Properties();
		//String propath=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		String propath="C:\\Users\\Admin\\eclipse-workspace\\capstoneSpicejet\\src\\main\\java\\resources\\data.properties";
		FileReader fis=new FileReader(propath);
		prop.load(fis);

		String browser ="chrome";
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		return driver;
	}
	//close browser
	public void CloseSpicejetBrowser() {
		driver.close();
	}
	//click operation
	public void click(WebElement ele) {
		ele.click();
	}
	//findelements and send keys together
	public void findElementAndSendkeys(String attributevalue, String value) {
		driver.findElement(By.id(attributevalue)).sendKeys(value);
	}
	public void wait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	//Explicit wait
	public void visiblityofElement(WebElement element, int sec) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void selectFromDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	public void popupdisable() {
		ChromeOptions options  = new ChromeOptions();
		options.addArguments("--disable-notification");
		  WebDriver  driver = new ChromeDriver(options);
		//WebDriver driver=new ChromeDriver(options);
	}

	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,450)");
	}

	//method for switch windows
	public  void switchwindow() {

		String parentwindow=driver.getWindowHandle();
		Set<String> windowhandles=driver.getWindowHandles();
		windowhandles.size();

		for(String childWindow:windowhandles) {
			if(!childWindow.contentEquals(parentwindow)) {
				driver.switchTo().window(childWindow);
			}
		}

	}


	//method for reading data from excel
	public String[][] readExcel(String excelfile1, String sheetname) throws IOException{
		XSSFWorkbook book = new XSSFWorkbook(
				"C:\\Users\\Admin\\eclipse-workspace\\capstone.Spicejet\\Data\\"+excelfile1+ ".xlsx");
		XSSFSheet sheet = book.getSheet(sheetname);

		//get the row and coloum count
		int rowcount = sheet.getLastRowNum();
		int columncount =sheet.getRow(0).getLastCellNum();

		//2d array to store row and column values of cell
		String[][] data=new String[rowcount][columncount];

		//get into rows
		for(int i=1;i<=rowcount; i++) {
			XSSFRow row=sheet.getRow(i);
			//get into colunms
			for(int j=0; j<columncount; j++) {
				//get over cells
				XSSFCell cell=row.getCell(j);
				//cell values
				data[i-1][j]= cell.getStringCellValue();

			}
		}
		//close the book
		book.close();
		return data;
	}
	//properties file
	public void inputfromfile() {
		prop=new Properties();
		String proppath=System.getProperty("user.dir")+"C:\\Users\\Admin\\eclipse-workspace\\ProjectSpicejet\\src\\main\\java\\resources\\OneWaydata.properties";
	}
	//generate random username for signup
	public String randomNameGenerator() {
		//create 
		String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//create an object of string builder 
		StringBuilder sb= new StringBuilder();
		//create random class obj
		Random random=new Random();

		int length=8;

		for(int i=0; i<length; i++) {
			//generate random index number
			int index=random.nextInt(alphabet.length());
			// get char based on the above index
			char randomChar=alphabet.charAt(index);
			sb.append(randomChar);  
		}
		String name=sb.toString();
		System.out.println("The Random string is "+name);

		return name;

	}
	//method capturing screenshot
	public String takeScreenshot(String screenshotName, WebDriver driver) throws IOException {
		Date dt=new Date();
		String date=dt.toString();
		System.out.println(date);
		// logic
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String time=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date( ));
		//String path="C:\\Users\\Admin\\eclipse-workspace\\capstone.Spicejet\\screenshots"+screenshotName+"_"+time+".png";
		String path= System.getProperty("user.dir")+"\\screenshots\\"+screenshotName+"_"+time+".png";
		//C:\Users\Admin\eclipse-workspace\capstone.Spicejet\screenshots(path)
		File des=new File(path);
		FileUtils.copyFile(src, des);
		return path;
	}

}
