Feature: Add Product To Cart

  Scenario: Add product to cart
    Given user login to saucedemo
    When user click Add to cart button in second list product
    And user click icon cart
    Then in cart page, will show the product that user choose