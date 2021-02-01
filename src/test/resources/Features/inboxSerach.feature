Feature:
  agile story:As a user , i should able to search on #inbox page

  @inbox
  Scenario:
    Given user on #inbox page
    When user enter "project" in search box
    Then  use should see message on dashboard