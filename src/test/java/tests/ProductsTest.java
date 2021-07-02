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
}
