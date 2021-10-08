Feature: test

  Background:
    Given  The user navigate to the Aspiration Home Page

  Scenario: The Spend & Save page should display the products and prices
    When Click on the Spend & Save link at the top of the home page
    Then Aspiration and Aspiration Plus should be displayed

  Scenario: A modal containing an input field for an an email address should be displayed after click on Get Aspiration link
    When Click on the Spend & Save link at the top of the home page
    And Click on the Get Aspiration link
    Then A modal containing an input field for an an email address should be displayed

  Scenario: - A modal with monthly and yearly plans appears after click on the Get Aspiration Plus link
    When Click on the Spend & Save link at the top of the home page
    And Click on the Get Aspiration Plus link
    Then A modal with monthly and yearly plans should be displayed

  Scenario: Yearly radio option should display $71.88 paid once yearly
    When Click on the Spend & Save link at the top of the home page
    And Click on the Get Aspiration Plus link
    Then Yearly radio option should display yearly price

  Scenario: Monthly radio option should display $7.99 paid monthly
    When Click on the Spend & Save link at the top of the home page
    And Click on the Get Aspiration Plus link
    Then Monthly radio option should display monthly price