Feature:Kayak Application Home

Scenario Outline: TC01:Launch Kayak
Given Launch "<Browser>" browser
When Launch "<Url>" app
Then ValidateHomePage
Examples: 
|Browser|Url|
|chrome|https://www.kayak.com/|

Scenario: TC02:Go to Flights Page
Given Click on Flights tab
Then Validate FlightPage

Scenario: TC02 :Book Flight
Given Enter Origin and Departure
When Enter Departure Date and Return Dates
Then Click on Search

Scenario: TC03 : Select Result N on search results page
Given Select Result N
When Assert origin and destination details are same
Then Log all information of selected flight for reporting

