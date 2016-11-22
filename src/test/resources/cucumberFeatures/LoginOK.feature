Feature: LoginOK
Verify login process	

@LoginOK
Scenario: LoginOK
Given User navigates to MercuryTours Home Page
When User enter valid user name
And User enter valid password
And User cliks Sign-In button
Then Flight Finder page is displayed



