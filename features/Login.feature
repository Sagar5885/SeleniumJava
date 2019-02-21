#Each Feature file contains one feature
Feature: Test Login Functionality at SDET University

#A Feature could have multiple scenarios

# Scenario use Given-when-then structure
Scenario: The user should be able to login using correct username and password
  Given user is on the login page
  When user enters correct username and password
  Then user gets confirmation

Scenario Outline: The user should be able to login
  Given user is on the login page
  When user enters <username>
  And user enters <password>
  And user click on login
  Then user gets confirmation

Examples:
  | username | password |
  | tim@testemail.com | trpass |
  | rw@testemail.com | rwpass |
  | jv@testemail.com | jvpass |
