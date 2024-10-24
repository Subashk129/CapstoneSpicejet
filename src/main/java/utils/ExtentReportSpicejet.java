package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportSpicejet {
	
	//functionality to get the report
	public static ExtentReports getreport() {
		//provid path
		String path=System.getProperty("user.dir")+"\\Extent_report\\extentreport.html";
		//create report
		ExtentSparkReporter reporter =new ExtentSparkReporter(path);
		reporter.config().setReportName("Spicejet-framework");
		reporter.config().setDocumentTitle("Spicejet-App");
		
		ExtentReports extents=new ExtentReports();
		extents.attachReporter(reporter);
		return extents;
	}
	
}
