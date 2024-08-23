#Author: subash7726@gmail.com
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
Feature: Checking Login Functionality

  Scenario: Login with valid mobile and Password
    Given User should navigate to the website
    And User can able to click login button
    And User Entering mobile as "9876543210"
    And User Entering password as "dummy"
    When User click the login button
    Then Login should be Success

  Scenario: Login with invalid mobile and Password
    Given User should navigate to the website
    And User can able to click login button
    And User Entering mobile as "7494014567"
    And User Entering password as "invlaid"
    When User click the login button
    Then Login should be Fail

  Scenario: Login with valid mobile and invalid Password
    Given User should navigate to the website
    And User can able to click login button
    And User Entering mobile as "9876543210"
    And User Entering password as "fakedummy"
    When User click the login button
    Then Login should be Fail

  Scenario: Login with invalid mobile and valid Password
    Given User should navigate to the website
    And User can able to click login button
    And User Entering mobile as "7070707034"
    And User Entering password as "dummy"
    When User click the login button
    Then Login should be Fail
