#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
Feature: Checking Registration functionality

  Scenario Outline: Registration check
    Given User should navigate to the website
    And User can able to click NewRegistration link
    And User Entering the fullname as <fullname>
    And User Entering the moblie as "<moblie>"
    And User Entering the email as <email>
    And User Entering the password as <password>
    And User Entering the gender as <gender>
    And User Entering the usertype as <usertype>
    When User click Signup button
    Then verify the user Register Succesfully

    Examples: 
      | fullname | moblie     | email            | password | gender | usertype |
      | "name1"  | 8101011010 | "dummy@mail.com" | "dummy"  | "Male" | "User"   |
