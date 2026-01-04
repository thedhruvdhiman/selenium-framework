package infinity.stepDefination;

import infinity.Test.Components.Base;
import infinity.page.PageObjects;
import infinity.pageObjects.*;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class Order extends Base {


    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutInformationPage cp;
    CheckoutOverviewPage co;
    CheckoutCompletePage cc;

    private String username;
    private String password;

    // Initialize all the objects here
    public Order () {
        loginPage = PageObjects.loginPage();
        inventoryPage = PageObjects.inventoryPage();
        cartPage = PageObjects.cartPage();
        cp = PageObjects.checkoutInformationPage();
        co = PageObjects.checkoutOverviewPage();
        cc = PageObjects.checkoutCompletePage();
    }

    @Given("I open browser and go to demo website")
    public void i_open_browser_and_go_to_demo_website() {
        // Do nothing -> Handled with Hooks
    }


    @Given("^I login with (.*) and (.*)$")
    public void iLoginWithUseridAndPassword(String userid, String password) {
        this.username = userid;
        this.password = password;
        this.loginPage.enterLoginValuesAndClickLogin(userid, password);
    }

    @When("^I add (.*) to cart$")
    public void iAddProductnameToCart(String productName) {
        inventoryPage.addProductToCart(productName);
        inventoryPage.clickCart();
    }

    @And("^I checkout the product (.*)$")
    public void iCheckoutTheProductProductName(String productName) {
        cartPage.VerifyCartProduct(productName);
        cartPage.checkOutCart();
        cp.enterCheckoutDetails(username, password, "123456");
        cp.clickContinue();

        co.VerifyCartProduct(productName);
        co.clickFinish();
    }

    @Then("I verify the payment is completed")
    public void iVerifyThePaymentIsCompleted() {
        Assert.assertEquals(cc.ConfirmationText(), "Thank you for your order!");
    }
}
