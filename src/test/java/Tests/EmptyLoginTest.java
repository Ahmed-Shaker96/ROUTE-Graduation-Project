package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;

public class EmptyLoginTest extends BaseTest {

    @Test(priority = 6)
    @Description("Test Case #6: Login with empty fields ")

    public void loginWithEmptyFields() {
        HomePage home = new HomePage(driver);
        home.clickLogin();
        LoginPage login = new LoginPage(driver);
        login.clickLogin();

        Assert.assertTrue(login.areEmptyMessagesVisible(),
                "Error message for empty fields is not displayed!");
        System.out.println("Test Case #6 PASSED: Error message displayed when logging with empty credentials.");
    }
}
