package Pages;

import Utils.DataDriven;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {
    private WebDriver driver;

    private By emailInput = By.xpath("//input[@id='email']");
    private By passwordInput = By.xpath("//input[@id='password']");
    private By confirmPasswordInput = By.xpath("//input[@id='confirm_password']");
    private By createButton = By.cssSelector("button[type='submit']");
    private By usernameError = By.cssSelector("body > main:nth-child(4) > section:nth-child(2) > form:nth-child(5) > div:nth-child(1) > p:nth-child(3)");

    public SignupPage(WebDriver driver) {

        this.driver = driver;
    }

    @Step("Entering Registration Data without Username")
    public void fillFormWithoutUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(DataDriven.jsonReader("RandomEmail"));
        driver.findElement(passwordInput).sendKeys(DataDriven.jsonReader("RandomPassword"));
        driver.findElement(confirmPasswordInput).sendKeys(DataDriven.jsonReader("RandomPassword"));
    }

    @Step("Clicking on Submit Button to SignUp")
    public void submit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement createBtnElement = wait.until(
                ExpectedConditions.elementToBeClickable(createButton)
        );

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createBtnElement);

        try {
            createBtnElement.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", createBtnElement);
        }
    }
    @Step("Checking the Displaying of the Error Message for Username")
    public boolean isUsernameErrorVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameError)).isDisplayed();
    }
}

