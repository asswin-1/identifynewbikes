package Cucumber.StepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.Newbikes;
import pageobject.Usedcars;

public class usedcarsinchennai {
	
	public WebDriver driver;
	Usedcars usc;
	
	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {
	    usc=new Usedcars(BaseClass.driver);
	    usc.usedcartag();
	}

	@When("the user clicks the used cars in chennai")
	public void the_user_clicks_the_used_cars_in_chennai() {
	   usc.selectcity();
	}

	@Then("print the popular models")
	public void print_the_popular_models() throws IOException {
	  usc.scroll();
	  usc.listofpopularmodels();
	}

	@Then("go back to home page")
	public void go_back_to_home_page() {
	    usc.scrollup1();
	    usc.Homepage();
	}


}
