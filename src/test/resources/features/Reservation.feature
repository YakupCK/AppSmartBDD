@wip
Feature: Reseervation

  Background:
    Given The user is on the initial page
    And The user clicks "Enjoy Pizza Bremen"
    And The user clicks on Table reservation
    And The user should be able reservation menu shows up

  Scenario: Make a valid reservation
    When The user enters "John Doe" into "Full name" field
    And The user enters "+8574673322" into "Phone" field
    And The user enters "enjoypizzabremen@mailinator.com" into "E-mail" field
    And The user selects "Today" as a date
    And The user selects "20:00" as a time
    And The user selects 3 people
    And The user clicks on I agree check box
    And The user clicks on send button
    Then A confirmation message should be displayed
    And The user gets a confirmation email for reservation

  Scenario: User can not make a reservation without filling the form
    When The user attempt to reserve without filling the form
    Then The user shouldn't reserve a table

  Scenario: User can not reserve a previous date
    When The user attempt to reserve a previous date
    Then The user shouldn't reserve a previous date


