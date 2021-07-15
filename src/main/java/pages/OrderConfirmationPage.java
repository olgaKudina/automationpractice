package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

@Log4j2
public class OrderConfirmationPage extends HeaderPage {

    public static final By CONFIRMATION_TEXT = By.xpath("//*[contains(text(),'Your order on My Store is complete.')]");

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String getConfirmationText() {
        WaitForElement.waitForElementPresence(driver, CONFIRMATION_TEXT, 30);
        String confirmationText = driver.findElement(CONFIRMATION_TEXT).getText();
        return confirmationText;
    }
}
