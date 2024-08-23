package com.tarottalk.today.stepdefenitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.tarottalk.today.Driverfactory;
import com.tarottalk.today.pages.RegistrationPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tarottalk.today.utility.PropertieFileConfig;

public class Registration extends PropertieFileConfig {

	private WebDriver driver;
	private RegistrationPage registerPage;
	private Properties propertiefile;

	@Before
	public void setup() {
		driver = Driverfactory.getInstance();
	}

	@After
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

	@Given("User can able to click NewRegistration link")
	public void userCanAbleToClickNewRegistrationLink() {
		propertiefile = config();
		driver.get(propertiefile.getProperty("url"));
		registerPage = new RegistrationPage(driver);
		registerPage.clickSignup();
	}

	@Given("User Entering the fullname as {string}")
	public void userEnteringTheFullnameAs(String fullname) {
		registerPage.enterName(fullname);

	}

	@Given("User Entering the moblie as {string}")
	public void userEnteringTheMoblieAs(String moblie) {
		registerPage.enterMobile(moblie);

	}

	@Given("User Entering the email as {string}")
	public void userEnteringTheEmailAs(String email) {
		registerPage.enterEmail(email);

	}

	@Given("User Entering the password as {string}")
	public void userEnteringThePasswordAs(String password) {
		registerPage.enterPassword(password);

	}

	@Given("User Entering the gender as {string}")
	public void userEnteringTheGenderAs(String gender) {

		registerPage.enterGender(gender);
	}

	@Given("User Entering the usertype as {string}")
	public void userEnteringTheUsertypeAs(String usertype) {
		registerPage.enterUsertype(usertype);

	}

	@When("User click Signup button")
	public void userClickSignupButton() {
		registerPage.clickSigupbtn();

	}

	@Then("verify the user Register Succesfully")
	public void verifyTheUserRegisterSuccesfully() {

		String actual = registerPage.succesMsg();
		Assert.assertEquals(actual, "LOGOUT");
	}
}
