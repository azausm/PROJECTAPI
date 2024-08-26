Feature: test seller api

  @getSellerVerifyEmailNotEmpty @AzizTests
  Scenario: get a single seller and verify email is not empty
    Given user hits get single seller api with "/api/myaccount/sellers/"
    Then verify seller email is not empty

  @getAllSellers @AzizTests
  Scenario: get all sellers and verify sellers id is not 0
    Given user hits get all sellers api with "/api/myaccount/sellers"
    Then verify sellers id is not 0

  @archiveSeller @AzizTests
  Scenario: get a single sellers, archive all sellers and verify sellers are archived
    Given user hits get single seller api with "/api/myaccount/sellers/"
    Then user hits the api with "/api/myaccount/sellers/archive/unarchive" to archive the seller
    Then user hits get all archived sellers api with "/api/myaccount/sellers"
    Then user verify seller is archived