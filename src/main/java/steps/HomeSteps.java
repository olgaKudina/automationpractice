package steps;

import org.openqa.selenium.WebDriver;
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPage;

public class HomeSteps {
    private LoginPage loginPage;
    private HomePage homePage;
    private HeaderPage headerPage;

    public HomeSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        headerPage = new HeaderPage(driver);
        homePage = new HomePage(driver);
    }

    public HomeSteps openHomePageAndLogin(String email, String password) {
        homePage.openPage();
        headerPage.clickSigninButton();
        loginPage.login(System.getProperty("email", email), System.getProperty("password", password));
        return this;
    }

    public HomeSteps openHomePageLoginAndReturnToHomePage(String email, String password) {
        homePage.openPage();
        headerPage.clickSigninButton();
        loginPage.login(System.getProperty("email", email), System.getProperty("password", password));
        homePage.openPage();
        return this;
    }
}
