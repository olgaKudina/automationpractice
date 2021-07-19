package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.AddProductsToCartSteps;
import steps.HomeSteps;
import steps.PurchaseSteps;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    HomePage homePage;
    HeaderPage headerPage;
    SearchResultPage searchResultPage;
    ProductDetailsPage productDetailsPage;
    ProductAddedToCartModulePage productAddedToCartModulePage;
    ShoppingCartSummaryPage shoppingCartSummaryPage;
    AddressesPage addressesPage;
    ShippingPage shippingPage;
    PaymentMethodPage paymentMethodPage;
    OrderSummaryPage orderSummaryPage;
    OrderConfirmationPage orderConfirmationPage;
    HomeSteps homeSteps;
    AddProductsToCartSteps addProductsToCartSteps;
    PurchaseSteps purchaseSteps;
    CatalogPage catalogPage;
    CreateAccountPage createAccountPage;


    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        productAddedToCartModulePage = new ProductAddedToCartModulePage(driver);
        shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        addressesPage = new AddressesPage(driver);
        shippingPage = new ShippingPage(driver);
        paymentMethodPage = new PaymentMethodPage(driver);
        orderSummaryPage = new OrderSummaryPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
        homeSteps = new HomeSteps(driver);
        addProductsToCartSteps = new AddProductsToCartSteps(driver);
        purchaseSteps = new PurchaseSteps(driver);
        headerPage = new HeaderPage(driver);
        catalogPage = new CatalogPage(driver);
        createAccountPage = new CreateAccountPage(driver);

    }

//    @AfterMethod
//    public void endTest() {
//        driver.quit();
//    }
}
