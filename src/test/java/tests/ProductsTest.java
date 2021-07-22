package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {
    @Test
    public void searchTest() {
        homePage.openPage();
        headerPage.search("Blouse");
        searchResultPage.getSearchResult();
        Assert.assertTrue(searchResultPage.getSearchResult());
        Assert.assertEquals(searchResultPage.getSearchedItemName(), "\"BLOUSE\"");
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

    @Test
    public void addProductToCartAndCheckQuantity(){
        homePage.openPage();
        addProductsToCartSteps.addProduct("Faded Short Sleeve T-shirts");
        shoppingCartSummaryPage.getProductQuantity();
        Assert.assertEquals(shoppingCartSummaryPage.getProductQuantity(), "1");
    }

    @Test
    public void searchThroughCatalog(){
        homePage.openPage();
        homePage.selectProductItemAndGoToCatalog("Women", "Blouses");
        Assert.assertEquals(catalogPage.getCatalogTitleText(), "CATALOG");
        Assert.assertEquals(catalogPage.getCatalogSearchItem(), "BLOUSES ");
    }
}
