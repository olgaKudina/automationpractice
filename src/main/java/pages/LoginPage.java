package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    public static final String BASE_URL = "http://automationpractice.com/";
    public static final String LOGIN_EMAIL = "tms_qa05_6+1@mailinator.com";
    public static final String LOGIN_PASSWORD = "12345";
    public static final By SIGNUP_BUTTON_XPATH = By.xpath("//*[@class='login']");
    public static final By LOGIN_EMAIL_XPATH = By.xpath("//*[@id='email']");
    public static final By LOGIN_PASSWORD_XPATH = By.xpath("//*[@id='passwd']");
    public static final By SUBMIT_LOGIN_BUTTON = By.xpath("//*[@id='SubmitLogin']");
    public static final By LOGOUT_BUTTON = By.xpath("//*[@class='logout']");
    public static final By LOGIN_WARNING = By.xpath("//*[@class='alert alert-danger']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public MyAccountPage login(){
        driver.get(BASE_URL);
        driver.findElement(SIGNUP_BUTTON_XPATH).click();
        WebDriverWait wait = new WebDriverWait(driver, 1);
        driver.findElement(LOGIN_EMAIL_XPATH).sendKeys(LOGIN_EMAIL);
        driver.findElement(LOGIN_PASSWORD_XPATH).sendKeys(LOGIN_PASSWORD);
        driver.findElement(SUBMIT_LOGIN_BUTTON).click();
        return new MyAccountPage(driver);
    }

    public ProductsPage logout(){
        driver.findElement(LOGOUT_BUTTON).click();
        return new ProductsPage(driver);
    }

    public void loginIncorrectPassword(String password){
        driver.get(BASE_URL);
        driver.findElement(SIGNUP_BUTTON_XPATH).click();
        driver.findElement(LOGIN_EMAIL_XPATH).sendKeys(LOGIN_EMAIL);
        driver.findElement(LOGIN_PASSWORD_XPATH).sendKeys(password);
        driver.findElement(SUBMIT_LOGIN_BUTTON).click();
    }
    public String getWarningIncorrectPassword(){
        return driver.findElement(LOGIN_WARNING).getText();
    }
}

