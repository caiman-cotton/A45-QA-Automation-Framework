Feature: Login feature

  Scenario: Login Success
  Given I am on login page
  When I enter email "caiman.cotton@testpro.io"
  And I enter password "te$t$tudent"
  And I click submit button
  Then I am logged in