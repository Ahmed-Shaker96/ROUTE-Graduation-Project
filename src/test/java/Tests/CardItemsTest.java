package Tests;

import Base.BaseTest;
import Pages.CoursesPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;

public class CardItemsTest extends BaseTest {

    @Test(priority = 11)
    @Description("Test Case #11: Verify course cards UI")

    public void verifyCourseCardUI() {
        HomePage home = new HomePage(driver);
        home.openAllCourses();
        CoursesPage coursesPage = new CoursesPage(driver);
        coursesPage.hideTopMenu();

        Assert.assertTrue(coursesPage.isFirstCourseCardComplete(),
                "Course card does not contain all required elements!");
        System.out.println("Test Case #11 PASSED: Course card UI verified successfully.");

    }
}
