package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{
    public static final By SEARCH_XPATH = By.xpath("//*[contains(@class,'search_query')]");
    public static final By SEARCH_BUTTON = By.xpath("//*[contains(@name,'submit_search')]");
    public static final By SEARCH_RESULT = By.xpath("//*[contains(text(),'result has been found')]");

    public static final String PRODUCT_XPATH = "//*[@class='product-container']//ancestor::*[@title='%s']";
    public static final String PRODUCT_PRICE_XPATH = "//span[contains(@id,'our_price_display')]";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage search() {
        driver.findElement(SEARCH_XPATH).sendKeys("Blouse");
        driver.findElement(SEARCH_BUTTON).click();
        return new SearchResultPage(driver);
    }

    public boolean getSearchResult() {
        return driver.findElement(SEARCH_RESULT).isDisplayed();
    }
}
