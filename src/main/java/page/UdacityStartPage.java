package page;

import config.InitDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UdacityStartPage extends InitDriver {
    public UdacityStartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[@title='Sign In'])[2]")
    private WebElement signInButton;
    @FindBy(xpath = "//div[@class=\"modal-close\"]")
    private WebElement modalWindow;

    @Step("Get url")
    public UdacityStartPage navigateTo(String url) {
        driver.get(url);
        return this;

    }
    @Step("Step to Start page")
    public UdacityLoginPage signIn() {
        modalWindow.isDisplayed();
        modalWindow.click();
        wait.clickableThenClick(signInButton);
        signInButton.click();
        return new UdacityLoginPage();
    }
}
