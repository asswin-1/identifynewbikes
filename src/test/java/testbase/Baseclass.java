package testbase;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Baseclass {
	
	public Properties p;
	public static WebDriver driver;
	public Logger logger;
	
	@Parameters({"browser"})
	@BeforeTest
	
	public void setupDriver(String br) throws IOException
	{
		//Loading PROPERTY FILE
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		 
		//Loading log4j file
		logger = LogManager.getLogger(this.getClass());
		 
		//BROWSER SELECTION
		if(br.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();	
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--disable-notifications");
			driver=new ChromeDriver(opt);
		}
		else if(br.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			EdgeOptions opt1=new EdgeOptions();
			opt1.addArguments("--disable-notifications");
			driver=new EdgeDriver(opt1);	
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();		
		}
		
		driver.get(p.getProperty("appURL"));
		driver.manage().deleteAllCookies();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      }

		@AfterTest
			public void teardown()
			{
				driver.quit();
			}
		
		public String Screencapture(String tname) throws IOException
		{
			
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File trg=new File(System.getProperty("user.dir")+"\\ScreenShots\\"+tname+".png");
			FileUtils.copyFile(src, trg);
			return trg.getAbsolutePath();
//			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//			TakesScreenshot ts = (TakesScreenshot)driver;
//			File src = ts.getScreenshotAs(OutputType.FILE);
//			String trg = System.getProperty("user dir")+"\\ScreenShots\\"+tname+"_"+timeStamp+".png";
//			File targetFile=new File(trg);
//			src.renameTo(targetFile);
//			return trg;
		}
}
