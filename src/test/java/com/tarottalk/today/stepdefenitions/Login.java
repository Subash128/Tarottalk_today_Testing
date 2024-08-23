package com.tarottalk.today.stepdefenitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.tarottalk.today.Driverfactory;
import com.tarottalk.today.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tarottalk.today.utility.PropertieFileConfig;

public class Login extends PropertieFileConfig {

	private WebDriver driver;
	private LoginPage loginPage;
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

	@Given("User should navigate to the website")
	public void userShouldNavigateToTheWebsite() {
		propertiefile = config();
		driver.get(propertiefile.getProperty("url"));
		loginPage = new LoginPage(driver);
	}

	@And("User can able to click login button")
	public void userCanAbleToClickLoginButton() {
		loginPage.clickSignin();
	}

	@Given("User Entering mobile as {string}")
	public void userEnteringMobileAs(String mobile) {
		loginPage.EnterMobile(mobile);
	}
	
	@And("User Entering password as {string}")
	public void userEnteringPasswordAs(String password) {
		loginPage.EnterPassword(password);
	}

	@When("User click the login button")
	public void userClickTheLoginButton() {
		loginPage.clickSigninbtn();
	}

	@Then("Login should be Success")
	public void loginShouldBeSuccess() {
		String actualMsg = loginPage.succesMsg();
		Assert.assertEquals(actualMsg, "LOGOUT");
	}

	@Then("Login should be Fail")
	public void loginShouldBeFail() {
		String actualMsg = loginPage.errMessage();
		Assert.assertEquals(actualMsg, "Incorrect Mobile Number / Password");
	}

}
