package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@Log4j2
public class HomePage extends BasePage {

    public static final String PRODUCT_XPATH = "//a[contains(text(),'%s')]";
    public static final String MORE_DETAILS_BUTTON = "//a[contains(text(),'%s')]/ancestor::*[contains(@class,'product-container')]//span[contains(text(),'More')]";
    public static final String ADD_TO_CART_BUTTON = "//a[contains(text(),'%s')]/ancestor::*[contains(@class,'product-container')]//span[contains(text(),'Add to cart')]";
    public static final String PRODUCT_GROUP_XPATH = "//a[@title='%s']";
    public static final String PRODUCT_ITEM_XPATH = "//a[@title='%s']";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open page {url}")
    public HomePage openPage() {
        try {
            driver.get(BASE_URL);
            return this;
        } catch (Exception e) {
            System.out.println("Site is unavailable");
            return this;
        }
    }

    @Step("Click 'More' button to get to Page with Product {productName} details")
    public ProductDetailsPage clickOnProductItem(String productName) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(PRODUCT_XPATH, productName)))).build().perform();
        log.info("Click on 'More' button to get to Product {productName} details page");
        driver.findElement(By.xpath(String.format(MORE_DETAILS_BUTTON, productName))).click();
        return new ProductDetailsPage(driver);
    }

    @Step("Add Product {productName} To Cart")
    public ProductAddedToCartModulePage addProductToCart(String productName) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(PRODUCT_XPATH, productName)))).build().perform();
        log.info("Click on 'Add to cart' button to add {productName} to Cart");
        driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON, productName))).click();
        return new ProductAddedToCartModulePage(driver);
    }

    @Step("Select Product in Products Module and go to Catalog")
    public CatalogPage selectProductItemAndGoToCatalog(String productGroupName, String productItem){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(PRODUCT_GROUP_XPATH, productGroupName)))).build().perform();
        driver.findElement(By.xpath(String.format(PRODUCT_ITEM_XPATH, productItem))).click();
        return new CatalogPage(driver);
    }
}


