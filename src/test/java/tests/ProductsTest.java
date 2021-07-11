package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {
    @Test
    public void searchTest() {
        loginPage.openPage();
        homePage.search("Blouse");
        homePage.getSearchResult();
        Assert.assertTrue(homePage.getSearchResult());
    }

    @Test
    public void getProductDetailsPageAndCheckPrice() {
        loginPage.openPage();
        homePage.goFromProductsPageToProductDetailsPage("Faded Short Sleeve T-shirts");
        Assert.assertEquals(productDetailsPage.getProductPriceOnDetailsPage(), "$16.51");
    }

    @Test
    public void removeProductFromCart() {
        loginPage.openPage();
        addProductsToCartSteps.addProduct("Faded Short Sleeve T-shirts");
        shoppingCartSummaryPage.removeProductFromCart();
        shoppingCartSummaryPage.confirmRemovalProductFromCart();
        Assert.assertEquals(shoppingCartSummaryPage.confirmRemovalProductFromCart(), "Your shopping cart is empty.");
    }
}
