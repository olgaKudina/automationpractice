package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class PurchaseTest extends BaseTest {

    @Test
    public void purchaseProductTest() {
        homeSteps.openHomePageLoginAndReturnToHomePage(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        purchaseSteps.addProductToCartAndPurchaseIt("Faded Short Sleeve T-shirts");
        Assert.assertEquals(orderConfirmationPage.finishPurchase(), "Your order on My Store is complete.");
    }
}
