package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{
    public static final By MY_ACCOUNT_NAVIGATE_PAGE = By.xpath("//span[contains(text(),'My account')]");
    public static final By AUTHENTICATION_NAVIGATE_PAGE = By.xpath("//*[contains(text(),'Authentication')]");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean getMyAccountNavigatePage(){
        return driver.findElement(MY_ACCOUNT_NAVIGATE_PAGE).isDisplayed();
    }
    public boolean getAuthenticationNavigatePage(){
        return driver.findElement(AUTHENTICATION_NAVIGATE_PAGE).isDisplayed();
    }
}
