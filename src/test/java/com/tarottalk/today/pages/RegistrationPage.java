package com.tarottalk.today.pages;

import static com.tarottalk.today.Driverfactory.element;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

	private WebDriver driver;
	
	private By signuplink = By.xpath("(//p/u/a[@class='regster-bn'])[3]");
	private By fullname = By.xpath("//input[@name='fullname']");
	private By mobile = By.xpath("//input[@id='mobile']");
	private By gender = By.xpath("//input[@id='rbMale']");
	private By usertype = By.xpath("//input[@name='userlevel']");
	private By password = By.xpath("//input[@id='password']");
	private By signupbtn = By.xpath("//input[@name='submit']");
	private By successMsg = By.xpath("(//li[@class='nav-item']/a)[4]");

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;

	}

	public void clickSignup() {
		// driver.findElement(signuplink).click();
		WebElement Signup = element(signuplink);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", Signup);
		js.executeScript("arguments[0].click();", Signup);

	}

	public void enterName(String value) {
		element(fullname).sendKeys(value);
		;
	}

	public void enterMobile(String value) {
		element(mobile).sendKeys(value);

	}

	public void enterEmail(String value) {
		element(RelativeLocator.with(By.tagName("input")).below(mobile)).sendKeys(value);
		;
	}

	public void enterGender(String value) {
		List<WebElement> genders = driver.findElements(gender);
		for (WebElement genderlist : genders) {
			if (genderlist.getAttribute("value").equals(value)) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView()", genderlist);
				js.executeScript("arguments[0].click();", genderlist);
				break;
			}
		}

	}

	public void enterUsertype(String value) {
		List<WebElement> usertypes = driver.findElements(usertype);
		for (WebElement usertypelist : usertypes) {
			if (usertypelist.getAttribute("value").equals(value)) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView()", usertypelist);
				js.executeScript("arguments[0].click();", usertypelist);
				break;
			}
		}
	}

	public void enterPassword(String value) {
		element(password).sendKeys(value);
	}

	public void clickSigupbtn() {
		WebElement Signup = element(signupbtn);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", Signup);
		js.executeScript("arguments[0].click();", Signup);

	}

	public String succesMsg() {

		return element(successMsg).getText();
	}

}
