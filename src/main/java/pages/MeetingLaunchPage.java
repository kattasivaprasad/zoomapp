package pages;

import hooks.AppManagement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MeetingLaunchPage {

    private final Logger LOG = LoggerFactory.getLogger(AppManagement.class);
    BasePage basePage;

    public MeetingLaunchPage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.basePage = new BasePage();
    }

    @AndroidFindBy(id = "us.zoom.videomeetings:id/btnJoinConf")
    public MobileElement joinAMeetingBtn;

    public Boolean isDisplayedJoinaMeeting() {
        basePage.waitCondition(joinAMeetingBtn);
        return joinAMeetingBtn.isDisplayed();
    }

    public void tapJoinAMeetingBtn() {
        joinAMeetingBtn.click();
    }

}
