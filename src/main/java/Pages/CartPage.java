package Pages;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;

    private By subscribedCourse = By.xpath("//a[contains(text(),'إدارة سلسلة الإمدادات')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step ("Checking that User Cart contain The Selected Course")
    public boolean isCourseInCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement course = wait.until(ExpectedConditions.visibilityOfElementLocated(subscribedCourse));
        return course.isDisplayed();
    }

}
