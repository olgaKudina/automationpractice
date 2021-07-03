package tests;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void loginTest(){
        loginPage.login();
        Assert.assertTrue(myAccountPage.getMyAccountNavigatePage());
    }

    @Test
    public void logoutTest(){
        loginPage.login();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        loginPage.logout();
        Assert.assertTrue(myAccountPage.getAuthenticationNavigatePage());
    }

    @Test
    public void loginWithoutTest(){
        loginPage.loginIncorrectPassword("123");
        Assert.assertEquals(loginPage.getWarningIncorrectPassword(), "There is 1 error\n" +
                "Invalid password.");
    }
}
