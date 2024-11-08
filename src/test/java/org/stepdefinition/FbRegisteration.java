package org.stepdefinition;

import org.sam.BaseClass;
import org.sam.SignINPojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FbRegisteration extends BaseClass{
	
	SignINPojo s;
	@Given("To Launch the browser and maximise window")
	public void to_Launch_the_browser_and_maximise_window() {
	   launchBrowser();
	   windowMaximize();
	}

	@When("To launch url of Fb application")
	public void to_launch_url_of_Fb_application() {
	   launchUrl("https://www.myntra.com/");
	}

	/*
	 * @When("To click the Create new account Button") public void
	 * to_click_the_Create_new_account_Button() { s = new SignINPojo(); //
	 * clickButton(s.getCreateNewAcc()); }
	 * 
	 * @When("To pass First name in first name text box") public void
	 * to_pass_First_name_in_first_name_text_box() { s = new SignINPojo();
	 * passText("Saranya", s.getFirstnameTxtBox()); }
	 * 
	 * 
	 * @When("To pass Second name in Second name text box") public void
	 * to_pass_Second_name_in_Second_name_text_box() { s = new SignINPojo();
	 * passText("M", s.getSecondnameTxtBox()); }
	 * 
	 * @When("To pass mobile number or email in email text box") public void
	 * to_pass_mobile_number_or_email_in_email_text_box() { s = new SignINPojo();
	 * passText("9954679054", s.getEmailTxtBox()); }
	 * 
	 * @When("To create a new password") public void to_create_a_new_password() { s
	 * = new SignINPojo(); passText("S@123df", s.getPwdTxtBox()); }
	 * 
	 * @Then("To Close the browser") public void to_Close_the_browser() {
	 * //closeEntireBrowser(); }
	 */
}
