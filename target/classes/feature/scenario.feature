@Tags
Feature: calculator to verify numbers
  Background:
    Given I am background
	@Smoke @Add @Scenario1
  Scenario: Add and verify two numbers
    Given I have two  numbers 10 and 20
    When I added both number
    Then I verify result is 30
 @Regression @Add @Scenario2
  Scenario Outline: Add two numbers and verify
    Given I have two  numbers <first> and <second>
    When I added both number
    Then I verify result is <result>
    Examples:
      | first | second | result |
      |    10 |     20 |     30 |
      |    25 |     15 |     40 |
      |    30 |     20 |     50 |
      |    10 |     15 |     25 |
      |     5 |     10 |     15 |