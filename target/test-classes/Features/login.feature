Feature: Login feature
  As a user I should able to login different accounts with
  correct credential, and dashboard displayed.

  Background  user on login page
    Given user on login page

  @positive @login
  Scenario: login with correct credential
    When user enter correct email and password as posmanager
    Then user should see dashboard

  @negative @login
  Scenario: login with incorrect credential
    When user enter incorrect email and password as posmanager
    Then user should see error message

  @positive @login
  Scenario:login with correct credential
    When user enter correct email and password as eventmanager
    Then eventmanager should see dashboard

  @negative @login
  Scenario: login with incorrect credential
    When user enter incorrect email and password aseventmanager
    Then eventmanager should see error message


  @positive @login
  Scenario:login with correct credential
    When user enter correct email and password as salesmanager
    Then salesmanager should see dashboard

  @negative  @login
  Scenario: login with incorrect credential
    When user enter incorrect email and password salesmanager
    Then salesmanager should see error message

