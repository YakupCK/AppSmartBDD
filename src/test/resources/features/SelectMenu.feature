@wip
Feature: Select Menu

  Scenario Outline: Select Pizza with different options
    Given The user is on the initial page
    And The user clicks "Enjoy Pizza Bremen"
    When The user chooses "<foodName>" from "<menu>" with the size of "<size>"
    And adds "<ingredient1>" from "<ingredientMenu1>" by <quantity1> times
    And adds "<ingredient2>" from "<ingredientMenu2>" by <quantity2> times
    And clicks on Confirm Btn
    Then All the choices must be seen in Shopping Chart with the correct amount and price

    Examples:
      | foodName     | menu  | size | ingredient1 | ingredientMenu1 | quantity1 | ingredient2 | ingredientMenu2 | quantity2 |
      | Pizza Salami | Pizza | 36   | Ananas      | Extrazutaten 1  | 3         | Mozzarella  | Extrazutaten 2  | 1         |


  Scenario Outline: Select Pizza with different options2
    Given The user is on the initial page
    And The user clicks "Enjoy Pizza Bremen"
    When The user chooses "<foodName>" from "<menu>" with the size of "<size>"
    And adds "<ingredient1>" from "<ingredientMenu1>" by <quantity1> times
    And adds "<ingredient2>" from "<ingredientMenu2>" by <quantity2> times
    And The user reduces "<ingredient1>" from "<ingredientMenu1>" by <quantity3> times
    And clicks on Confirm Btn
    Then All the choices must be seen in Shopping Chart with the correct amount and price

    Examples:
      | foodName     | menu  | size | ingredient1 | ingredientMenu1 | quantity1 | ingredient2 | ingredientMenu2 | quantity2 | quantity3 |
      | Pizza Salami | Pizza | 36   | Ananas      | Extrazutaten 1  | 9          | Mozzarella  | Extrazutaten 2  | 1         | 2         |
#
#      | foodName        | Pizza Salami       |
#      | menu            | Pizza              |
#      | size            | 36                 |
#      | ingredient1     | Ananas             |
#      | ingredientMenu1 | xtrazutaten 1 (0   |
#      | quantity1       | 3                  |
#      | ingredient2     | Mozzarella         |
#      | ingredientMenu2 | Extrazutaten 2 (0) |
#      | quantity2       | 1                  |