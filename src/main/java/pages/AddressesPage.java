package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressesPage extends HeaderPage {

    public static final By PROCEED_TO_CHECKOUT_BUTTON_XPATH = By.xpath("//*[contains(@name,'processAddress')]");

    public AddressesPage(WebDriver driver) {
        super(driver);
    }

    public ShippingPage clickProceedToCheckoutButtonOnAddressPage() {
        driver.findElement(PROCEED_TO_CHECKOUT_BUTTON_XPATH).click();
        return new ShippingPage(driver);
    }
}
