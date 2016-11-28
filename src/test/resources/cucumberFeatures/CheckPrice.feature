Feature: Check Price
Verify displayed price is right

@CheckPrice
Scenario: BookFlightPage
Given User is on Select Flight Page
When User select Blue Skies Airlines 341 outbound flight
And User select Pangea Airlines 432 return flight
And User clicks Select Flight Continue button
Then Book a Flight page is displayed

@CheckPrice
Scenario: CheckTotalPrice
Given User is on Select Flight Page
When User select Blue Skies Airlines 341 outbound flight
And User select Pangea Airlines 432 return flight
And User clicks Select Flight Continue button
Then Total Price (including taxes) is $883

@CheckPrice
Scenario: CheckTax
Given User is on Select Flight Page
When User select Blue Skies Airlines 341 outbound flight
And User select Pangea Airlines 432 return flight
And User clicks Select Flight Continue button
And Taxes is $67