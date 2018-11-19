package page;

import config.InitDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Wait;

public class UdacityHomePage extends InitDriver {

    public UdacityHomePage() {
        PageFactory.initElements(driver, this);
        wait = new Wait(driver);
    }

    @FindBy(xpath = "//span[@title=\"Logout\"]")
    private WebElement logoutButton;
    @FindBy(xpath = "(//span[@class='_nav--nav-link--1xAta'])[3]")
    private WebElement settingButton;

    public boolean assertLogoutButtonIsDispl(){
        wait.elementIsClickable(logoutButton);
        return logoutButton.isDisplayed();
    }


    public UdacitySettingPage settingButtonIsClick(){
        wait.elementIsClickable(settingButton);
        settingButton.click();

        return new UdacitySettingPage();

    }

}








