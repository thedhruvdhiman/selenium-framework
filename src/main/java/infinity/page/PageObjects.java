package infinity.page;

import org.openqa.selenium.WebDriver;

import infinity.pageObjects.CartPage;
import infinity.pageObjects.CheckoutCompletePage;
import infinity.pageObjects.CheckoutInformationPage;
import infinity.pageObjects.CheckoutOverviewPage;
import infinity.pageObjects.InventoryPage;
import infinity.pageObjects.LoginPage;

public class PageObjects {
		
	static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public PageObjects(WebDriver driver) {
		PageObjects.driver.set(driver);
	}
	
	public static LoginPage loginPage() {
	    return new LoginPage(driver.get());	
	}
	
	public static CartPage cartPage() {
		return new CartPage(driver.get());
	}
	
	public static InventoryPage inventoryPage() {
		return new InventoryPage(driver.get());
	}
	
	public static CheckoutInformationPage checkoutInformationPage() {
		return new CheckoutInformationPage(driver.get());
	}
	
	public static CheckoutOverviewPage checkoutOverviewPage() {
		return new CheckoutOverviewPage(driver.get());
	}
	
	public static CheckoutCompletePage checkoutCompletePage() {
		return new CheckoutCompletePage(driver.get());
	}	
}
