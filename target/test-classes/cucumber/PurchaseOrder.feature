
@tag
Feature: Purchase the order from Ecommerce Web
  I want to use this template for my feature file
  
	Background:
	Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." is displayed on confirmation page

    Examples: 
      | name    | password | productName |
      | w@w.com | Qwerty2@ | ADIDAS ORIGINAL |
      
      
      
      