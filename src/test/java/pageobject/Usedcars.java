package pageobject;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Excelutils;

import org.openqa.selenium.interactions.Actions;

public class Usedcars extends Basepage
{
	public JavascriptExecutor js;
	public Usedcars (WebDriver driver)
	{
		super(driver);
		js = (JavascriptExecutor) driver;
	}
	Excelutils xl = new Excelutils(System.getProperty("user.dir")+"\\TestData\\data.xlsx");
	
	//Locators
	@FindBy(xpath="//a[normalize-space()='Used Cars']")
	WebElement used_cars;
	
	@FindBy(xpath="//span[@onclick=\"goToUrl('/used-car/Chennai')\"]")
	WebElement selectChennai;
	
	@FindBy(xpath="//label[contains(@for,'bycarid')]")
	List <WebElement> popularmodels;
	
	@FindBy(xpath="//a[contains(@href,'zigwheels.com')][@title='Home']")
	WebElement Home_btn;
	
	public void usedcartag() 
	{
	 Actions act=new Actions(driver);
	 act.moveToElement(used_cars).perform();
	}
	
	public void selectcity() 
	{
		selectChennai.click();
	}
	
	public void scroll() 
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,500)");
	}
	public void scrollup1() 
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,-500)");
	}
	public void listofpopularmodels() throws IOException 
	{
		int row=0;
		for (int i = 0; i < popularmodels.size(); i++)
		{
			System.out.println(popularmodels.get(i).getText());
			xl.setCellData("Sheet4",row, 0,popularmodels.get(i).getText());
			row++;
		}
	}
	public void Homepage()
	{
		Home_btn.click();
	}
	
}
			


