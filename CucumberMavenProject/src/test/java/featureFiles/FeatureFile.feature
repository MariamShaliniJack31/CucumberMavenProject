Feature: Google Homepage

#Scenario: Verify GoogleHomepage
#Given I open a Chrome Browser
#Then Close the Application

Scenario: Verify GoogleHomepageTwo
Given I launch Chrome browser
When I open Google Homepage
Then I verify that the page displays search text box
Then Enter some Text in Search text box
Then the page displays Google Search button
And the page displays Im Feeling Lucky button
And Close the Application

#Scenario: Verify IntranetCapgemini
#Given I launch IntranetGapgemini in Chrome browser
#When I verify editprofile link
#Then Close the Application