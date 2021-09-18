Feature: To verify the join meeting option with invalid meeting code

  @ZoomAppTask
  Scenario: To Validate the behaviour of Zoom app with invalid meeting code
    Given user is on home page of zoom page
    When user selects Join a Meeting option
    Then user should not be able to select Join Meeting button without the meeting code
    When user enters random "9" digits code for meeting code
    And selects Join Meeting with Turn Off My Video toggle enabled
    Then after putting the app in background and taking it to foreground again user should see an error message "This meeting has an unexpected error. Error code: 5004"