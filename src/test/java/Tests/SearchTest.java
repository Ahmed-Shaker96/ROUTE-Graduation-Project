package Tests;

import Base.BaseTest;
import Pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;

import java.time.Duration;

public class SearchTest extends BaseTest {
    @Test(priority = 1)
    @Description("Test Case #1: Search with a valid keyword")

    public void searchWithValidKeyword() {
        HomePage home = new HomePage(driver);
        home.typeSearchKeyword("كيف تنضم الي البنك");
        home.selectSuggestion();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.titleContains("كيف تنضم إلى البنك؟"));
        String pageTitle = driver.getTitle();

        Assert.assertTrue(pageTitle.contains("كيف تنضم إلى البنك؟"),
                "Page title does not contain the search keyword!");
        System.out.println("Test Case #1 PASSED: Search with valid keyword opened page with title: " + pageTitle);
    }
}
