package config;

import org.testng.Assert;
import org.testng.annotations.*;
import page.UdacityHomePage;
import page.UdacityLoginPage;
import page.UdacityStartPage;
import util.Wait;

public class BaseTest extends InitDriver {


    @BeforeTest(alwaysRun = true, description = "Setup driver")
    public void start() {
        initDriver();
        initWait();
    }


    @AfterTest(alwaysRun = true, description = "Close Driver")
    public void quit() {
        closeDriver();


    }

}