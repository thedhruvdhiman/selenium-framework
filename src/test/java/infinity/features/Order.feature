@orderFeature
Feature: I complete a purchase
  As a user I want to complete a purchase

  Background:
  Given I open browser and go to demo website


  Scenario Outline: I want to complete a purchase
    Given I login with <userid> and <password>
    When I add <productName> to cart
    And I checkout the product <productName>
    Then I verify the payment is completed


    Examples:
      | userid        | password     | productName         |
      | standard_user | secret_sauce | Sauce Labs Backpack |
