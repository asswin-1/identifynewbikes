package testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import pageobject.Usedcars;
import testbase.Baseclass;

public class UsedCars extends Baseclass {
	
	
	@Test(priority=3)
	public void usedcars() throws InterruptedException, IOException
	{
		Usedcars uc=new Usedcars(driver);
		uc.usedcartag();
	}
	
	@Test(priority=4)
	public void cityselect() throws InterruptedException, IOException
	{
		Usedcars uc=new Usedcars(driver);
		uc.selectcity();
		Thread.sleep(2000);
	}
	
	@Test(priority=5)
	public void popularmodels() throws InterruptedException, IOException
	{
		Usedcars uc=new Usedcars(driver);
		uc.scroll();
		Thread.sleep(3000);
		System.out.println("List_of_popular_models:");
		uc.listofpopularmodels();
		Thread.sleep(2000);
		uc.scrollup1();
		Thread.sleep(2000);
		uc.Homepage();
	}
}
