package pages;

import hooks.AppManagement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedInLandingScreenPage {
    AppiumDriver<MobileElement> driver = helpers.PageFactory.getDriver();
    private final Logger LOG = LoggerFactory.getLogger(AppManagement.class);
    BasePage basePage;


    public LinkedInLandingScreenPage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.basePage = new BasePage();
    }

    @AndroidFindBy(id = "com.linkedin.android:id/growth_prereg_fragment_login_button")
    public MobileElement signInBtn;

    @AndroidFindBy(accessibility = "Page 3 of 3")
    public MobileElement page3Label;

    @AndroidFindBy(accessibility = "Page 2 of 3")
    public MobileElement page2Label;


    public boolean isDisplayedSignInBtn() {
        basePage.waitCondition(signInBtn);
        return signInBtn.isDisplayed();
    }
    
}
