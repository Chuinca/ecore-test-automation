@Login
Feature: User goes through Login process
  @Positive
  Scenario: Verify positive Login
    Given User navigate to the application Login Page
    When User "user.demo" enter username and password
    Then User should login successfully
    And User logout from the system

  @Negative
  Scenario Outline: Verify negative Login
    Given User navigate to the application Login Page
    When User "<userKey>" enter username and password
    Then User should NOT be able to login
    Examples:
      | userKey    |
      | user.fail1 |
      | user.fail2 |
      | user.fail3 |
      | user.demo  |