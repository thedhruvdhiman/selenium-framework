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
public class InventoryPage extends UtilityMethods {
	
	WebDriver driver;
	
	public InventoryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By title = By.xpath("//span[text() = 'Products']");
	
	@FindBy(css=".inventory_item_description")
	List<WebElement> products;
	
	@FindBy(id = "shopping_cart_container")
	WebElement shoppingButton;
	/**
	 * 
	 * @param - Return the list of all the products in the inventory.
	 * 
	 * */
	public List<WebElement> returnProductList() {
		waitForElementDisplay(title);
		return products;
	}
	
	private WebElement returnProduct(String productName) {
		WebElement prod = returnProductList()
				.stream()
				.filter(products -> products.findElement(By.cssSelector(".inventory_item_name "))
						.getText().equals(productName))
				.findFirst()
				.orElse(null);
		return prod;
	}

	
	public void addProductToCart(String productName) {
		WebElement productContainer = returnProduct(productName);
		productContainer.findElement(By.tagName("button")).click();
	}
	
	
	/**
	 * Click shopping cart button on title bar
	 * */
	public void clickCart() {
		shoppingButton.click();
	}

}
