@wip
Feature: Get Menu Info Feature

  Background:
    Given I connected to Base URI
    * Endpoint is "fuIEWGcWJxqoOcFc/get-single-product/1954/"
    * Content-type is "application/json"
    * Accept is "application/json"

  Scenario: Make a valid reservation - Positive Scenario
    When I send a GET request with "266286" endpoint
    Then the status code is 200
    * Content-type is "application/json; charset=utf-8"
    * Success field in response body is "true"
    * Product id field in response body is 266286
    * Name field in response body is "Tiramisu"


  Scenario: Make a valid reservation - Positive Scenario
    When I send a GET request with "265863" endpoint
    Then the status code is 200
    * Content-type is "application/json; charset=utf-8"
    * Success field in response body is "true"
    * Product id field in response body is 265863
    * Name field in response body is "Pizza Salami"
    * Price of "26 cm" is 5.8
    * Price of "32 cm" is 7.5
    * Price of "36   cm" is 8.7



