package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

@Log4j2
public class ProductAddedToCartModulePage extends BasePage {

    public static final By CONFIRMATION_ADD_TO_CART_BUTTON = By.xpath("//*[contains(text(),'Proceed to checkout')]");

    public ProductAddedToCartModulePage(WebDriver driver) {
        super(driver);
    }

    @Step("Confirm that Product was added to Cart")
    public ShoppingCartSummaryPage confirmProductAddedToCart() {
        WaitForElement.waitForElementPresence(driver, CONFIRMATION_ADD_TO_CART_BUTTON, 30);
        log.info("Confirm that Product was added to Cart");
        driver.findElement(CONFIRMATION_ADD_TO_CART_BUTTON).click();
        return new ShoppingCartSummaryPage(driver);
    }
}
