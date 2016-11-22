Feature: Flights from New York to Paris
Verify that flights form New York to Paris are available

@FindNewYorkToParisFlight
Scenario: FindNewYorkToParisFlight
Given User is on Flight Finder Page
When User select departure from New York
And User select arrival to Paris
And User clicks Continue button
Then Select Flight page is displayed
And New York is selected as departure city
And Paris is selected as arrival city

