Feature: Category

  Background:
    Given User should be on homepage

  @category
    Scenario Outline: User should able to select all category from homepage and he should opens in new windows all category

      When User should see "<category>" on homepage
      Then User should able to click on "<selected category link>" successfully
      And User Should see the category page displayed sucessfully
    Examples:
      | category        | selected category link                          |
      |Computers        |   http://demo.nopcommerce.com/computers         |
      |Electronics      |    http://demo.nopcommerce.com/electronics      |
      |Apparel          |      http://demo.nopcommerce.com/apparel        |
      |Digital downloads| http://demo.nopcommerce.com/digital-downloads   |
      |Books            |  http://demo.nopcommerce.com/books              |
      |Jewelry          |   http://demo.nopcommerce.com/jewelry           |
      |Gift Cards       |    http://demo.nopcommerce.com/gift-cards       |