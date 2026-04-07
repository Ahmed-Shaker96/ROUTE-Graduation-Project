package Tests;

import Base.BaseTest;
import Pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;

import java.time.Duration;

public class OpenRegistrationTest extends BaseTest {
    @Test(priority = 3)
    @Description("Test Case #3: Open registration page")

    public void openRegistrationPage() {
        HomePage home = new HomePage(driver);
        home.clickJoinUs();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/register"));
        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("/register"),
                "URL does not contain /register");
        System.out.println("Test Case #3 PASSED: Registration page opened successfully with URL: " + currentUrl);
    }
}
