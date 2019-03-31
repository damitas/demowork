Feature: As a User, I want to delete an exisiting computer

  Contains scenarios to:
  Delete an existing computer record


  Background:
    Given the Homepage has loaded

   @sanity
   @smoke
   Scenario: As a user, the edit screen title is correct
    Given the edit computer screen is loaded for a unique computer name
    When I click on the "Delete this computer" button
    Then the computer deleted message is displayed