@predefined
Feature: Smoke steps

  @predefined1
  @regression
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then I type "Cucumber" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    # Then I wait for 2 sec
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then I should see page title contains "- Google Search"
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

  Scenario: Predefined steps for Google page
    Given I open url for "google search engine"
    Then I should see page title as "Google"
    Then I type "Cucumber" into "search textfield"
    Then I click "search button"
  # Then I wait for 2 sec
    Then I wait for "results" to be present
    Then I should see page title contains "- Google Search"
    Then "results" should contain text "Cucumber"
    And I check final result

  @bing
  Scenario: Bing test for cucumber
    Given I open url "https://www.bing.com/"
    Then I should see page title as "Bing"
    Then I type "Cucumber" into element with xpath "//*[@name='q']"
    Then I click on element using JavaScript with xpath "//label[@id='search_icon']"
#    Then I wait for 2 sec
    Then I wait for element with xpath "//main[@aria-label='Search Results']" to be present
    Then I should see page title as "Cucumber - Search"
    Then element with xpath "//main[@aria-label='Search Results']" should contain text "Cucumber"


  @yahoo
  Scenario: Same thing with Yahoo
    Given I open url "https://www.yahoo.com/"
    Then I type "Cucumber" into element with xpath "//input[@name='p']"
    Then I click on element using JavaScript with xpath "//button[@type='submit']"
    And I wait for 3 sec


  @gibiru
  Scenario: Gibiru scenario
    Given I open url "https://gibiru.com/"
    And element with xpath "//div/*[contains(text(), 'Mobile App')]" should be displayed
    Then I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    Then I click on element using JavaScript with xpath "//button[@type='submit']"
    Then element with xpath "//div[@id='web-results']" should contain text "Cucumber"
    Then I wait for 3 sec

  @e2e_htc
  Scenario: HTC e2e scenario
    Given I open url "https://nop-qa.portnov.com/"
    Then element with xpath "//*[contains(text(), 'Featured products')]/../..//a[contains(text(), 'HTC')]" should be displayed
    Then I click on element using JavaScript with xpath "//*[contains(text(), 'Featured products')]/../..//a[contains(text(), 'HTC')]"
    Then element with xpath "//div[contains(@class, 'product-review-links')]" should not contain text "0"
    Then I clear element with xpath "//input[@aria-label='Enter a quantity']"
    Then I type "3" into element with xpath "//input[@aria-label='Enter a quantity']"
    Then I click on element with xpath "//div[contains(@class, 'overview')]//button[contains(text(), 'Add to cart')]"
    And I wait for element with xpath "//div[contains(@class, 'bar-notification')][contains(@class, 'success')]" to be present
    And element with xpath "//div[contains(@class, 'bar-notification')][contains(@class, 'success')]" should contain text "added"
    And I wait for 3 sec
    And I click on element with xpath "//a/span[contains(text(), 'Shopping cart')]"
    And element with xpath "//td[contains(@class, 'subtotal')]/span" should contain text "$735.00"
    Then I wait for 2 sec

  @nop_order
  Scenario: Nop order test scenario
    Given client open main page
    Then main page title should be displayed
    When client click "HTC" item
    Then client should see reviews with at least 1 review
    When client set items quantity to "3"
    And client click add to cart button
    And I wait for 3 sec
    Then client should see added to cart notification
    And I wait for 3 sec
    When client opens shopping cart
    Then items total amount shoud be "$735.00"