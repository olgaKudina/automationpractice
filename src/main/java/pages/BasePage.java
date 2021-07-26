package pages;
import constants.IConstant;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
abstract class BasePage implements IConstant {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    }




