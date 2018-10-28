package config;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest extends InitDriver {
    @BeforeTest
    public void start(){
        super.initDriver();
        super.initWait();
    }

    @AfterTest
    public void quit (){
        super.closeDriver();
    }

}
