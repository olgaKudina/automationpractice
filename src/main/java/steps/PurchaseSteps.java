package steps;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PurchaseSteps {
    WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private ProductAddedToCartModulePage productAddedToCartModulePage;
    private ShoppingCartSummaryPage shoppingCartSummaryPage;
    private ShippingPage shippingPage;
    private AddressesPage addressesPage;
    private PaymentMethodPage paymentMethodPage;
    private OrderSummaryPage orderSummaryPage;
    private OrderConfirmationPage orderConfirmationPage;

    public PurchaseSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productAddedToCartModulePage = new ProductAddedToCartModulePage(driver);
        shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        shippingPage = new ShippingPage(driver);
        addressesPage = new AddressesPage(driver);
        paymentMethodPage = new PaymentMethodPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
        orderSummaryPage = new OrderSummaryPage(driver);
    }

    public PurchaseSteps addProductToCartAndPurchaseIt(String productName) {
        homePage.addProductToCart(productName)
                .confirmProductAddedToCart()
                .confirmSummaryInfo()
                .confirmLoginInfo()
                .confirmAgreement()
                .choosePaymentMethod()
                .confirmOrderSummary()
                .finishPurchase();
        return this;
    }
}
