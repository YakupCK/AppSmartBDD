@wip
Feature: Address and Personal Details Form

  Background:
    Given The user is on the initial page
    And The user clicks "Enjoy Pizza Bremen"
    And The user chooses "Pizza Salami" from "Pizza" with the size of "36"
    And clicks on Confirm Btn
    And The user clicks on Order Button

  Scenario Outline: Fill out the form with VALID data - Positive Scenario
    When The user enters valid "<FirstName>" to "First name" field
    And The user enters valid "<LastName>" to "Last name" field
    And The user enters valid "<Company>" to "Company" field
    And The user enters valid "<Street>" to "Street" field
    And The user enters valid "<HouseNumber>" to "Number" field
    And The user enters valid "<PostalCode>" to "Postal Code" field
    And The user enters valid "<City>" to "City" field
    And The user enters valid "<Email>" to "Email" field
    And The user enters valid "<Phone>" to "Phone" field
    And The user enters valid "<Comments>" to "Additional directions" field
    Then All inputs must be accepted and the user can proceed to checkout

    Examples:
      | FirstName | LastName | Company   | Street      | HouseNumber | PostalCode | City      | Email                           | Phone       | Comments                 |
      | John      | Doe      | Jira      | Long Street | 33/15       | 41000      | Istanbul  | enjoypizzabremen@mailinator.com | 1234568876  | 1 Keep it warm!          |
      | Yakup     | Cemil    | App Smart | Hall Street | 1/a         | 56000      | Trabzon61 | enjoypizzabremen@mailinator.com | +4326785543 | 2 Can you keep it fresh? |


  Scenario Outline: Fill out the form with INVALID data - Negative Scenario
    When The user enters invalid "<FirstName>" to "First name" field
    And The user enters invalid "<LastName>" to "Last name" field
    And The user enters invalid "<Company>" to "Company" field
    And The user enters invalid "<Street>" to "Street" field
    And The user enters invalid "<HouseNumber>" to "Number" field
    And The user enters invalid "<PostalCode>" to "Postal Code" field
    And The user enters invalid "<City>" to "City" field
    And The user enters invalid "<Email>" to "Email" field
    And The user enters invalid "<Phone>" to "Phone" field
    Then The user shouldn't proceed to checkout

    Examples:
      | FirstName | LastName  | Company | Street   | HouseNumber | PostalCode | City | Email       | Phone       |
      |           |           |         |          |             |            |      |             |             |
      | a354354   | a345346   | sd323   | fdf34    | sds+%       | sd233      | a^+  | e234ere     | +wedf3gdfg  |
      | a+&/(^+   | ba)/(/&%+ | ^+5-    | (/&'JHJK | asd^+%&/(   | '+^'       | b)/& | enjoy342men | asdas&%/&om |


