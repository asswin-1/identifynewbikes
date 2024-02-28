Feature: New Bikes

  Scenario: Upcoming bikes
    Given the user is on the zigwheels homepage
    When the user hovers to the new bikes tab and clicks the upcoming bikes tab
    When the user selects honda model
    And the user scrolls down and clicks the view more bikes button
    Then the user should able to get the bikes below 4 lakh