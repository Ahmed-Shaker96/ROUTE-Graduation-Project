package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    private By searchInput = By.cssSelector("input[placeholder='بحث عن الدورات التدريبية']");
    private By suggestion = By.cssSelector("a[class='hover:bg-primary-base flex w-full items-center gap-3 p-3 transition-colors']");
    private By allCoursesLink = By.cssSelector("a[class='font-light']");
    private By joinUsButton = By.xpath("//a[contains(text(),'حساب جديد')]");
    private By loginButton = By.xpath("//a[contains(text(),'تسجيل الدخول')]");
    public By FaceBookIcon = By.xpath("//*[name()='path' and contains(@d,'M26.0063 1')]");
    public By LinkedInIcon = By.xpath("//a[@href='https://eg.linkedin.com/company/eyouth']//*[name()='svg']");
    public By TwitterIcon = By.xpath("//*[name()='path' and contains(@d,'M26.4534 7')]");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Try to Write Keyword in Search Field")
    public void typeSearchKeyword(String keyword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        input.clear();
        input.sendKeys(keyword);
    }

    @Step("Select the suggestion that is displayed in Dropdown")
    public void selectSuggestion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement suggestionElement = wait.until(ExpectedConditions.elementToBeClickable(suggestion));
        suggestionElement.click();

    }

    @Step("Navigation to ALL courses Page")
    public void openAllCourses() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(allCoursesLink));
        link.click();
    }

    @Step("Navigation to SignUp Page")
    public void clickJoinUs() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement joinUs = wait.until(ExpectedConditions.elementToBeClickable(joinUsButton));
        joinUs.click();
    }

    @Step("Navigation to Login Page")
    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
    }

    @Step("Scrolling to Page Footer to Click on Social Media Icons")
    public void scrollToFooter(By socialIconLocator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(socialIconLocator));

        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", icon);

        js.executeScript("window.scrollBy(0, 100);");
    }

    @Step("Opening Facebook Website")
    public void clickFacebookIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fbLink = wait.until(ExpectedConditions.elementToBeClickable(FaceBookIcon));

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        try {
            fbLink.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new MouseEvent('click', {bubbles:true}));", fbLink);
        }
    }

    @Step("Opening LinkedIn Website")
    public void clickLinkedInIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement LnLink = wait.until(ExpectedConditions.elementToBeClickable(LinkedInIcon));

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        try {
            LnLink.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new MouseEvent('click', {bubbles:true}));", LnLink);
        }
    }

    @Step("Opening Twitter Website")
    public void clickTwitterIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement TwitterLink = wait.until(ExpectedConditions.elementToBeClickable(TwitterIcon));

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        try {
            TwitterLink.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new MouseEvent('click', {bubbles:true}));", TwitterLink);
        }
    }
}

