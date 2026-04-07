package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CoursesPage {
    private WebDriver driver;

    public By FirstCourseCard = By.cssSelector("body > div:nth-child(4) > main:nth-child(2) > div:nth-child(1) > section:nth-child(3) > div:nth-child(1)");
    private By FirstCourseImage = By.cssSelector("img[alt='تحليل البيانات عبر Power BI']");
    private By FirstCourseTitle = By.cssSelector("body > div:nth-child(4) > main:nth-child(2) > div:nth-child(1) > section:nth-child(3) > div:nth-child(1) > a:nth-child(1) > h3:nth-child(2)");
    private By FirstInstructorName = By.cssSelector("body > div:nth-child(4) > main:nth-child(2) > div:nth-child(1) > section:nth-child(3) > div:nth-child(1) > h6:nth-child(3)");
    private By FirstSubscribeButton = By.cssSelector("body > div:nth-child(4) > main:nth-child(2) > div:nth-child(1) > section:nth-child(3) > div:nth-child(1) > div:nth-child(5) > button:nth-child(1)");
    private By SecondCourseCard = By.cssSelector("body > div:nth-child(4) > main:nth-child(2) > div:nth-child(1) > section:nth-child(3) > div:nth-child(2) > a:nth-child(1) > h3:nth-child(2)");
    private By ThirdCourseCard = By.cssSelector("body > div:nth-child(4) > main:nth-child(2) > div:nth-child(1) > section:nth-child(3) > div:nth-child(3) > a:nth-child(1) > h3:nth-child(2)");
    private By CourseDetailsSection = By.xpath("//h3[contains(text(),'نظرة عامة')]");

    public CoursesPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Select Specific Course to more Details")
    public void openThirdCourse() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.titleContains("جميع الدورات"));
        WebElement card = wait.until(ExpectedConditions.elementToBeClickable(ThirdCourseCard));
        card.click();
    }

    @Step("Checking that Selected Course Details Open")
    public boolean isCourseDetailsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement section = wait.until(ExpectedConditions.presenceOfElementLocated(CourseDetailsSection));
        return section.isDisplayed();
    }

    @Step("Hide the Opened Menu to Click on Target Card")
    public void hideTopMenu() {
        Actions actions = new Actions(driver);
        WebElement body = driver.findElement(By.cssSelector("body > div:nth-child(4) > nav:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(2) > svg:nth-child(1)"));
        actions.moveToElement(body).perform();
    }

    @Step("Select Specific Course to Subscribe")
    public void selectCourse() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement course = wait.until(ExpectedConditions.elementToBeClickable(SecondCourseCard));
        hideTopMenu();
        course.click();
    }

    @Step("Checking that Course Card Contain 4 Items")
    public boolean isFirstCourseCardComplete() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement card = wait.until(ExpectedConditions.presenceOfElementLocated(FirstCourseCard));

        boolean image = false, title = false, instructor = false, subscribe = false;

        try {
            image = card.findElement(FirstCourseImage) != null;
            System.out.println("Image displayed: " + image);
        } catch (Exception e) {
            System.out.println("Image missing");
        }

        try {
            title = card.findElement(FirstCourseTitle) != null;
            System.out.println("Title displayed: " + title);
        } catch (Exception e) {
            System.out.println("Title missing");
        }

        try {
            instructor = card.findElement(FirstInstructorName) != null;
            System.out.println("Instructor displayed: " + instructor);
        } catch (Exception e) {
            System.out.println("Instructor missing");
        }

        try {
            subscribe = card.findElement(FirstSubscribeButton) != null;
            System.out.println("Subscribe displayed: " + subscribe);
        } catch (Exception e) {
            System.out.println("Subscribe button missing");
        }

        return image && title && instructor && subscribe;
    }


}


