Feature: Delete Seller

  @positive
  Scenario: Successfully delete a user by ID
    And I have a valid authorization token
    When I send a DELETE request to ""/api/myaccount/sellers/5747"
    Then the response status code should be 200
    And the response body should contain "User deleted successfully"