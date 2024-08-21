@CreateCategory
  Feature:  category on CashWise

    Scenario: Creating a category on CashWise
      Given user is on the base url "https://backend.cashwise.us"
      When I provide the valid token authorization
      And I provide category_title with "clothess"
      And I provide category_description with "these are clothes"
      And I provide flag with true
      And I hit POST endpoint "https://backend.cashwise.us/api/myaccount/categories"
      Then verify status code is 201



