import config.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.reporters.DotTestListener;
import page.UdacityHomePage;
import page.UdacitySettingPage;
import page.UdacityStartPage;

@Listeners({DotTestListener.class})
@Epic("Test")
@Feature("Login Test")

public class RunTest extends BaseTest {


    @Severity(SeverityLevel.CRITICAL)
    @Description("Login to Udacity")
    @Test
    public void testLogin() {
        UdacityStartPage login = new UdacityStartPage();
        UdacityHomePage udacityHomePage = new UdacityHomePage();
        login
                .navigateTo("https://www.udacity.com/")
                .signIn()
                .loginPage("testmailforus9@gmail.com", "trash1010");

        Assert.assertTrue(udacityHomePage.assertLogoutButtonIsDispl());
        udacityHomePage
                .settingButtonIsClick();

    }

    @Severity(SeverityLevel.NORMAL)
    @Description("test to User information")
    @Test(dependsOnMethods = "testLogin")
    public void testEmail() {
        UdacitySettingPage udacitySettingPage = new UdacitySettingPage();
        UdacitySettingPage emailField = new UdacitySettingPage();
        emailField
                .assertEmailAdress();
        Assert.assertEquals(udacitySettingPage.assertEmailAdress().getAttribute("value"), "testmailforus9@gmail.com");
        Assert.assertEquals(udacitySettingPage.assertLastName().getAttribute("value"), "Lebowski");
        Assert.assertEquals(udacitySettingPage.assertFirstName().getAttribute("value"), "Mike");

    }

}