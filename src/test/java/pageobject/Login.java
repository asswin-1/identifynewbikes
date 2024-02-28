package pageobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends Basepage  {
	
	public JavascriptExecutor js;
	public Login (WebDriver driver)
	{
		super(driver);
		js = (JavascriptExecutor) driver;
	}

//LOCATORS
	
	@FindBy(xpath="//div[@id='forum_login_wrap_lg']")
	WebElement login;
	
	@FindBy(xpath="//div[@class='lgn-sc c-p txt-l pl-30 pr-30 googleSignIn']")
	WebElement google_login;
	
	@FindBy(id="identifierId")
	WebElement mail;
	
	@FindBy(xpath="//*[@id=\"identifierNext\"]/div/button")
	WebElement Next_step_button;
	
	@FindBy(xpath="input[name='Passwd']")
	WebElement password;
	
	@FindBy(xpath="//font[contains(text(),'Please enter a valid email address or phone number')]")
	WebElement mail_error_msg;
	
	@FindBy(xpath="//font[contains(text(),'The password is wrong, please try again, or click ')]")
	WebElement password_error_msg;
	
//ACTIONS
	
	public void login() throws InterruptedException
	{
		login.click();
		Thread.sleep(3000);
	}
	
	public void google()
	{
		google_login.click();	
	}

	//HANDLING WINDOWS
	public void windowHandle()
	{
	  Set<String> windowIds=driver.getWindowHandles();
      List<String> windowidsList = new ArrayList<String>(windowIds);
//    String parentId=windowidsList.get(0);
      String childId=windowidsList.get(1);
      driver.switchTo().window(childId);
      driver.manage().window().maximize();
//    System.out.println(windowidsList);
	}
	
	public void invalid_mail(String Email) throws InterruptedException
	{
		mail.sendKeys(Email);
		Thread.sleep(2000);
		Next_step_button.click();
		mail.clear();
	}
	public void invalid_password(String Email,String pwd)
	{
		mail.sendKeys(Email);
		Next_step_button.click();
	}
}
