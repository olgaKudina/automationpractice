package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

@Log4j2
public class ShoppingCartSummaryPage extends HeaderPage {

    public static final By CONFIRMATION_SUMMARY_BUTTON = By.xpath("//*[contains(@class,'standard-checkout')]");
    public static final By ICON_TRASH_XPATH = By.xpath("//*[@class='icon-trash']");
    public static final By REMOVAL_PRODUCT_CONFIRMATION_TEXT = By.xpath("//*[@class='alert alert-warning']");


    public ShoppingCartSummaryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Confirm that Summary Information is correct by clicking 'Proceed to checkout'")
    public AddressesPage confirmSummaryInfo() {
        WaitForElement.waitForElementPresence(driver, CONFIRMATION_SUMMARY_BUTTON, 30);
        driver.findElement(CONFIRMATION_SUMMARY_BUTTON).isDisplayed();
        log.info("Click 'Proceed to checkout' button to confirm that Summary Info is correct");
        driver.findElement(CONFIRMATION_SUMMARY_BUTTON).click();
        return new AddressesPage(driver);
    }

    @Step("Click on Trash button and remove Product from Cart")
    public ShoppingCartSummaryPage removeProductFromCart() {
        WaitForElement.waitForElementPresence(driver, ICON_TRASH_XPATH, 50);
        log.info("Click on Trash button and remove Product from Cart");
        driver.findElement(ICON_TRASH_XPATH).click();
        return this;
    }

    @Step("Get Confirmation text that Product was removed from Cart")
    public String confirmRemovalProductFromCart() {
        WaitForElement.waitForElementPresence(driver, REMOVAL_PRODUCT_CONFIRMATION_TEXT, 50);
        log.info("Confirmation text that Product was removed from Cart is displayed");
        String removalConfirmationText = driver.findElement(REMOVAL_PRODUCT_CONFIRMATION_TEXT).getText();
        return removalConfirmationText;
    }
}
