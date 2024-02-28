package pageobject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import utilities.Excelutils;

public class Newbikes extends Basepage{

	public JavascriptExecutor js;
	public Newbikes (WebDriver driver)
	{
		super(driver);
		js = (JavascriptExecutor) driver;
	}
	
	Excelutils xl = new Excelutils(System.getProperty("user.dir")+"\\TestData\\data.xlsx");
	//LOCATORS
	
	@FindBy(xpath="//img[@alt='ZigWheels - New Cars, Used Cars, Bikes Prices, News, Reviews, QnA']")
	WebElement img;
	
	@FindBy(xpath="//a[normalize-space()='New Bikes']")
	WebElement new_bikes_tag;
	
	@FindBy(xpath="//span[contains(text(),'Upcoming Bikes')]")
	WebElement upcoming_bikes;
	
	@FindBy(id="makeId")
	WebElement dropdown;
	
	@FindBy(xpath="//option[@value='53' and @data-url='honda']")
	WebElement dropdown_honda;
	
	//LIST COLLECTIONS
	
	@FindBy(xpath="//span[@class='zw-cmn-loadMore']")       //CLICKING VIEW MORE BIKES
	WebElement view_more_button;
	
	@FindBy(xpath="//strong[@class='lnk-hvr block of-hid h-height']")     //LIST OF HONDA BIKES
	List <WebElement> Honda_bike_names_list;
	
	@FindBy(xpath="//div[contains(@title,'Ex-Showroom Price')] ")   //COST OF THE BIKES
	List <WebElement> cost_of_bikes;
	
	@FindBy(xpath="//div[contains(text(),'Launch Date')][@class='clr-try fnt-14']")  //LAUNCH DATE
	List <WebElement> launch_dates;
	
	
	//ACTIONS
	public boolean image()
	{
		Assert.assertEquals(img, true);
		return true;
	}
	
	
	public void newbikes_tag() 
	{
	 Actions act=new Actions(driver);
	 act.moveToElement(new_bikes_tag).perform();
	}
	
	public void select_upcomingbikes() 
	{
		upcoming_bikes.click();
	}
	
	public void dropdown() 
	{
		dropdown.click();
	}
	
	public void select_brand() 
	{
		dropdown_honda.click();
	}
	public void scrolldown() 
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", view_more_button);
	}
	
	public void select_viewmorebikes_tag()
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", view_more_button);
	}
	
	public void scrollup() throws InterruptedException 
	{
		Thread.sleep(2000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-5000)");
	}
	
	public void names() throws IOException 
	{
		int row=0;
		for(int i=0; i< cost_of_bikes.size(); i++)
		{
			String [] cost = cost_of_bikes.get(i).getText().split(" ");
			if(Double.parseDouble(cost[1].replace(",", "."))<=4.0) 
			{
				System.out.println(Honda_bike_names_list.get(i).getText());
				System.out.println(cost_of_bikes.get(i).getText());
				System.out.println(launch_dates.get(i).getText()+"\n");
				
				xl.setCellData("Sheet3",row, 0,  Honda_bike_names_list.get(i).getText());
				xl.setCellData("Sheet3",row, 1,  cost_of_bikes.get(i).getText());
				xl.setCellData("Sheet3",row, 2,  launch_dates.get(i).getText());
				row++;
			}
			if(cost[1].contains(","))
			{
				if(Integer.parseInt(cost[1].replace(",", ""))<400000)
				{
					System.out.println(Honda_bike_names_list.get(i).getText());
					System.out.println(cost_of_bikes.get(i).getText());
					System.out.println(launch_dates.get(i).getText()+"\n");
				
					xl.setCellData("Sheet3",row, 0,  Honda_bike_names_list.get(i).getText());
					xl.setCellData("Sheet3",row, 1,  cost_of_bikes.get(i).getText());
					xl.setCellData("Sheet3",row, 2,  launch_dates.get(i).getText());
					row++;
				}		
			}
		}
	}
}