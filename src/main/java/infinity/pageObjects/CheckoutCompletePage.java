package infinity.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import infinity.utility.UtilityMethods;

public class CheckoutCompletePage extends UtilityMethods{

	WebDriver driver;
	
	public CheckoutCompletePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = ".checkout_complete_container h2")
	WebElement confirmationText;
	
	@FindBy(id="back-to-products")
	WebElement backToHomeButton;
	
	public String ConfirmationText() {
		 return confirmationText.getText();
	}
	
	public void clickBackToHomeButton() {
		backToHomeButton.click();;
	}

}
