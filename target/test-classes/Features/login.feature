@login
Feature: Login feature
  As a user I should able to login different accounts with
  correct credential, and dashboard displayed.


<<<<<<< HEAD
=======

>>>>>>> paridabranch
  @positive
  Scenario: login with correct credential
    Given user on login page
    When user enter correct email and password as posmanager
    Then user should see dashboard

  @negative
  Scenario: login with incorrect credential
    Given user on login page
    When user enter incorrect email and password as posmanager
    Then user should see error message

  @positive
  Scenario:login with correct credential
    Given user on login page
    When user enter correct email and password as eventmanager
    Then eventmanager should see dashboard

  @negative
  Scenario: login with incorrect credential
    Given user on login page
    When user enter incorrect email and password aseventmanager
    Then eventmanager should see error message


  @positive
  Scenario:login with correct credential
    Given user on login page
    When user enter correct email and password as salesmanager
    Then salesmanager should see dashboard

  @negative
  Scenario: login with incorrect credential
    Given user on login page
    When user enter incorrect email and password salesmanager
    Then salesmanager should see error message

