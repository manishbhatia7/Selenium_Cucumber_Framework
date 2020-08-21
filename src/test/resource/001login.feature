Feature: Login to application
  @login
  Scenario Outline: Login to application
    When user launches the application
    And enters username as "<user>"
    And password as "<pwd>"
    And click on submit button
    Then login should be successful

    Examples:
    | user                |      pwd        |
    | admin@yourstore.com |      admin      |
