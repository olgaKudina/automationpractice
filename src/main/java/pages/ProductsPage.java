package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class ProductsPage extends BasePage {
    public static final By SEARCH_XPATH = By.xpath("//*[contains(@class,'search_query')]");
    public static final By SEARCH_BUTTON = By.xpath("//*[contains(@name,'submit_search')]");
    public static final By SEARCH_RESULT = By.xpath("//*[contains(text(),'result has been found')]");
    public static final String PRODUCT_XPATH = "//a[contains(text(),'%s')]";
    public static final String MORE_DETAILS_BUTTON = "//a[contains(text(),'%s')]/ancestor::*[contains(@class,'product-container')]//span[contains(text(),'More')]";
    public static final String ADD_TO_CART_BUTTON = "//a[contains(text(),'Faded Short Sleeve T-shirts')]/ancestor::*[contains(@class,'product-container')]//span[contains(text(),'Add to cart')]";
    public static final By CONFIRMATION_ADD_TO_CART_BUTTON = By.xpath("//*[contains(text(),'Proceed to checkout')]");
    public static final By CONFIRMATION_SUMMARY_BUTTON = By.xpath("//*[contains(@class,'standard-checkout')]");
    public static final By CONFIRM_LOGIN_INFO_BUTTON = By.xpath("//*[contains(@name,'processAddress')]");
    public static final By CHECKBOX = By.xpath(" //*[@id='uniform-cgv']");
    public static final By CONFIRM_AGREEMENT_BUTTON = By.xpath("//*[contains(@name,'processCarrier')]");
    public static final By PAYMENT_MODULE_BUTTON = By.xpath("//*[@class='payment_module']");
    public static final By CONFIRM_MY_MODULE_BUTTON = By.xpath("//*[@id='cart_navigation']/button");
    public static final By CONFIRMATION_TEXT = By.xpath("//*[contains(text(),'Your order on My Store is complete.')]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultPage search() {
        driver.findElement(SEARCH_XPATH).sendKeys("Blouse");
        driver.findElement(SEARCH_BUTTON).click();
        return new SearchResultPage(driver);
    }

    public boolean getSearchResult() {
        return driver.findElement(SEARCH_RESULT).isDisplayed();
    }

    public ProductDetailsPage goFromProductsPageToProductDetailsPage(String productName) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(PRODUCT_XPATH, productName)))).build().perform();
        //action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]"))).build().perform();
        driver.findElement(By.xpath(String.format(MORE_DETAILS_BUTTON, productName))).click();
        return new ProductDetailsPage(driver);
    }

    public String purchaseProduct(String productName) {
       Actions action = new Actions(driver);
       action.moveToElement(driver.findElement(By.xpath(String.format(PRODUCT_XPATH, productName)))).build().perform();
    //add to cart
        driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON))).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //confirmation add to cart
        driver.findElement(CONFIRMATION_ADD_TO_CART_BUTTON).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //confirmation summary
        driver.findElement(CONFIRMATION_SUMMARY_BUTTON).isDisplayed();
        driver.findElement(CONFIRMATION_SUMMARY_BUTTON).click();
    //login, need to do steps
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("tms_qa05_6+1@mailinator.com");
        driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@id='SubmitLogin']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //confirm login
        driver.findElement(CONFIRM_LOGIN_INFO_BUTTON).isDisplayed();
        driver.findElement(CONFIRM_LOGIN_INFO_BUTTON).click();
    //checkbox
        driver.findElement(CHECKBOX).click();
       driver.findElement(CONFIRM_AGREEMENT_BUTTON).click();
    //payment module
       driver.findElement(PAYMENT_MODULE_BUTTON).click();
    //i confirm my order
        driver.findElement(CONFIRM_MY_MODULE_BUTTON).click();
        String confirmationText = driver.findElement(CONFIRMATION_TEXT).getText();
        return confirmationText;
    }
}


