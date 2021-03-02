@ebay
Feature:
    As a user I should able to search product click second product then add to cart button
    and display price

    Scenario: Validate the price mentioned on card
      Given user on Ebay homepage
      When  user Enter "iphone" and click 2nd product on list
      And click Add to Cart button
      Then user should see the correct price






