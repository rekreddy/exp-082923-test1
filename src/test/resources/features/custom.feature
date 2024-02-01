Feature: webDriver feature
  Scenario: Test scenario for web driver;
    Given client open web page

  Scenario: Portnov responsive test
    Given client open portnov web page
    Then client set browser size to mobile

  Scenario: Iterate through elements
    Given client open test url for the form
    And I type "111" into all input fields
    Then I wait for 2 sec

