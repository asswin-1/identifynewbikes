Feature: Loginpage

  Scenario: Invalid mail
    Given the user on the homepage and clicks login button
    When the page is directed to the login page
    Then the user enters email as "asswin"
