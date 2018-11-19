package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import util.Wait;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class InitDriver {
    private final static int IMPLICIT_WAIT = 10;
    protected Wait wait;
    protected static WebDriver driver;
    private Map<String, Object> prefs = new HashMap<String, Object>();
    private ChromeOptions options = new ChromeOptions();

    protected void initDriver() {
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    protected void initWait() {
        this.wait = new Wait(driver);
    }

    protected void closeDriver() {
        this.driver.quit();
    }

}

