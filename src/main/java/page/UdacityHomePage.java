package page;

import config.InitDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import util.Wait;

public class UdacityHomePage extends InitDriver {
    private Wait wait;

    public UdacityHomePage() {
        this.wait = new Wait(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@title=\"Logout\"]")
    private WebElement logoutButton;

    public void checkLogin() {
        Assert.assertEquals(logoutButton.getText(), "Logout");
    }

}




