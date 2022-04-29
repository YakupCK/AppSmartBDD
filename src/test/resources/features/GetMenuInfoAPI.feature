@wip
Feature: Get Menu Info Feature

  Background:
    Given I connected to Base URI
    * Base Path is "/api2.5/fuIEWGcWJxqoOcFc/get-single-product/1954/"
    * Content-type is "application/json"
    * Accept is "application/json"

  @api
  Scenario Outline: Get an item info Tiramisu
    When I send a GET request with the path parameter <path param>
    Then the status code is <status code>
    * Content-type in response is "<content-type>"
    * Success field in response body is "<success>"
    * Product id field in response body is "<product id>"
    * Name field in response body is "<product name>"
    Examples:
      | path param | status code | content-type                    | success | product id | product name |
      | 266286     | 200         | application/json; charset=utf-8 | true    | 266286     | Tiramisu     |
      | 265863     | 200         | application/json; charset=utf-8 | true    | 265863     | Pizza Salami |




