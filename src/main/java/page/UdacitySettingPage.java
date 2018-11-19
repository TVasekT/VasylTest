package page;

import config.InitDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UdacitySettingPage extends InitDriver {
    public UdacitySettingPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement fieldFirstName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement fieldLastName;
    @FindBy(xpath = "//input[@placeholder='Email Address']")
    private WebElement fieldEmailAdress;

    public WebElement assertLastName() {
        fieldLastName.isDisplayed();
        return fieldLastName;



}
    public WebElement assertFirstName(){

         fieldFirstName.isDisplayed();
         return fieldFirstName;


    }

    public WebElement assertEmailAdress() {
        fieldEmailAdress.isDisplayed();
        return fieldEmailAdress;

    }
}





