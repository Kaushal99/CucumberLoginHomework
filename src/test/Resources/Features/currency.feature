@currency
  Feature: User Should be on homepage,
  So user can select the currency from top left corner to US Dollar or Euro

  Scenario: User should be able to select currency

    Given user should able to click on drp down to see currency option
    When user should able to select currency US Dollar or Euro
    Then user should able to see the price of product in selected currency successfully
