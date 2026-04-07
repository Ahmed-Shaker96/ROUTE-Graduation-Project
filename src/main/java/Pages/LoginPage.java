package Pages;

import Utils.DataDriven;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    private By emailInput = By.xpath("//input[@id='email']");
    private By passwordInput = By.xpath("//input[@id='password']");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By errorMessage = By.cssSelector("body > main:nth-child(4) > section:nth-child(2) > form:nth-child(5) > p:nth-child(5)");
    private By emptyemail = By.cssSelector("body > main:nth-child(4) > section:nth-child(2) > form:nth-child(5) > div:nth-child(1) > p:nth-child(3)");
    private By emptypassword = By.cssSelector("body > main:nth-child(4) > section:nth-child(2) > form:nth-child(5) > div:nth-child(2) > p:nth-child(3)");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Entering Valid Email ,and Password to Login ")
    public void enterCredentials (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(DataDriven.jsonReader("ValidEmail"));
        driver.findElement(passwordInput).sendKeys(DataDriven.jsonReader("ValidPassword"));
    }

    @Step("Entering Invalid Email ,and Password to Check the Error")
    public void invalidCredentials (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(DataDriven.jsonReader("InvalidEmail"));
        driver.findElement(passwordInput).sendKeys(DataDriven.jsonReader("InvalidPassword"));
    }

    @Step("Clicking on Login Button")
    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
    }

    @Step("Checking the Displaying of the Error Message")
    public boolean isErrorMessageVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return error.isDisplayed();
    }

    @Step("Checking the Displaying of the Empty Fields Message")
    public boolean areEmptyMessagesVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailError = wait.until(ExpectedConditions.visibilityOfElementLocated(emptyemail));
        WebElement passError = wait.until(ExpectedConditions.visibilityOfElementLocated(emptypassword));
        return emailError.isDisplayed() && passError.isDisplayed();
    }

}

