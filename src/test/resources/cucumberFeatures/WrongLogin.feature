Feature: WrongLogin
Verify reject login process

@WrongLogin
Scenario: WrongLogin
Given User navigates to MercuryTours Home Page
When User enter wrong user name
And User enter valid password
And User cliks Sign-In button
Then Sign-on page is displayed

