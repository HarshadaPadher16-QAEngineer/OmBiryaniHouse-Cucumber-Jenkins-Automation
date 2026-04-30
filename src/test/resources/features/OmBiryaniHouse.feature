Feature: Website Functional Testing
  In order to verify website functionality
  As a user
  I want to validate different features of the website

  Scenario: Verify Home Page loads successfully
    Given user opens the website URL "https://ombiryanihouse.wordpress.com"
    When the page is loaded
    Then homepage should be displayed successfully


  Scenario: Verify Navigation Menu links
    Given user is on the homepage
    When user clicks on "About" link
    Then about page should open

    When user clicks on "Contact" link
    Then Contact page should open

    When user clicks on "Blog" link
    Then Blog page should open

    When user clicks on "Privacy Policy" link
    Then Privacy Policy page should open


  Scenario: Verify Contact Form submission with valid data
    Given user is on Contact page
    When user enters name as "Harshada Padher"
    And user enters phone as "8888160236"
    And user enters email as "harshadapadher25@gmail.com"
    And user enters inquiry as "I want 3KG chicken biryani"
    And user clicks on submit button
    Then success message "your message has been sent" should be displayed



  Scenario: Verify Contact Form validation for empty fields
    Given user is on Contact page
    When user leaves all required fields blank
    And user clicks on submit button
    Then error message "Please fill in this field" should be displayed


  Scenario: Verify invalid email format validation
    Given user is on Contact page
    When user enters invalid email as "test@123"
    And user clicks on submit button
    Then error message for invalid email should be displayed


  Scenario: Verify website responsiveness on mobile device
    Given user opens website on mobile device "Redmi"
    When user navigates through the website
    Then content should adjust properly to screen size


  Scenario: Verify all images load properly
    Given user is on the homepage
    When user checks all images on the page
    Then all images should be visible properly