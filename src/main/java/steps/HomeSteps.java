package steps;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

public class HomeSteps {
    private LoginPage loginPage;
    private HomePage homePage;

    public HomeSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    public HomeSteps openHomePageAndLogin(String email, String password) {
        homePage.openPage();
        loginPage.login(System.getProperty("email", email), System.getProperty("password", password));
        return this;
    }

    public HomeSteps openHomePageLoginAndReturnToHomePage(String email, String password) {
        homePage.openPage();
        loginPage.login(System.getProperty("email", email), System.getProperty("password", password));
        homePage.openPage();
        return this;
    }
}
