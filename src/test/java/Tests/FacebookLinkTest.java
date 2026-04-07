package Tests;

import Base.BaseTest;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;

import java.util.ArrayList;

public class FacebookLinkTest extends BaseTest {

    @Test(priority = 8)
    @Description("Test Case #8: Verify Facebook link")

    public void verifyFacebookLink() {
        HomePage home = new HomePage(driver);
        home.scrollToFooter(home.FaceBookIcon);
        home.clickFacebookIcon();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("facebook.com"), "Facebook link did not open correctly!");
        System.out.println("Test Case #8 PASSED: Facebook link verified successfully.");
    }
}
