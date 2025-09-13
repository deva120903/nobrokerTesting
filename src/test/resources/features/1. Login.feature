Feature: User Login

 Scenario: TS_LOGIN_01 Login with invalid mobile number
    Given the user is on the login page
    When the user enters a invalid phone number 
    Then an invalid number message should be shown

  Scenario: : TS_LOGIN_02 Login with invalid OTP
    Given the user is on the login page
	When the user enters a valid phone number
	And the user enters the invalid OTP
    Then an invalid otp message should be shown
    
  Scenario: TS_LOGIN_03 OTP Expiry and Resend
    Given the user is on the login page
    When the user enters a valid phone number
    And waits until the OTP expires and clicks on resend button
    And the user enters the valid OTP
    Then the user should be logged in successfully

  Scenario: TS_LOGIN_04 Page loaded successfully
    Given the user is on the login page
    Then the login page should be loaded successfully
    
  Scenario: TS_LOGIN_05 Login with valid credentials
    Given the user is on the login page
    When the user enters a valid phone number
	And the user enters the valid OTP
    Then the user should be logged in successfully