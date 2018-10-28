import config.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.reporters.DotTestListener;
import page.UdacityStartPage;

@Listeners({DotTestListener.class})
@Epic("Test")
@Feature("Login Test")

public class TestLogin extends BaseTest {
    @Severity(SeverityLevel.NORMAL)
    @Description("Login to Udacity")
    @Test
    public void testLogin(){
        UdacityStartPage loginPage = new UdacityStartPage();

        loginPage
                .navigateTo("https://www.udacity.com/")
                .signIn()
                .loginPage("testmailforus9@gmail.com","trash1010" )
                .checkLogin();




    }
}
