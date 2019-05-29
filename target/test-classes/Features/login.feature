Feature: User Should not be abel to log in with invalid credentials and see the error message
  Background:
    Given User should be on homepage
    When User click on Login button
  @login



  Scenario Outline: User should not be able to login with invalid credentials

    And User should able to input invalid "<Email>" and/or "<Password>"
    Then User should able to click LOGIN button
    And User should able to see the "<error message>" loggin unsucessfull
    Examples:
      | Email | Password | error message |
      |Patelkaus@gmail.com| abc1234|Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect|
      |Kpatel@gmail.com   |abc1234 |Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect|
      |Patelkaus@gmail.com|Test1234|Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect|
      |                   |        |Please enter your email                                                                               |
      |                   |Test1234|Please enter your email123546546546                                                                               |
      |                   |abc1234 |Please enter your email                                                                               |
      |Kpatel@gmail.com   |        |Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect|
      |Patelkaus@gmail.com|        |Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect|

#  Scenario:
#
#    When User click on Login button
#    And User should able to input valid "<Email>" and/or "<Password>"
#    Then User should able to click LOGIN button
#    And user should able to see the "<message>" loggin sucessfull
#