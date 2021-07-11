package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@Log4j2
public class HomePage extends BasePage {
    public static final By SEARCH_XPATH = By.xpath("//*[contains(@class,'search_query')]");
    public static final By SEARCH_BUTTON = By.xpath("//*[contains(@name,'submit_search')]");
    public static final By SEARCH_RESULT = By.xpath("//*[contains(text(),'result has been found')]");
    public static final String PRODUCT_XPATH = "//a[contains(text(),'%s')]";
    public static final String MORE_DETAILS_BUTTON = "//a[contains(text(),'%s')]/ancestor::*[contains(@class,'product-container')]//span[contains(text(),'More')]";
    public static final String ADD_TO_CART_BUTTON = "//a[contains(text(),'%s')]/ancestor::*[contains(@class,'product-container')]//span[contains(text(),'Add to cart')]";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter search {searchProductName} product and apply search")
    public SearchResultPage search(String searchProductName) {
        log.info("Enter search input");
        driver.findElement(SEARCH_XPATH).sendKeys(searchProductName);
        driver.findElement(SEARCH_BUTTON).click();
        return new SearchResultPage(driver);
    }

    @Step("Search result is displayed")
    public boolean getSearchResult() {
        log.info("Search result is displayed");
        return driver.findElement(SEARCH_RESULT).isDisplayed();
    }

    @Step("Get to Page with Product {productName} details")
    public ProductDetailsPage goFromProductsPageToProductDetailsPage(String productName) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(PRODUCT_XPATH, productName)))).build().perform();
        log.info("Get to Page with Product details");
        driver.findElement(By.xpath(String.format(MORE_DETAILS_BUTTON, productName))).click();
        return new ProductDetailsPage(driver);
    }

    @Step("Add Product {productName} To Cart")
    public ProductAddedToCartModulePage addProductToCart(String productName) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(PRODUCT_XPATH, productName)))).build().perform();
        driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON, productName))).click();
        return new ProductAddedToCartModulePage(driver);
    }
}


