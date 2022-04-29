@wip
Feature: Select Menu

  Scenario Outline: Select Pizza and different menu
    Given The user is on the initial page
    And The user clicks "Enjoy Pizza Bremen"
    When The user chooses "<food1>" from "<menu1>" with the size of "<size1>"
    And adds "<ingredient1>" from "<ingredientMenu1>" by <quantity1> times
    And adds "<ingredient2>" from "<ingredientMenu2>" by <quantity2> times
    And clicks on Confirm Btn
    And The user chooses "<food2>" from "<menu2>" with the size of "<size2>"
    Then All the choices must be seen in Shopping Chart with the correct amount and price

    Examples:
      | food1        | menu1 | size1 | ingredient1 | ingredientMenu1 | quantity1 | ingredient2 | ingredientMenu2 | quantity2 | food2    | menu2    | size2 |
      | Pizza Salami | Pizza | 36    | Ananas      | Extrazutaten 1  | 3         | Mozzarella  | Extrazutaten 2  | 1         | Tiramisu | Desserts |       |
      | Pizza Sucuk  | Pizza | 36    | Sardellen   | Extrazutaten 2  | 5         | Gambas      | Extrazutaten 4  | 2         | Lasagne  | Lasagne  |       |


  Scenario Outline: Select Pizza with different options - Reduce the amount
    Given The user is on the initial page
    And The user clicks "Enjoy Pizza Bremen"
    When The user chooses "<foodName>" from "<menu>" with the size of "<size>"
    And adds "<ingredient1>" from "<ingredientMenu1>" by <quantity1> times
    And adds "<ingredient2>" from "<ingredientMenu2>" by <quantity2> times
    And The user reduces "<ingredient1>" from "<ingredientMenu1>" by <quantity3> times
    And The user reduces "<ingredient2>" from "<ingredientMenu2>" by <quantity4> times
    And clicks on Confirm Btn
    Then All the choices must be seen in Shopping Chart with the correct amount and price

    Examples:
      | foodName     | menu  | size | ingredient1 | ingredientMenu1 | quantity1 | ingredient2 | ingredientMenu2 | quantity2 | quantity3 | quantity4 |
      | Pizza Salami | Pizza | 36   | Ananas      | Extrazutaten 1  | 9         | Mozzarella  | Extrazutaten 2  | 7         | 2         | 3         |
      | Pizza Sucuk  | Pizza | 36   | Sardellen   | Extrazutaten 2  | 5         | Gambas      | Extrazutaten 4  | 3         | 4         | 2         |
