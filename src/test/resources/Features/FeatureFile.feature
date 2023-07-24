Feature: Google Homepage

  #Background: Check Google HomePage
  #When I open Google Homepage
  
  @Smoke
  Scenario: Verify GoogleHomepage
    #Given I launch Chrome browser
    #Given I open a Chrome Browser
    When I open Google Homepage
    Then I verify that the page displays search text box
    Then Enter some Text in Search text box
    Then the page displays Google Search button
    And the page displays Im Feeling Lucky button
    Then Enter some Text in Search text box
    And Close the Application

#Scenario: Verify IntranetCapgemini
#Given I launch IntranetGapgemini in Chrome browser
#When I verify editprofile link
#Then Close the Application
