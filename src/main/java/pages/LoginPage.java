package pages;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.EmailGenerator;
import utils.WaitForElement;

@Log4j2
public class LoginPage extends HeaderPage{

    public static final By SIGNUP_BUTTON_XPATH = By.xpath("//*[@class='login']");
    public static final By LOGIN_EMAIL_XPATH = By.xpath("//*[@id='email']");
    public static final By LOGIN_PASSWORD_XPATH = By.xpath("//*[@id='passwd']");
    public static final By SUBMIT_LOGIN_BUTTON = By.xpath("//*[@id='SubmitLogin']");
    public static final By LOGIN_WARNING = By.xpath("//*[@class='alert alert-danger']");
    public static final By EMAIL_ADDRESS_SIGNIN_XPATH = By.xpath("//*[@id='email_create']");
    public static final By CREATE_ACCOUNT_BUTTON = By.xpath("//*[@id='SubmitCreate']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Login with {email} and {password}")
    public MyAccountPage login(String email, String password){
        driver.findElement(SIGNUP_BUTTON_XPATH).click();
        log.info(String.format("Fill in username: '%s' in Login field.", email));
        driver.findElement(LOGIN_EMAIL_XPATH).sendKeys(email);
        log.info(String.format("Fill in password: '%s' in Login field.", password));
        driver.findElement(LOGIN_PASSWORD_XPATH).sendKeys(password);
        driver.findElement(SUBMIT_LOGIN_BUTTON).click();
        return new MyAccountPage(driver);
    }

    @Step("Login with incorrect password {incorrectPassword}")
    public LoginPage loginIncorrectPassword(String email, String incorrectPassword){
        driver.get(BASE_URL);
        WaitForElement.waitForElementPresence(driver, SIGNUP_BUTTON_XPATH, 30);
        driver.findElement(SIGNUP_BUTTON_XPATH).click();
        WaitForElement.waitForElementPresence(driver, LOGIN_EMAIL_XPATH, 30);
        driver.findElement(LOGIN_EMAIL_XPATH).sendKeys(email);
        log.info(String.format("Fill in password: '%s' in Login field.", incorrectPassword));
        driver.findElement(LOGIN_PASSWORD_XPATH).sendKeys(incorrectPassword);
        driver.findElement(SUBMIT_LOGIN_BUTTON).click();
        return this;
    }

    @Step("Warning message is displayed if Password is incorrect")
    public String getWarningIncorrectPassword(){
        return driver.findElement(LOGIN_WARNING).getText();
    }

    @Step("Enter email address to create new account and click Submit button")
    public CreateAccountPage enterEmailAddressToCreateNewAccount(){
        driver.findElement(SIGNUP_BUTTON_XPATH).click();
        log.info("Enter random email", EmailGenerator.getSaltString() + "@mail.net");
        driver.findElement(EMAIL_ADDRESS_SIGNIN_XPATH).sendKeys(EmailGenerator.getSaltString() + "@mail.net");
        log.info("Click 'Create an account' button");
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
        return new CreateAccountPage(driver);
    }
}

