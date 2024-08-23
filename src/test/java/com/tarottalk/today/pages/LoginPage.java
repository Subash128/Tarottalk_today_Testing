package com.tarottalk.today.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;

	private By signinlink = By.xpath("(//li[@class='nav-item']/a)[3]");
	private By mobile = By.id("mobile");
	private By password = By.id("password");
	private By signinbtn = By.xpath("//input[@type='submit'and@name='submit']");
	private By errMsg = By.xpath("//span[@class='text-pink']");
	private By successMsg = By.xpath("(//li[@class='nav-item']/a)[4]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSignin() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(signinlink));
		driver.findElement(signinlink).click();
	}

	public void EnterMobile(String Mobile) {
		driver.findElement(mobile).sendKeys(Mobile);
	}

	public void EnterPassword(String Password) {
		driver.findElement(password).sendKeys(Password);
	}

	public void clickSigninbtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(signinbtn));
		WebElement Signin = driver.findElement(signinbtn);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", Signin);
		js.executeScript("arguments[0].click();", Signin);
	}

	public String errMessage() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(errMsg));
		return driver.findElement(errMsg).getText();
	}

	public String succesMsg() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(successMsg));
		return driver.findElement(successMsg).getText();
	}

}
