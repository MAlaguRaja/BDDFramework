#Author:rajamurugeshk@gmail.com
Feature: Cart and Checkout to validate product details

  Scenario: Verify Products Add to Cart test scenario
    Given User is on home screen
    Then Verify home page is displayed on the screen
    When User tap on "Best sellers" option in home screen
    And User tap on See more Best Sellers in Camera & Photo in best sellers page
    And User select fifth product in product list page
    And User select "8" product quantity in product details page
    When User tap on "Add to cart" to add the product in cart
    Then Verify product name and total amount is displayed correctly on cart screen
    When User close the browser
    
    
#-----------------------------------------------------------------------------------
