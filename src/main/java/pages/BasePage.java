package pages;
import constants.IConstant;
import org.openqa.selenium.WebDriver;

abstract class BasePage implements IConstant {
    WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }
}



