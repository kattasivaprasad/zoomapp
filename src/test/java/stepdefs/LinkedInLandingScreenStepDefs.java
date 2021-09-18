package stepdefs;

import helpers.PageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LinkedInLandingScreenPage;

public class LinkedInLandingScreenStepDefs {

    LinkedInLandingScreenPage landingScreenPage = new LinkedInLandingScreenPage(PageFactory.getDriver());

    @Given("user is on landing screen")
    public void user_is_on_landing_screen() {
        Assert.assertTrue("Sign In Button is not displayed", landingScreenPage.isDisplayedSignInBtn());
    }

    @Then("user should see the messages on landing screen")
    public void user_should_see_the_message_message_on_landing_screen() {

    }

    @Then("user login with valid userName and password")
    public void user_login_with_valid_user_name_and_password() {

    }

    @Then("user searched with {string}")
    public void user_searched_with(String string) {

    }

    @Then("user checks See all results is displayed and validates the list of result is having {string} name")
    public void user_checks_see_all_results_is_displayed_and_validates_the_list_of_result_is_having_name(String string) {

    }

    @Then("user apply {string} filter for Search messages option")
    public void user_apply_filter_for_search_messages_option(String string) {
    }

    @Then("user verifies my connections tab is selected")
    public void user_verifies_my_connections_tab_is_selected() {

    }

    @When("user selects setting option after selecting the profile picture icon of the left corner")
    public void user_selects_setting_option_after_selecting_the_profile_picture_icon_of_the_left_corner() {

    }

    @Then("user should be able to see LinkedIN banner at the bottom of the screen")
    public void user_should_be_able_to_see_linked_in_banner_at_the_bottom_of_the_screen() {

    }
}
