@login
Feature: Login feature
  As a user I should able to login different accounts with
  correct credential, and dashboard displayed.
  Background: user on login page
    Given user on login page

  @positive
  Scenario:
    When user enter correct credancial as posmanager
    Then user should see dashboard

  @negative
  Scenario:
    When user enter incorrect credancial as posmanager
    Then user should see error message
