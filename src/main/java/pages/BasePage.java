package pages;

import helpers.PageFactory;
import hooks.AppManagement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage extends PageFactory {

    AppiumDriver<MobileElement> driver = PageFactory.getDriver();
    private final Logger LOG = LoggerFactory.getLogger(AppManagement.class);


    public void waitCondition(MobileElement ae) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOf(ae));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public void waitTillProgressIconIsDisabled(MobileElement mobileElement, int timeInSecondsToWait) {
        for (int counter = 0; counter < timeInSecondsToWait; counter++) {
            try {
                WebDriverWait wait = new WebDriverWait(this.driver, 1);
                wait.until(ExpectedConditions.visibilityOf(mobileElement));
            } catch (Exception e) {
                break;
            }
        }
    }
}
