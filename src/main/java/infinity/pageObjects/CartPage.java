/**
 * 
 */
package infinity.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import infinity.utility.UtilityMethods;

/**
 * 
 */
public class CartPage extends UtilityMethods {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="span[class='title']")
	WebElement title;
	
	@FindBy(css = ".cart_item")
	List<WebElement> productsInCart;

	@FindBy(id = "checkout")
	WebElement checkoutButton;	
	
	public String verifyCartPageTitle() {
		return title.getText();
	}

	public Boolean VerifyCartProduct(String product) {
		boolean foundMatch = productsInCart.stream().anyMatch(
				products -> products.findElement(By.cssSelector(".inventory_item_name")).getText().equals(product));
		return foundMatch;
	}

	public void checkOutCart() {
		checkoutButton.click();
	}

}
