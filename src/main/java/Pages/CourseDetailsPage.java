package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CourseDetailsPage {
    private WebDriver driver;

    private By subscribeButton = By.cssSelector("body > div:nth-child(4) > main:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(4) > button:nth-child(1)");

    public CourseDetailsPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Subscription of Specific Course")
    public void clickSubscribe() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement subscribeBtn = wait.until(ExpectedConditions.elementToBeClickable(subscribeButton));
        subscribeBtn.click();
    }
}
