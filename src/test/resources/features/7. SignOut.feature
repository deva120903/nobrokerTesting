Feature: Sign out from the website of Nobroker

	@Login
  Scenario: TS_SIGNOUT_16 User navigate to the last stage and sign out from website
	Given User in the final stage
	When User click on sign out
	Then User end all the process on the website