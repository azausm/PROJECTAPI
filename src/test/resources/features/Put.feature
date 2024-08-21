Feature: Update Teacher

  @positive2
  Scenario: verify tag can be updated
    Given base url "https://backend.cashwise.us/"
    When I provide "VALID TOKEN" authorization token
    And I provide "daiyr" with "Daiyrbaike"
    And I provide "kr" with "USA"
    And I hit PUT endpoint "https://backend.cashwise.us/api/myaccount/sellers/5747"
    Then verify status code is 200
    Then verify response body conatins "daiyr" with "Daiyrbaike"
    Then verify request body conatins "Kr" with "USA"

