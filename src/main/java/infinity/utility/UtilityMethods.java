package infinity.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityMethods {
	
	WebDriver driver;
	
	protected UtilityMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/**
	 * 
	 * Wait until an element is visible on the page
	 * 
	 * @param findBy - By
	 * */
	public void waitForElementDisplay(By findBy) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		} catch (NoSuchElementException e) {
			throw new Error(e.fillInStackTrace());
		}	
	}
	
	
	/**
	 * 
	 * Wait until an element is visible on the page
	 * 
	 * @param findBy - WebElement
	 * */
	public void waitForElementDisplay(WebElement findBy) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(findBy));
		} catch (NoSuchElementException e) {
			throw new Error(e.fillInStackTrace());
		}
	}
	
	/**
	 * 
	 * Wait until an element is visible on the page
	 * 
	 * @param findBy
	 * @param timeout - In seconds.
	 * */
	public void waitForElementDisplay(By findBy, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		} catch (NoSuchElementException e) {
			throw new Error(e.fillInStackTrace());
		}
		
	}
	
	
	/**
	 * 
	 * Wait until an element on the page becomes invisible.
	 * 
	 * @param findBy
	 * */
	public void waitForElementToDisappear(By findBy) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
		} catch (NoSuchElementException e) {
			throw new Error(e.fillInStackTrace());
		}
	}
	
	/**
	 * @param locator - By
	 * @param information - Any information you want to enter in the text box
	 * */
	public void clickAndTypeUsingActionClass(By locator, String information) {
		Actions action = new Actions(driver);
		action
			.moveToElement(driver.findElement(locator))
			.click()
			.sendKeys(information)
			.build()
			.perform();
		return;
	}

	
	/**
	 * Wait for web page to completely load.
	 * 
	 * max timeout - 15 seconds before error is thrown 
	 * */
	public void waitForPageToLoadCompletely() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(driver -> ((JavascriptExecutor)driver)
					.executeScript("return document.readyState")
					.equals("complete"));
		} catch (Exception e) {
			throw new Error("The webpage did not load completely\n" + e.fillInStackTrace());
		}
	}
	
}