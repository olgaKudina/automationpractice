package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

@Log4j2
public class OrderSummaryPage extends HeaderPage {

    public static final By CONFIRM_MY_MODULE_BUTTON = By.xpath("//*[@id='cart_navigation']/button");

    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Confirm Order Summary by clicking 'I confirm my Order'")
    public OrderConfirmationPage confirmOrderSummary() {
        WaitForElement.waitForElementPresence(driver, CONFIRM_MY_MODULE_BUTTON, 30);
        log.info("Click 'I confirm my Order' button");
        driver.findElement(CONFIRM_MY_MODULE_BUTTON).click();
        return new OrderConfirmationPage(driver);
    }
}
