Feature: Regression testing

  Scenario: Search For Courses
    Given user should be on courseera homepage
    When user search for "Web Development" courses
    And user select English language
    And user select beginners level

  Scenario: Extracting details1
    Given user should see all courses
    When user click on first course
    Then user get the details

  Scenario: Extracting details2
    Given user should see all courses
    When user click on second course
    Then user get the details

  Scenario: Extract language and levels
    Given user should be on homepage
    When User look for "Language Learning"
    And user extract all languages
    And user extract all levels
    Then user display langauge and level information
