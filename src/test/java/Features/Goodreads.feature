Feature: Goodreads

  Background: Goodreads scenarios
    Given I open the Goodreads web page
    When I enter user id as "raluca.damian@endava.com"
    And I enter password as "Fast1234"
    Then I login
    And I verify the user


  Scenario: Login
    Given I verify the user


  Scenario: Search
    When I search for "Outlander"
    Then I select volume Outlander#1
    And I verify its status is <Read>
    # I mark it as <Read>
    And I go back in the browser
    And I select volume Outlander#2
    And I verify its status is <Currently Reading>
    #And I mark it as <Currently Reading>


  Scenario:Quiz
    When I select <Community> menu
    And I press om the <Quizzes> option
    Then I select <Guess the book> option


  Scenario Outline: Search for more books
    When I search for a book "<book>"
    Then the book is displayed
    Examples:
      |book                      |
      |Outlander                 |
      |Anne                      |

    @run_me
    Scenario: Complete my profile
      When I select my profile dropdown
      Then I can choose my favorite genres