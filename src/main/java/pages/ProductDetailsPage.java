package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class ProductDetailsPage extends BasePage{
    public static final By PRODUCT_PRICE_XPATH = By.xpath("//*[contains(@id,'our_price_display')]");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductPriceOnDetailsPage(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String price = driver.findElement(PRODUCT_PRICE_XPATH).getText();
        return price;
    }
}

