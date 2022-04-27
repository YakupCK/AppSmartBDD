@wip
Feature: Reservation API Testing

  Background:
    Given I connected to Base URI
    * Endpoint is "/fuIEWGcWJxqoOcFc/reserve"
    * Content-type is "application/json"
    * Accept is "application/json"

  Scenario: Make a valid reservation - Positive Scenario
    When I send a POST request with the following JSON model
    """
      {
          "branch_id": "1954",
          "email": "enjoypizzabremen@mailinator.com",
          "phone": "^905440999999",
          "name": "Yakup Cemil",
          "amount": 5,
          "date": "12.05.2022",
          "time": "10:00:00",
          "comment": "I booked for 5 people",
          "uuid": "Hermes Web Shop 3",
          "lang": "de"
      }
    """
    Then the status code is 200
    * Content-type is "application/json"
    * Success field in response body is "true"
    * Datum field in response body includes the date and time


  Scenario: Make an invalid reservation - Past Time
    When I send a POST request with the following JSON model
    """
      {
          "branch_id": "1954",
          "email": "enjoypizzabremen@mailinator.com",
          "phone": "^905440999999",
          "name": "Yakup Cemil",
          "amount": 5,
          "date": "12.05.1998",
          "time": "10:00:00",
          "comment": "I booked for 5 people",
          "uuid": "Hermes Web Shop 3",
          "lang": "de"
      }
    """
    Then the status code is NOT 200
    * Content-type is "application/json"
    * Success field in response body is "false"
    * An error message is displayed


  Scenario: Make an invalid reservation - Without Body
    When I send a POST request without a request body
    Then the status code is NOT 200
    * Content-type is "application/json"
    * Success field in response body is "false"
    * An error message is displayed