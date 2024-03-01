
Feature: Smoke Testing


  Scenario: Launch Browser
    Given user should launch the browser
    When user navigates to url
    Then Web page should load

  
  Scenario: Validate search box
    Given user should be on courseera homepage
    Then search box should displayed

 
  Scenario: Validate Search Icon
    Given user should be on courssera homepage
    When user search for "Web Development" course

  
  Scenario: Validate show more link
    Given user should see all courses
    Then user should see all available language options

  
  Scenario: Validate filters
    Given user should see all courses
    When user clicks on Beginner level
    Then checkbox should be selected.

  
  Scenario: Validate first navigation links
    Given user should be on courssera homepage
    When user clicks on for individual link
    Then user should see courseera homepage

  
  Scenario: Validate second navigation links
    Given user should be on courssera homepage
    When user clicks on for bussiness link
    Then user should see bussiness page.

  
  Scenario: Validate third navigation links
    Given user should be on courssera homepage
    When user clicks on for universities link
    Then user should see for campus page

  
  Scenario: Validate Solution dropdown
    Given user should see bussiness page
    Then user clicks on the solution dropdown
    When user should see  solutions options

  
  Scenario: Validate Solution dropdown options
    Given user should click on solution dropdown
    When user clicks on For Campus option
    Then user should see for campus page
