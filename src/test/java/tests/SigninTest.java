package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SigninTest extends BaseTest{

    @Test
    public void signinTest(){
        homePage.openPage();
        loginPage.enterEmailAddressToCreateNewAccount();
        createAccountPage.fillInAccountForm("Olga", "Book", "12345678", "Park lane", "Minsk", "1234567891", "56700", "TBD");
        Assert.assertEquals(createAccountPage.getAccountCreatedConfirmation(), "Welcome to your account. Here you can manage all of your personal information and orders.");
    }
}