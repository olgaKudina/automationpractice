package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HeaderPage extends BasePage {
    public static final By SEARCH_XPATH = By.xpath("//*[contains(@class,'search_query')]");
    public static final By SEARCH_BUTTON = By.xpath("//*[contains(@name,'submit_search')]");
    public static final By SEARCH_RESULT = By.xpath("//*[contains(text(),'result has been found')]");
    public static final By LOGOUT_BUTTON = By.xpath("//*[@class='logout']");

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

    @Step("Search result is displayed")
    public boolean getSearchResult() {
        log.info("Verify that Search result is displayed");
        return driver.findElement(SEARCH_RESULT).isDisplayed();
    }

    @Step("Click Logout")
    public HomePage logout(){
        log.info("Click on Logout button");
        driver.findElement(LOGOUT_BUTTON).click();
        return new HomePage(driver);
    }
}
