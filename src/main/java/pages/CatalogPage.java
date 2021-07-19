package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CatalogPage extends HeaderPage {
    public static final By CATALOG_XPATH = By.xpath("//*[contains(text(),'Catalog')]");

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public String confirmCatalogName() {
        String catalogName = driver.findElement(CATALOG_XPATH).getText();
        return catalogName;
    }
}
