package Cucumber.StepDefinition;

import factory.BaseClass;
import java.io.IOException;

import pageobject.Newbikes;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class hondabike extends BaseClass{
	
	public WebDriver driver;
	Newbikes ng;
	
	@Given("the user is on the zigwheels homepage")
	public void the_user_is_on_the_zigwheels_homepage() throws IOException {
		ng=new Newbikes(BaseClass.driver);
		ng.newbikes_tag();
	}

	@When("the user hovers to the new bikes tab and clicks the upcoming bikes tab")
	public void the_user_hovers_to_the_new_bikes_tab_and_clicks_the_upcoming_bikes_tab() {
		
		ng.select_upcomingbikes();
	}

	@When("the user selects honda model")
	public void the_user_selects_honda_model() {
		ng.dropdown();
		ng.select_brand();
	}

	@When("the user scrolls down and clicks the view more bikes button")
	public void the_user_scrolls_down_and_clicks_the_view_more_bikes_button() {
		ng.scrolldown();
		ng.select_viewmorebikes_tag(); 
	}

	@Then("the user should able to get the bikes below {int} lakh")
	public void the_user_should_able_to_get_the_bikes_below_lakh(Integer int1) throws InterruptedException, IOException {
		ng.scrollup();
		ng.names();
	}
}
