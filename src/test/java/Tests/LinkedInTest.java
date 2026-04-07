package Tests;

import Base.BaseTest;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;

import java.util.ArrayList;

public class LinkedInTest extends BaseTest {

    @Test(priority = 9)
    @Description("Test Case #8: Verify linkedin link")

    public void verifyLinkedInLink() {
        HomePage home = new HomePage(driver);
        home.scrollToFooter(home.LinkedInIcon);
        home.clickLinkedInIcon();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("linkedin.com"), "LinkedIn link did not open correctly!");
        System.out.println("Test Case #9 PASSED: LinkedIn link verified successfully.");
    }
}
