package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

@Log4j2
public class CreateAccountPage extends HeaderPage{

    public static final String PERSONAL_INFORMATION_INPUT = "//label[contains(text(),'%s')]/ancestor::div[contains(@class,'form-group')]//*[contains(@class,'is_required')]";
    public static final String ADDRESS_INFORMATION_INPUT = "//label[contains(@for,'%s')]/ancestor::p[contains(@class,'form-group')]//*[contains(@class,'form-control')]";
    public static final String DROPDOWN_STATE = "//label[contains(text(),'%s')]/ancestor::p[contains(@class,'form-group')]//*[contains(@class,'form-control')]";
    public static final String STATE_XPATH = "//*[@name='id_state']/option[contains(text(),'%s')]";
    public static final By REGISTER_BUTTON = By.xpath("//*[@id='submitAccount']");
    public static final String NEW_ACCOUNT_CREATED_TEXT = "//*[contains(text(),'Welcome to your account. Here you can manage all of your personal information and orders.')]";

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill in Registration form to create new account")
    public void fillInAccountForm(String firstName, String  lastName, String password, String address1, String city, String phone, String postcode, String alias){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        log.info("Enter First name {firstName}");
        driver.findElement(By.xpath(String.format(PERSONAL_INFORMATION_INPUT, "First name"))).sendKeys(firstName);
        log.info("Enter Last name {lastName}");
        driver.findElement(By.xpath(String.format(PERSONAL_INFORMATION_INPUT, "Last name"))).sendKeys(lastName);
        log.info("Enter password {password}");
        driver.findElement(By.xpath(String.format(PERSONAL_INFORMATION_INPUT, "Password"))).sendKeys(password);
        log.info("Enter Address1 {address1}");
        driver.findElement(By.xpath(String.format(ADDRESS_INFORMATION_INPUT, "address1"))).sendKeys(address1);
        log.info("Enter city {city}");
        driver.findElement(By.xpath(String.format(ADDRESS_INFORMATION_INPUT, "city"))).sendKeys(city);
        log.info("Enter phone number {phone}");
        driver.findElement(By.xpath(String.format(ADDRESS_INFORMATION_INPUT, "phone_mobile"))).sendKeys(phone);
        log.info("Enter postcode {postcode}");
        driver.findElement(By.xpath(String.format(ADDRESS_INFORMATION_INPUT, "postcode"))).sendKeys(postcode);
        log.info("Enter alias {alias}");
        driver.findElement(By.xpath(String.format(ADDRESS_INFORMATION_INPUT, "alias"))).sendKeys(alias);
        log.info("Click on state dropdown");
        driver.findElement(By.xpath(String.format(DROPDOWN_STATE, "State"))).click();
        log.info("Choose state 'Alabama'");
        driver.findElement(By.xpath(String.format(STATE_XPATH, "Alabama"))).click();
        driver.findElement(REGISTER_BUTTON).click();
    }

    public String getAccountCreatedConfirmation(){
        String accountCreatedMessage = driver.findElement(By.xpath(NEW_ACCOUNT_CREATED_TEXT)).getText();
        return accountCreatedMessage;
    }
}
