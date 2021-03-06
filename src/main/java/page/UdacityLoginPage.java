package page;

import config.InitDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Wait;

public class UdacityLoginPage extends InitDriver {

    public UdacityLoginPage() {
        wait = new Wait(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(@class, \"index--primary\")]" )
    private WebElement signInButton;

    @Step("Login step to Udacity")

    public UdacityHomePage loginPage(String login, String password){

        wait.elementIsClickable(signInButton);
        emailField.clear();
        emailField.sendKeys(login);
        passwordField.clear();
        passwordField.sendKeys(password);
        signInButton.click();
        return new UdacityHomePage();

    }

}
