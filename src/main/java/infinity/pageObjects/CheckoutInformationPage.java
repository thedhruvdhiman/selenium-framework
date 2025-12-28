package infinity.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import infinity.utility.UtilityMethods;

public class CheckoutInformationPage extends UtilityMethods{

	WebDriver driver;
	
	public CheckoutInformationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	By firstName = By.id("first-name");
	By lastName = By.id("last-name");
	By zipCode = By.id("postal-code");
	
	@FindBy(id="continue")
	WebElement continueButton;
	
	public void enterCheckoutDetails(String firstname, String lastname, String zipcode) {
		clickAndTypeUsingActionClass(firstName, firstname);
		clickAndTypeUsingActionClass(lastName, lastname);
		clickAndTypeUsingActionClass(zipCode, zipcode);
	}
	
	public void clickContinue() {
		continueButton.click();
	}
	
}
