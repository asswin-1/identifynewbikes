package utilities;
 
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testbase.Baseclass;
 
public class ExtentReport implements ITestListener {
	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports extent;//general info
	public ExtentTest test;//test method details
 
	String repName;
 
	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		repName = "Test-Report-" + timeStamp + ".html";
 
		sparkReporter = new ExtentSparkReporter(".\\Reports\\" + repName);// specify location of the report
 
		sparkReporter.config().setDocumentTitle("ZigWheels Automation Report"); // Title of report
		sparkReporter.config().setReportName("New Bikes & Used Cars Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);
 
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "zigwheels");
		extent.setSystemInfo("Module", "new bikes");
		extent.setSystemInfo("Sub Module", "cars");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environemnt", "QEA");
		
//		String os=testContext.getCurrentXmlTest().getParameter("os");
//		extent.setSystemInfo("Operating System", os);
//		
//		String browser=testContext.getCurrentXmlTest().getParameter("browser");
//		extent.setSystemInfo("Browser", browser);
//		
//		List <String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
//		if(includedGroups.isEmpty())
//		{
//			extent.setSystemInfo("Groups", includedGroups.toString());
//		}
	}
 
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
//		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, "Test Passed");
		
		try
		{
			String imgPath=new Baseclass().Screencapture(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
	}
 
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
//		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
 
		try
		{
			String imgPath=new Baseclass().Screencapture(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		
	}
 
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
//		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
		
		try
		{
			String imgPath=new Baseclass().Screencapture(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
	}
 
	public void onFinish(ITestContext testContext) {
		extent.flush();
		
		String pathOfExtentReport= System.getProperty("user.dir")+"\\Reports\\"+repName;
		File extentReport = new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
 
}



