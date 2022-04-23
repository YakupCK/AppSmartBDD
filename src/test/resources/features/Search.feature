@wip
Feature: Search Functionality

  Background:
    Given The user is on the initial page
    And The user clicks "Enjoy Pizza Bremen"

  Scenario Outline: Exact Search
    When The user search for "<item>"
    Then "<item>" should appear on the page

    Examples:
      | item              |
      | Pizza Salami      |
      | Pasta al Pomodoro |
      | Tiramisu          |


  Scenario Outline: Particular Search
    When The user search for "<particularSearch>"
    Then Items on the page must contain "<particularSearch>"

    Examples:
      | particularSearch |
      | Salami           |
      | Pasta            |
      | Salat            |