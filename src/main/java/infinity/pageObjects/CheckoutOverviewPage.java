package infinity.pageObjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import infinity.utility.UtilityMethods;

public class CheckoutOverviewPage extends UtilityMethods{

	WebDriver driver;
	
	public CheckoutOverviewPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	By checkoutTitle = By.id("checkout_summary_container");
		
	public void checkPageLoad() {
		waitForElementDisplay(checkoutTitle);
	}
	
	@FindBy(css = ".cart_item")
	List<WebElement> productsInCart;
	
	@FindBy( id = "finish")
	WebElement finishButton;
	
	public void VerifyCartProduct(String product) {
		boolean match = productsInCart
		.stream()
		.anyMatch(products -> products.findElement(By.cssSelector(".inventory_item_name")).getText().equals(product));
		if(!match) {
			throw new NoSuchElementException("Fail to find the product: " + product);
		}
	}
	
	public void clickFinish() {
		finishButton.click();
	}
	
}
