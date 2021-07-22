package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

@Log4j2
public class SearchResultPage extends HeaderPage {

    public static final By SEARCH_RESULT = By.xpath("//*[contains(text(),'result has been found')]");
    public static final By SEARCH_NAME_RESULT = By.xpath("//*[@class='lighter']");
    public static final By SEARCH_CATALOG_RESULT = By.xpath("//*[@class='lighter']");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Step("Search result is displayed")
    public boolean getSearchResult() {
        log.info("Verify that Search result is displayed");
        return driver.findElement(SEARCH_RESULT).isDisplayed();
    }

    @Step("Get Searched Item Name")
    public String getSearchedItemName() {
        WaitForElement.waitForElementPresence(driver, SEARCH_CATALOG_RESULT, 30);
        String getSearchedItemName = driver.findElement(SEARCH_CATALOG_RESULT).getText();
        return getSearchedItemName;
    }
}

