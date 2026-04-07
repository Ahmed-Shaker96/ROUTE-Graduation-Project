package Tests;

import Base.BaseTest;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;

import java.util.ArrayList;

public class TwitterTest extends BaseTest {

    @Test(priority = 10)
    @Description("Test Case #8: Verify Twitter link")

    public void verifyTwitterLink() {
        HomePage home = new HomePage(driver);
        home.scrollToFooter(home.TwitterIcon);
        home.clickTwitterIcon();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("x.com"), "Twitter link did not open correctly!");
        System.out.println("Test Case #10 PASSED: Twitter link verified successfully.");
    }
}
