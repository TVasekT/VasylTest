package util;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    private final static int WAIT_TIME = 10;
    private WebDriver driver;

    public Wait(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait createWait(long timeout) {
        return new WebDriverWait(driver, timeout);
    }

    public void wait(ExpectedCondition<?> condition, int waitTime) {
        this.createWait(waitTime)
                .pollingEvery(Duration.ofMillis(7000))
                .ignoring(StaleElementReferenceException.class)
                .until(condition);
    }

    public void clickableThenClick(WebElement element) {
        wait(ExpectedConditions.elementToBeClickable(element), WAIT_TIME);
        element.click();
    }

    public void visible(WebElement element, int waitTime) {
        wait(ExpectedConditions.visibilityOf(element), waitTime);
    }

    public void visible(WebElement element) {
        visible(element, WAIT_TIME);
    }

    public boolean isPresent(WebElement element) {
        try {
            visible(element, WAIT_TIME);
            return true;
        } catch (Exception ignored) {
        }
        return false;
    }

}



