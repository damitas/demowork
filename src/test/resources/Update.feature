Feature: As a User, I want to update an existing computer record so that the computer record is up to date

  Contains scenarios to:
  Update an existing computer record
  Validation of input fields

  Background:
    Given the Homepage has loaded

   @sanity
   @smoke
   Scenario: As a user, the edit screen title is correct
    Given the edit computer screen is loaded for a unique computer name
    Then the title of the page is "Edit computer"

  @sanity
  @smoke
  Scenario Outline: As a user, I can update an existing computer
    Given the edit computer screen is loaded for a unique computer name
    When I "update" the computer with "<computerName>" "<introducedDate>" "<discontinuedDate>" "<companyName>"
    And I click on the "Save this computer" button
    Then the "<computerName>" is successfully saved

    Examples:
      | computerName      | introducedDate | discontinuedDate | companyName |
      | PCDS_MacBookAirUpdate   | 2013-11-01     | 2019-06-19     | Apple Inc.|

  @sanity
  @smoke
  Scenario: As a user, the edit screen contains the correct details of a selected computer
    Then the edit computer screen is verified for a unique computer name

  Scenario: As a user, I should be able to cancel editing a new computer
    Given the edit computer screen is loaded for a unique computer name
    When I click on the "Cancel" button
    Then the Homepage has loaded

  @sanity
  @smoke
  Scenario: As a user, I should not be able to create a blank computer name on the edit screen
    Given the edit computer screen is loaded for a unique computer name
    And  I clear the computer name field
    When I click on the "Save this computer" button
    Then the computer name field errors

  Scenario Outline: As a user, I should not be able enter an invalid date on the edit screen
    Given the edit computer screen is loaded for a unique computer name
    When I enter the invalid dates "<introducedDate>" "<discontinuedDate>"
     When I click on the "Save this computer" button
    Then the edit date fields error

    Examples:
      | introducedDate | discontinuedDate |
      | 2019-02-31     | 2019-19-03       |
