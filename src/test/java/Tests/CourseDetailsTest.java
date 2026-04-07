package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.CoursesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;

public class CourseDetailsTest extends BaseTest {
    @Test(priority = 2)
    @Description("Test Case #2: Open course details")

    public void openCourseDetails() {
        HomePage home = new HomePage(driver);
        home.openAllCourses();

        CoursesPage courses = new CoursesPage(driver);
        courses.openThirdCourse();

        Assert.assertTrue(courses.isCourseDetailsVisible(),
                "Course details section is not displayed!");
        System.out.println("Test Case #2 PASSED: Course details page opened and 'حول الدورة التدريبية' section is displayed.");
    }
}
