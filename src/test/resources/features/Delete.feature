Feature: Delete Seller

  @positive
  Scenario: verify tag can Delete
    Given base url "https://backend.caswise.us/"
    When I provide "VALID TOKEN" authorization token
    And I provide "name_tag"
    And I hit DELETE endpoint "https://backend.cashwise.us/api/myaccount/sellers/5747"
    Then verify status code is 200