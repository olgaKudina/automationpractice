package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

@Log4j2
public class HeaderPage extends BasePage {
    public static final By SIGNUP_BUTTON_XPATH = By.xpath("//*[@class='login']");
    public static final By SEARCH_XPATH = By.xpath("//*[contains(@class,'search_query')]");
    public static final By SEARCH_BUTTON = By.xpath("//*[contains(@name,'submit_search')]");
    public static final By LOGOUT_BUTTON = By.xpath("//*[@class='logout']");
    public static final By USER_NAME = By.xpath("//*[@class='account']");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter search {searchProductName} product and apply search")
    public SearchResultPage search(String searchProductName) {
        log.info("Enter search input ", searchProductName);
        driver.findElement(SEARCH_XPATH).sendKeys(searchProductName);
        driver.findElement(SEARCH_BUTTON).click();
        return new SearchResultPage(driver);
    }

    @Step("Click Logout")
    public HomePage logout(){
        log.info("Click on Logout button");
        driver.findElement(LOGOUT_BUTTON).click();
        return new HomePage(driver);
    }

    @Step("Click Signin button")
    public LoginPage clickSigninButton(){
        driver.findElement(SIGNUP_BUTTON_XPATH).click();
        return new LoginPage(driver);
    }

    public String getUserName(){
       WaitForElement.waitForElementPresence(driver, USER_NAME, 30);
       return driver.findElement(USER_NAME).getText();
    }
}
