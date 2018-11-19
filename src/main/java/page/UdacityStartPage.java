package page;

import config.InitDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Wait;

public class UdacityStartPage extends InitDriver {
    public UdacityStartPage() {
        wait = new Wait(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[@title='Sign In'])[2]")
    public WebElement signInButton;


    @Step("Get url")
    public UdacityStartPage navigateTo(String url) {
        driver.get(url);
        return this;

    }
    @Step("Step to Start page")
    public UdacityLoginPage signIn() {
        wait.elementIsClickable(signInButton);
        signInButton.click();

        return new UdacityLoginPage();
    }

}
