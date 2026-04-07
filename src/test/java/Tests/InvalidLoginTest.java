package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;

public class InvalidLoginTest extends BaseTest {

    @Test(priority = 5)
    @Description("Test Case #5: Login with invalid credentials ")

    public void loginWithInvalidCredentials() {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.invalidCredentials();
        login.clickLogin();

        Assert.assertTrue(login.isErrorMessageVisible(),
                "Error message for invalid credentials is not displayed!");
        System.out.println("Test Case #5 PASSED: Error message displayed when logging in with invalid credentials.");
    }
}
