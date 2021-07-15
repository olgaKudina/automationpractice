package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class MyAccountPage extends BasePage {
    public static final By MY_ACCOUNT_NAVIGATE_PAGE = By.xpath("//span[contains(text(),'My account')]");
    public static final By AUTHENTICATION_NAVIGATE_PAGE = By.xpath("//*[contains(text(),'Authentication')]");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify my Account Navigate Page is displayed after successful Login")
    public boolean isMyAccountNavigatePageDisplayed() {
        return driver.findElement(MY_ACCOUNT_NAVIGATE_PAGE).isDisplayed();
    }

    @Step("Verify Authentication Navigate Page is displayed after Logout")
    public boolean isAuthenticationNavigatePageDisplayed() {
        return driver.findElement(AUTHENTICATION_NAVIGATE_PAGE).isDisplayed();
    }
}
