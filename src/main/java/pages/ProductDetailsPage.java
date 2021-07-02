package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{
    public static final By PRODUCT_PRICE = By.xpath("//*[contains(@id,'our_price_display')]");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
}

