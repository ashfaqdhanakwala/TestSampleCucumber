Feature: Search and Place Order for Products

  @FirstFeature
  Scenario Outline: Search Experience for product on both pages home and offer page
    Given User is on GreenCart Landing Page
    When  User Searches with shortname "<Name>" and extracts actual product name
    Then  User Searches for same shortName "<Name>" in offers page to check if product exist

    Examples:
      | Name |
      | Tom  |
      | Beet |
