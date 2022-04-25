
Feature: Delivery

  #bug here
  Scenario Outline: Delivery to a valid address
    Given The user is on the initial page
    When The user selects a "<valid address>"
    Then The user should be able to proceed

    Examples:
      | valid address                       |
      | Langemarckstr. 92 28199 Bremen      |
      | Nutzhornerstr. 12 27753 Delmenhorst |



  Scenario Outline: Delivery to an invalid address
    Given The user is on the initial page
    When The user selects a "<invalid address>"
    Then The user should NOT be able to proceed

    Examples:
      | invalid address                           |
      | 78733 Aichhalden, Zubermoosstraße 87      |
      | 78579 Neuhausen ob Eck, Tuttlinger Str. 2 |
