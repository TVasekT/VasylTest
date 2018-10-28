package util.Listener;

import config.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        saveScreenshot(result);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(ITestResult result) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
