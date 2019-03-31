Feature: As a User, I want to search and page through the computer results

  Contains scenarios to:
  Page the computer results
  Filter the computer results

  Background:
    Given the Homepage has loaded

  @sanity
  Scenario: As a user, I can filter the results by name
    Given there is more than "1" page of results with computer name beginning "PagingTest"
    When I search for the computer name "PagingTest"
    And computer records are found

  @smoke
  Scenario: As a user, I am informed if no results are found
    When I search for a computer name that does not exists
    And no computer records are found

   @smoke
   Scenario: As a user, I can click to the next page
    Given there is more than "2" page of results with computer name beginning "PagingTest"
    And I search for the computer name "PagingTest"
    When I click on the next link
   Then the next 11 to 20 records are shown

  Scenario: As a user, I can click to the previous page
    Given there is more than "2" page of results with computer name beginning "PagingTest"
    And I search for the computer name "PagingTest"
    And I click on the next link
    When I click on the previous link
    Then the records 1 to 10 are shown
    And the previous link is disabled