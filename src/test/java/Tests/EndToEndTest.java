package Tests;

import Base.BaseTest;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;

public class EndToEndTest extends BaseTest {

    @Test(priority = 7)
    @Description("Test Case #7: end-to-end scenario")

    public void endToEndScenario() {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.enterCredentials();
        login.clickLogin();

        home.openAllCourses();
        CoursesPage courses = new CoursesPage(driver);
        courses.selectCourse();

        CourseDetailsPage courseDetails = new CourseDetailsPage(driver);
        courseDetails.clickSubscribe();

        CartPage cart = new CartPage(driver);

        Assert.assertTrue(cart.isCourseInCart(),"Selected course is not found in the cart!");
        System.out.println("Test Case #7 PASSED: End-to-End flow completed successfully.");
    }
}