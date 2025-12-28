package infinity.page;

import org.openqa.selenium.WebDriver;

import infinity.pageObjects.CartPage;
import infinity.pageObjects.CheckoutCompletePage;
import infinity.pageObjects.CheckoutInformationPage;
import infinity.pageObjects.CheckoutOverviewPage;
import infinity.pageObjects.InventoryPage;
import infinity.pageObjects.LoginPage;

public class PageObjects {
		
	static WebDriver driver;
	
	public PageObjects(WebDriver driver) {
		PageObjects.driver = driver;
	}
	
	public static LoginPage loginPage() {
	    return new LoginPage(driver);	
	}
	
	public static CartPage cartPage() {
		return new CartPage(driver);
	}
	
	public static InventoryPage inventoryPage() {
		return new InventoryPage(driver);
	}
	
	public static CheckoutInformationPage checkoutInformationPage() {
		return new CheckoutInformationPage(driver);
	}
	
	public static CheckoutOverviewPage checkoutOverviewPage() {
		return new CheckoutOverviewPage(driver);
	}
	
	public static CheckoutCompletePage checkoutCompletePage() {
		return new CheckoutCompletePage(driver);
	}	
}
