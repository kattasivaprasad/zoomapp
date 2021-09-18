Feature: To verify the LinkedIn app Behaviour

  @LinkedInApp
  Scenario: To Validate the features of linkedin app
    Given user is on landing screen
    Then user should see the messages on landing screen
    And user login with valid userName and password
    And user searched with "Callsign"
    And user checks See all results is displayed and validates the list of result is having "Callsign" name
    And user apply "My connections" filter for Search messages option
    And user verifies my connections tab is selected
    When user selects setting option after selecting the profile picture icon of the left corner
    Then user should be able to see LinkedIN banner at the bottom of the screen
