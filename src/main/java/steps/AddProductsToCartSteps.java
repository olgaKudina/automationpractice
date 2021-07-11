package steps;

import org.openqa.selenium.WebDriver;
import pages.*;

public class AddProductsToCartSteps {
    WebDriver driver;
    private HomePage homePage;
    private ProductAddedToCartModulePage productAddedToCartModulePage;

    public AddProductsToCartSteps(WebDriver driver) {
        homePage = new HomePage(driver);
        productAddedToCartModulePage = new ProductAddedToCartModulePage(driver);
    }

    public AddProductsToCartSteps addProduct(String productName) {
        homePage.addProductToCart(productName);
        productAddedToCartModulePage.confirmProductAddedToCart();
        return this;
    }
}
