package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class JoinMeetingPage extends PageFactory {

    BasePage basePage;

    public JoinMeetingPage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.basePage = new BasePage();
    }

    @AndroidFindBy(id = "us.zoom.videomeetings:id/edtConfNumber")
    public MobileElement meetingIDTxtField;

    @AndroidFindBy(id = "us.zoom.videomeetings:id/btnJoin")
    public MobileElement joinMeetingBtn;

    @AndroidFindBy(accessibility = "Turn Off My Video")
    public MobileElement videoTurnOffToggle;

    @AndroidFindBy(id = "us.zoom.videomeetings:id/txtConnecting")
    public MobileElement loader;

    @AndroidFindBy(id = "us.zoom.videomeetings:id/txtMsg")
    public MobileElement errorMsg;

    public void isDisplayedMeetingIDTextField() {
        basePage.waitCondition(meetingIDTxtField);
    }

    public Boolean isEnabledJoinMeeting() {
        return joinMeetingBtn.isEnabled();
    }

    public void enterMeetingCode(String meetingCode) {
        meetingIDTxtField.sendKeys(meetingCode);
    }

    public void selectTurnOffMyVideoToggle() {
        videoTurnOffToggle.click();
    }

    public void selectJoinMeetingBtn() {
        joinMeetingBtn.click();
    }

    public void pushAppToBackgraound() {
        helpers.PageFactory.getDriver().runAppInBackground(Duration.ofSeconds(10));

    }

    public void isErrorMessageDisplayed(String msg) {
        basePage.waitTillProgressIconIsDisabled(loader, 120);
        basePage.waitCondition(errorMsg);
        if (!errorMsg.getText().replace("\n", " ").equals(msg)) {
            Assert.assertEquals("Error Message is not matching", msg, errorMsg.getText());
        }
    }
}
