package stepdefs;

import helpers.PageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.JoinMeetingPage;
import pages.MeetingLaunchPage;

import java.util.Random;

public class ZoomAppPageStepDefs {
    String meetingCode;

    MeetingLaunchPage meetingLaunchPage = new MeetingLaunchPage(PageFactory.getDriver());
    JoinMeetingPage joinMeetingPage = new JoinMeetingPage(PageFactory.getDriver());

    @Given("user is on home page of zoom page")
    public void user_is_on_home_page_of_zoom_page() {
        Assert.assertTrue("Join a meeting button is not displayed", meetingLaunchPage.isDisplayedJoinaMeeting());
    }

    @When("user selects Join a Meeting option")
    public void user_selects_join_a_meeting_option() {
        meetingLaunchPage.tapJoinAMeetingBtn();
    }

    @Then("user should not be able to select Join Meeting button without the meeting code")
    public void user_should_not_be_able_to_select_join_meeting_button_without_the_meeting_code() {
        joinMeetingPage.isDisplayedMeetingIDTextField();
        Assert.assertFalse("Join A Meeting option is enabled", joinMeetingPage.isEnabledJoinMeeting());
    }

    @When("user enters random {string} digits code for meeting code")
    public void user_enters_random_digits_code_for_meeting_code(String string) {
        Random rnd = new Random();
        int number = rnd.nextInt(99999999);
        meetingCode = String.format("%09d", number);
        joinMeetingPage.enterMeetingCode(meetingCode);
        Assert.assertTrue("Join Meeting Button is Disabled", joinMeetingPage.isEnabledJoinMeeting());
    }

    @When("selects Join Meeting with Turn Off My Video toggle enabled")
    public void selects_join_meeting_with_turn_off_my_video_toggle_enabled() {
        joinMeetingPage.selectTurnOffMyVideoToggle();
        joinMeetingPage.selectJoinMeetingBtn();
    }

    @Then("after putting the app in background and taking it to foreground again user should see an error message {string}")
    public void after_putting_the_app_in_background_and_taking_it_to_foreground_again_user_should_see_an_error_message(String msg) {
        joinMeetingPage.pushAppToBackgraound();
        joinMeetingPage.isErrorMessageDisplayed(msg);

    }
}
