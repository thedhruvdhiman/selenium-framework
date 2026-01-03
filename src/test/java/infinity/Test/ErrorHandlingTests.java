package infinity.Test;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import infinity.Test.Components.Base;
import infinity.page.PageObjects;
import infinity.pageObjects.CartPage;
import infinity.pageObjects.InventoryPage;
import infinity.pageObjects.LoginPage;

public class ErrorHandlingTests extends Base {
     
	final String errorMessage = "Epic sadface: Username and password do not match any user in this service";
	
	final String productToAdd = "Sauce Labs Backpack";
	
	@Test(groups= {"ErrorHandling"})
	public void LoginError() {
		LoginPage loginPage = PageObjects.loginPage();
		String value = loginPage.enterIncorrectLoginValuesAndClickLogin("asdfghjkl", "asdfghjkl");
		AssertJUnit.assertEquals(value, errorMessage);
	}
	
	@Test(groups= {"ErrorHandling"})
	public void incorrectOrder () {
		LoginPage loginPage = PageObjects.loginPage();
		CartPage cartPage = PageObjects.cartPage();
	    InventoryPage inventoryPage = PageObjects.inventoryPage();

		loginPage.enterLoginValuesAndClickLogin("standard_user", "secret_sauce");

		inventoryPage.addProductToCart(productToAdd);
		inventoryPage.clickCart();
		
		boolean found =  cartPage.VerifyCartProduct("Sauce");
		AssertJUnit.assertFalse(found);

	}


}
