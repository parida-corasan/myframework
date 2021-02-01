Feature:
  Agile story:as a user,I should able to search when I am home page

@search
  Scenario Template: Title verification After search
    Given user on home page
    And  user search "<search value>"
    Then User should see "<expectedTitle>" in the right side of page

  Examples: search value compare to expected value
    | search value   | expectedTitle   |
    | teacup         | Teacup          |
    | bento box      | Bento           |
    | shah rukh khan | Shah Rukh Khan  |
    | stephen cho    | stephen cho     |
    | monica belluci | Monica Bellucci |

