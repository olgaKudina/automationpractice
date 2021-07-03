package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class PurchaseTest extends BaseTest{

    @Test
    public void purchaseProductTest(){
        driver.get(LoginPage.BASE_URL);
        Assert.assertEquals(productsPage.purchaseProduct("Faded Short Sleeve T-shirts"), "Your order on My Store is complete.");
    }
}
