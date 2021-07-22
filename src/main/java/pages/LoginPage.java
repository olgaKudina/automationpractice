package pages;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.EmailGenerator;

@Log4j2
public class LoginPage extends HeaderPage{

    public static final By LOGIN_EMAIL_XPATH = By.xpath("//*[@id='email']");
    public static final By LOGIN_PASSWORD_XPATH = By.xpath("//*[@id='passwd']");
    public static final By SUBMIT_LOGIN_BUTTON = By.xpath("//*[@id='SubmitLogin']");
    public static final By LOGIN_WARNING = By.xpath("//*[contains(@class,'alert-danger')]");
    public static final By EMAIL_ADDRESS_SIGNIN_XPATH = By.xpath("//*[@id='email_create']");
    public static final By CREATE_ACCOUNT_BUTTON = By.xpath("//*[@id='SubmitCreate']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Login with {email} email and {password} password")
    public MyAccountPage login(String email, String password){
        log.info(String.format("Fill in username: '%s' in Login field.", email));
        driver.findElement(LOGIN_EMAIL_XPATH).sendKeys(email);
        log.info(String.format("Fill in password: '%s' in Login field.", password));
        driver.findElement(LOGIN_PASSWORD_XPATH).sendKeys(password);
        log.info("Click Submit Login button");
        driver.findElement(SUBMIT_LOGIN_BUTTON).click();
        return new MyAccountPage(driver);
    }

    @Step("Get warning message is displayed if Password is incorrect")
    public String getWarningIncorrectPassword(){
        return driver.findElement(LOGIN_WARNING).getText();
    }

    @Step("Enter email address to create new account and click Submit button")
    public CreateAccountPage enterEmailAddressToCreateNewAccount(){
        String randomEmail = EmailGenerator.getSaltString();
        log.info("Enter random email", randomEmail + "@mail.net");
        driver.findElement(EMAIL_ADDRESS_SIGNIN_XPATH).sendKeys(randomEmail + "@mail.net");
        log.info("Click 'Create an account' button");
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
        return new CreateAccountPage(driver);
    }
}

