Feature: Application Login

Scenario: Login with valid credentials
Given Open any Browser
And Navigate to Login page
When User enters username as "selenium.tom2@gmail.com" and password as "qwerty" into the fields
And User clicks on Login button
Then Verify user is able to successfully login