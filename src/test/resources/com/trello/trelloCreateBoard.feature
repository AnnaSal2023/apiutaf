Feature: Trello create board feature
  Scenario: Successful board creating
    Given I have base url "https://api.trello.com"
    And token "ATTA0626bd8c3fd79ea856f3f559f2d4368ae408311e48c1e2b85c637845ff109a93EFD196FC"
    And api key "2cdf31e145ce0a1e5e6f9caa177ecc84"
    When I send POST request to endpoint "/1/boards/"
    And set name for new board as "TestBoard2803"
    Then I should get response with status code 200