package Cucumber.StepDefinition;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.Login;

public class invalidlogin {
	
	public WebDriver driver;
	Login login;
	
	@Given("the user on the homepage and clicks login button")
	public void the_user_on_the_homepage_and_clicks_login_button() throws InterruptedException {
	    login=new Login(BaseClass.driver);
	    login.login();
	}

	@When("the page is directed to the login page")
	public void the_page_is_directed_to_the_login_page() {
		login.google();
	}

	@Then("the user enters email as {string}")
	public void the_user_enters_email_as(String string) throws InterruptedException {
		login.windowHandle();
		login.invalid_password(string, string);
	}

}
