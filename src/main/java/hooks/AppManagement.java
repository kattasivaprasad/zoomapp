package hooks;

import helpers.PropertyLoader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static helpers.PageFactory.setDriver;


public class AppManagement {
    private final Logger LOG = LoggerFactory.getLogger(AppManagement.class);
    public static AndroidDriver driver;
    AppiumDriverLocalService appiumService;
    String appiumServiceUrl;

    @Before
    public void prepareApp(Scenario scenario) throws Exception {
        LOG.info("preparing app to start the test");
        try {
            driver = getWebdriver();
        } catch (Exception e) {
            throw new Exception("Driver could not be initialised " + e.getMessage());

        }
    }

    @After
    public void closeApp() throws Exception {
        System.out.println("Stop driver");
        driver.quit();
        System.out.println("Stop appium service");
        appiumService.stop();
        LOG.info("closing app to end the test");
    }

    public static byte[] getScreenshot() throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(src);
        return fileContent;
    }

    private AndroidDriver getWebdriver() throws Exception {
        PropertyLoader propertyLoader = new PropertyLoader();
        AndroidDriver driver = getAndroidDriver();
        setDriver(driver);
        return driver;
    }

    private AndroidDriver getAndroidDriver() throws Exception {
        appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
        appiumServiceUrl = appiumService.getUrl().toString();
        System.out.println("Appium Service Address : - " + appiumServiceUrl);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        File appDir = new File(System.getProperty("user.dir") + "/src/test/resources/");
        File app = new File(appDir, PropertyLoader.getProperty("APP_NAME"));
        capabilities.setCapability("udid", PropertyLoader.getProperty("DEVICE_ID"));
        capabilities.setCapability("deviceName", PropertyLoader.getProperty("DEVICE_NAME"));
        capabilities.setCapability("platformName", PropertyLoader.getProperty("PLATFORM"));
        capabilities.setCapability("platformVersion", PropertyLoader.getProperty("PLATFORM_VERSION"));
        capabilities.setCapability("fullReset", true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("automationName", PropertyLoader.getProperty("AUTOMATION_NAME"));
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver<>(new URL(appiumServiceUrl), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if (driver.findElement(By.id("android:id/button1")).isDisplayed()) {
            driver.findElement(By.id("android:id/button1")).click();
        }
        return driver;
    }
}

