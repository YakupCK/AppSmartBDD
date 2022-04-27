@wip
Feature: Checkout

  Background:
    Given The user is on the initial page
    And The user clicks "Enjoy Pizza Bremen"
    And The user chooses "Pizza Salami" from "Pizza" with the size of "36"
    And The user fills out the address form with followings and proceed to checkout
      | John                            |
      | Doe                             |
      | appSmart                        |
      | Long Street                     |
      | 33/15                           |
      | 41000                           |
      | Istanbul                        |
      | enjoypizzabremen@mailinator.com |
      | 12099216581                     |
      | Please Keep it warm!            |

  Scenario: Verify that price on the confirmation menu is the same as shopping chart menu
    Then Total price on the confirmation menu is the same as shopping chart menu

  Scenario: Verify inform me checkbox
    When The user clicks on inform me check box
    Then inform me check box gets clicked

  Scenario: Verify payment methods
    Then available payment methods are as listed below
      | Cash           |
      | Online payment |
      | PayPal         |
      | EC-Card        |

  Scenario: Verify cash payment method
    When The user selects "Cash" payment method and proceed
    Then The user should see a success message
    And The user gets a confirmation email for order
    And Total price on the email is the same as confirmation menu


  Scenario: Verify visa payment method
    When The user selects "Online payment" payment method and proceed
    Then The user is on the sandbox page
    When The user enters valid credit card numbers and proceed
    Then The user lands on the confirm payment page
    And The total amount on the confirm payment page is the same as shopping chart menu
    When The user clicks on confirm button and enters the received sms code
    Then The order is successful
    And The user gets a confirmation email for order


  Scenario: Verify paypal payment method - 1
    When The user selects "PayPal" payment method and proceed
    Then The user is on the sandbox page


  Scenario: Verify paypal payment method - 2
    When The user selects "Online payment" payment method and proceed
    Then The user is on the sandbox page
    When The user clicks on PayPal btn and proceed
    Then The user lands on the confirm payment page
    And The total amount on the confirm payment page is the same as shopping chart menu
    When The user clicks on confirm button and enters paypal information
    Then The order is successful
    And The user gets a confirmation email for order


  Scenario: Verify EC-Card payment method
    When The user selects "EC-Card" payment method and proceed
    Then The user is on the sandbox page





