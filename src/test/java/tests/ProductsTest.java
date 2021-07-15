package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {
    @Test
    public void searchTest() {
        homePage.openPage();
        headerPage.search("Blouse");
        headerPage.getSearchResult();
        Assert.assertTrue(headerPage.getSearchResult());
    }

    @Test
    public void getProductDetailsPageAndCheckPrice() {
        homePage.openPage();
        homePage.clickOnProductItem("Faded Short Sleeve T-shirts");
        Assert.assertEquals(productDetailsPage.getProductPriceOnDetailsPage(), "$16.51");
    }

    @Test
    public void removeProductFromCart() {
        homePage.openPage();
        addProductsToCartSteps.addProduct("Faded Short Sleeve T-shirts");
        shoppingCartSummaryPage.removeProductFromCart();
        shoppingCartSummaryPage.confirmRemovalProductFromCart();
        Assert.assertEquals(shoppingCartSummaryPage.confirmRemovalProductFromCart(), "Your shopping cart is empty.");
    }
}
