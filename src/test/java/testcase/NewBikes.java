package testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import pageobject.Newbikes;
import testbase.Baseclass;

public class NewBikes extends Baseclass {
	@Test(priority=0)
	public void test() throws InterruptedException, IOException
	{
		Newbikes nb=new Newbikes(driver);
		nb.newbikes_tag();
		Thread.sleep(2000);
		Thread.sleep(2000);
		nb.select_upcomingbikes();
	}
	
	@Test (priority=1)
	public void selectbrand() throws InterruptedException, IOException
		{
		Newbikes nb=new Newbikes(driver);
		nb.dropdown();
		nb.select_brand();
		Thread.sleep(2000);
		Thread.sleep(2000);
		}
	
	@Test (priority=2)
	public void bikesidentification() throws InterruptedException, IOException
		{
		Newbikes nb=new Newbikes(driver);
		nb.scrolldown();
		nb.select_viewmorebikes_tag();
		Thread.sleep(2000);
		nb.scrollup();
		nb.names();
		}	
}
