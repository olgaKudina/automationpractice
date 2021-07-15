package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        homeSteps.openHomePageAndLogin(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        Assert.assertTrue(myAccountPage.isMyAccountNavigatePageDisplayed());
    }

    @Test
    public void logoutTest() {
        homeSteps.openHomePageAndLogin(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        headerPage.logout();
        Assert.assertTrue(myAccountPage.isAuthenticationNavigatePageDisplayed());
    }

    @Test
    public void loginWithIncorrectPasswordTest() {
        loginPage.loginIncorrectPassword(System.getenv().getOrDefault("email", PropertyReader.getProperty("email")), System.getenv().getOrDefault("incorrectPassword", PropertyReader.getProperty("incorrectPassword")));
        Assert.assertEquals(loginPage.getWarningIncorrectPassword(), "There is 1 error\n" +
                "Invalid password.");
    }
}
