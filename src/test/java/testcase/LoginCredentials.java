package testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import pageobject.Login;
import testbase.Baseclass;
import utilities.DataProviders;

public class LoginCredentials extends Baseclass {
	
	@Test(priority = 6)
	public void login() throws InterruptedException 
	{
	 Login lg = new Login(driver);
	 lg.login();
	 lg.google();
	 System.out.println("List of windows:");
	 lg.windowHandle();
	}
	
	@Test(priority = 7,dataProvider="invalid_password",dataProviderClass=DataProviders.class)
	public void password_validation(String email,String password) throws InterruptedException, IOException 
	{
		Login lg = new Login(driver);
	    lg.invalid_password(email,password);
	    Thread.sleep(2000);
	}
}



