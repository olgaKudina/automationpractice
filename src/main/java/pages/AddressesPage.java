package pages;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

@Log4j2
public class AddressesPage extends HeaderPage {

    public static final By PROCEED_TO_CHECKOUT_BUTTON_XPATH = By.xpath("//*[contains(@name,'processAddress')]");

    public AddressesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click 'Proceed to Checkout' button to confirm Address information")
    public ShippingPage clickProceedToCheckoutButtonOnAddressPage() {
        log.info("Click 'Proceed to Checkout' button");
        WaitForElement.waitForElementPresence(driver,PROCEED_TO_CHECKOUT_BUTTON_XPATH, 30);
        driver.findElement(PROCEED_TO_CHECKOUT_BUTTON_XPATH).click();
        return new ShippingPage(driver);
    }
}
