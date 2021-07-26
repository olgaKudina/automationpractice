package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

@Log4j2
public class PaymentMethodPage extends HeaderPage {

    public static final By PAYMENT_MODULE_BUTTON = By.xpath("//*[@class='payment_module']");

    public PaymentMethodPage(WebDriver driver) {
        super(driver);
    }

    @Step("Choose payment method: Click 'Pay by bank wire' button")
    public OrderSummaryPage chooseBankWirePaymentMethod() {
        WaitForElement.waitForElementPresence(driver, PAYMENT_MODULE_BUTTON, 30);
        log.info("Click 'Pay by bank wire' button");
        driver.findElement(PAYMENT_MODULE_BUTTON).click();
        return new OrderSummaryPage(driver);
    }
}
