package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

@Log4j2
public class ShippingPage extends HeaderPage {

    public static final By CHECKBOX = By.xpath(" //*[@id='uniform-cgv']");
    public static final By CONFIRM_AGREEMENT_BUTTON = By.xpath("//*[contains(@name,'processCarrier')]");

    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    @Step("Confirm Agreement on Purchase")
    public PaymentMethodPage confirmAgreement() {
        WaitForElement.waitForElementPresence(driver, CHECKBOX, 30);
        driver.findElement(CHECKBOX).click();
        log.info("Confirm Agreement on Purchase");
        driver.findElement(CONFIRM_AGREEMENT_BUTTON).click();
        return new PaymentMethodPage(driver);
    }
}
