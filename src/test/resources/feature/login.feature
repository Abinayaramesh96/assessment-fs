Feature: Login

  As a user, I want to be able to login to the application with my registered username and password.

  Scenario: Login with registered username and password

    Given user on the landing page URL "https://tutorialsninja.com/demo/index.php?route=account/login"
    When user enter valid "fedcba@gmail.com" and valid "123456"
    And user click on the login button
    Then user should be logged in  and page title should be "My Account"

  Scenario: Login with invalid username and password
    Given user launch landing page URL "https://tutorialsninja.com/demo/index.php?route=account/login"
    When user enter invalid username "abinayarameshmailbox@gmail.com" and invalid password "123456"
    And click on the login button
    Then user should see an error message "Warning: No match for E-Mail Address and/or Password."
