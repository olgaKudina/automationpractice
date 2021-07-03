package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class ProductsTest extends BaseTest {
    @Test
    public void searchTest() {
        driver.get(LoginPage.BASE_URL);
        productsPage.search();
        productsPage.getSearchResult();
        Assert.assertTrue(productsPage.getSearchResult());
    }

    @Test
    public void getProductDetailsPageAndCheckPrice(){
        driver.get(LoginPage.BASE_URL);
        productsPage.goFromProductsPageToProductDetailsPage("Faded Short Sleeve T-shirts");
        Assert.assertEquals(productDetailsPage.getProductPriceOnDetailsPage(), "$16.51");
    }
}
