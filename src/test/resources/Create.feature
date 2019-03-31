Feature: As a User, I want to create new computer records, so I can view the new records on the computer list page

  Contains scenarios to:
    Create new computer records
    Validation of input fields

  Background:
    Given the Homepage has loaded

  @sanity
  @smoke
  @regression
  Scenario: As a user, the Add a computer screen title is correct
    Given I click on the "Add a new computer" button
    Then the title of the page is "Add a computer"

  @sanity
  Scenario Outline: As a user, I can create a new computer
    Given I click on the "Add a new computer" button
    When I "create" the computer with "<computerName>" "<introducedDate>" "<discontinuedDate>" "<companyName>"
    And I click on the "Create this computer" button
    Then the "<computerName>" is successfully saved

    Examples:
      | computerName      | introducedDate | discontinuedDate | companyName |
      | PCDS_MacBookAir   | 2013-11-01     | 2019-06-19     | Apple Inc.|

  @smoke
  Scenario: As a user, I should not be able to create a blank computer
    Given I click on the "Add a new computer" button
    When I click on the "Create this computer" button
    Then the computer name field errors

  @smoke
  Scenario: As a user, I should be able to cancel creating a new computer
    Given I click on the "Add a new computer" button
    And I click on the "Cancel" button
    Then the Homepage has loaded

  Scenario Outline: As a user, I should not be able enter an invalid date
    Given I click on the "Add a new computer" button
    When I enter the invalid dates "<introducedDate>" "<discontinuedDate>"
    And I click on the "Create this computer" button
    Then the date fields error

    Examples:
     | introducedDate | discontinuedDate |
     | 2019-02-31     | 2019-19-03       |

  Scenario Outline: As a user, I should be able to create a new computer with a combination of minimum data
    Given I click on the "Add a new computer" button
    When I "create" the computer with "<computerName>" "<introducedDate>" "<discontinuedDate>" "<companyName>"
    And I click on the "Create this computer" button
    Then the "<computerName>" is successfully created

    Examples:
      | computerName              | introducedDate | discontinuedDate | companyName |
      | PCDS_MacBookAir           | 2013-11-01     | 2019-06-19     | Apple Inc.|
      | PCDS_MacBookAirNoIntroDate|                | 2019-06-19     | Apple Inc.|
      | PCDS_MacBookAirNoDisDate  | 2013-11-01     |                | Apple Inc.|
      | PCDS_MacBookAirJustComputerName  |         |                |           |