package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressesPage extends HeaderPage {

    public static final By CONFIRM_LOGIN_INFO_BUTTON = By.xpath("//*[contains(@name,'processAddress')]");

    public AddressesPage(WebDriver driver) {
        super(driver);
    }

    public ShippingPage confirmLoginInfo() {
        driver.findElement(CONFIRM_LOGIN_INFO_BUTTON).isDisplayed();
        driver.findElement(CONFIRM_LOGIN_INFO_BUTTON).click();
        return new ShippingPage(driver);
    }
}
