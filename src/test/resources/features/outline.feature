
Feature: Scenario outline example

  Scenario Outline: Quote tests with datasets
    Given I open url "http://quote-stage.portnov.com"
    Then I enter "<fullname>" into the field with xpath "//input[@id='name']"
    And I enter "<username>" into the field with xpath "//input[@name='username']"
    And I enter "<email>" into the field with xpath "//input[@name='email']"
    And I enter "<password>" into the field with xpath "//input[@name='password']"
    And I enter "<password>" into the field with xpath "//input[@name='confirmPassword']"
    And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@name='formSubmit']"
    Examples:
      |fullname | username        | email             | password  |
      |Artem    | artemoganesyan  | test@example.com  | 123456    |
      |Artem Og | test&^%21       | test11@example.com| 123456&^% |
      |Artem 32 | test-with-dash  | test11@example    | dfFDH123  |