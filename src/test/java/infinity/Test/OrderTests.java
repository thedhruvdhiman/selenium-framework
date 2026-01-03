package infinity.Test;

import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;

import infinity.Test.Components.Base;
import infinity.page.PageObjects;
import infinity.pageObjects.CartPage;
import infinity.pageObjects.CheckoutCompletePage;
import infinity.pageObjects.CheckoutInformationPage;
import infinity.pageObjects.CheckoutOverviewPage;
import infinity.pageObjects.InventoryPage;
import infinity.pageObjects.LoginPage;

public class OrderTests extends Base {
     
	@Test(dataProvider="getData", groups= {"Purchase"})
	public void PlaceOrder(HashMap<String, String>input) throws Exception {
		LoginPage loginPage = PageObjects.loginPage();
		CartPage cartPage = PageObjects.cartPage();
	    InventoryPage inventoryPage = PageObjects.inventoryPage();
		CheckoutInformationPage cp = PageObjects.checkoutInformationPage();
		CheckoutOverviewPage co =PageObjects.checkoutOverviewPage();
		CheckoutCompletePage cc = PageObjects.checkoutCompletePage();
		
		String username = input.get("username");
		String password = input.get("password");
		String productName = input.get("productName");
	
		loginPage.openURL();
		
		loginPage.enterLoginValuesAndClickLogin(username, password);

		inventoryPage.addProductToCart(productName);
		inventoryPage.clickCart();
		
		cartPage.VerifyCartProduct(productName);
		cartPage.checkOutCart();

		cp.enterCheckoutDetails(username, password, "123456");
		cp.clickContinue();
		
		
		co.VerifyCartProduct(productName);
		co.clickFinish();
		
		Assert.assertEquals(cc.ConfirmationText(), "Thank you for your order!");
		
	}
	
	
	
	/* Just to understand - If the application is holding some data in server,
	 * say if we add some product and we want to check if the product is still
	 * in the cart after we logout, is the product still in the cart. We can
	 * Use dependsOnMethods - To run first and than we can run the one which
	 * is dependent upon. */
//	@Test(dependsOnMethods = {"PlaceOrder"}, dataProvider="getData")
//	public void backToHomeAfterPlaceOrder(HashMap<String, String>input) throws Exception {
//		PlaceOrder(input);
//		CheckoutCompletePage cc = PageObjects.checkoutCompletePage();
//		CartPage cartPage = PageObjects.cartPage();
//
//		cc.clickBackToHomeButton();
//		Assert.assertEquals(cartPage.verifyCartPageTitle(), input.get("productName"));
//	}
}