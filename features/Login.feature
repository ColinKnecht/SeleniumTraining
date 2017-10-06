#Each feature file contains one feature
#Feature files use Gherkin language aka business language
Feature: Test the login functionality on sdet university

#A featuyre may have given different specific scenarios
#Scenarios use Given-When-Then structure
Scenario: the user should be able to login with correct username and password
Given user is on the login page
When user enters correct username and correct password
Then user gets confiramtion
