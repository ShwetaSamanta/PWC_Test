
Feature: FlipKart Search

  @test
  Scenario: Add to cart
    Given I Open FlipKart URL
    And Search for Mobile Phone
    When I Found the expected open
    And Added to Cart
    And check If correct Product Added
    Then I validate the outcomes
    And I close the bowser

  
