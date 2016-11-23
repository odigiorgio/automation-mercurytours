Feature: Check Price
Verify displayed price is right

@CheckPrice
Scenario: CheckPrice
Given User is on Select Flight Page
When User select Blue Skies Airlines 341 outbound flight
And User select Pangea Airlines 432 return flight
And User clicks Select Flight Continue button
Then Book a Flight page is displayed
And Total Price (including taxes) is $942

