package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.SignupPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;

public class RegWithoutUsernameTest extends BaseTest {

    @Test(priority = 4)
    @Description("Test Case #4: Register with an empty username field")

    public void registerWithEmptyUsername() {
        HomePage home = new HomePage(driver);
        home.clickJoinUs();
        SignupPage signup = new SignupPage(driver);
        signup.fillFormWithoutUsername();
        signup.submit();

        Assert.assertTrue(signup.isUsernameErrorVisible(),
                "Validation error message for empty username is not displayed!");
        System.out.println("Test Case #4 PASSED: Validation error 'اسم المستخدم مطلوب' displayed when username field left empty.");
    }
}
