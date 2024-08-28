Feature: Update seller information


  @updateSeller
  Scenario: Successfully update a seller's details
    When user provide the valid token authorization
    And I provide seller name with "dastan"
    And I provide seller email with "Dastan@gmail.com"
    When I hit PUT endpoint "/api/myaccount/sellers/5747"
    Then verify response status code should be 200
    And verify response body should contain "Seller updated successfully"









