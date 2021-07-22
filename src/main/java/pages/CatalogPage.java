package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

@Log4j2
public class CatalogPage extends HeaderPage {
    public static final By CATALOG_TITLE_XPATH = By.xpath("//*[contains(text(),'Catalog')]");
    public static final By CATALOG_SEARCH_ITEM = By.xpath("//*[@class='cat-name']");


    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public String getCatalogTitleText() {
        String catalogName = driver.findElement(CATALOG_TITLE_XPATH).getText();
        return catalogName;
    }

    @Step("Get Searched Item Name")
    public String getCatalogSearchItem() {
        WaitForElement.waitForElementPresence(driver, CATALOG_SEARCH_ITEM, 30);
        String getProductItemName = driver.findElement(CATALOG_SEARCH_ITEM).getText();
        return getProductItemName;
    }

}
