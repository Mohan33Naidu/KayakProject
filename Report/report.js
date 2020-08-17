$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("kayaktest.feature");
formatter.feature({
  "line": 1,
  "name": "Kayak Application Home",
  "description": "",
  "id": "kayak-application-home",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "TC01:Launch Kayak",
  "description": "",
  "id": "kayak-application-home;tc01:launch-kayak",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "Launch \"\u003cBrowser\u003e\" browser",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Launch \"\u003cUrl\u003e\" app",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "ValidateHomePage",
  "keyword": "Then "
});
formatter.examples({
  "line": 7,
  "name": "",
  "description": "",
  "id": "kayak-application-home;tc01:launch-kayak;",
  "rows": [
    {
      "cells": [
        "Browser",
        "Url"
      ],
      "line": 8,
      "id": "kayak-application-home;tc01:launch-kayak;;1"
    },
    {
      "cells": [
        "chrome",
        "https://www.kayak.com/"
      ],
      "line": 9,
      "id": "kayak-application-home;tc01:launch-kayak;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 9,
  "name": "TC01:Launch Kayak",
  "description": "",
  "id": "kayak-application-home;tc01:launch-kayak;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "Launch \"chrome\" browser",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Launch \"https://www.kayak.com/\" app",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "ValidateHomePage",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "chrome",
      "offset": 8
    }
  ],
  "location": "Stepdefinition.launch_browser(String)"
});
formatter.result({
  "duration": 3717530069,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.kayak.com/",
      "offset": 8
    }
  ],
  "location": "Stepdefinition.launch_app(String)"
});
formatter.result({
  "duration": 2894770593,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.validatehomepage()"
});
formatter.result({
  "duration": 700078629,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "TC02:Go to Flights Page",
  "description": "",
  "id": "kayak-application-home;tc02:go-to-flights-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "Click on Flights tab",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "Validate FlightPage",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdefinition.click_on_Flights_tab()"
});
formatter.result({
  "duration": 1454511215,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.validate_FlightPage()"
});
formatter.result({
  "duration": 1493936375,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "TC02 :Book Flight",
  "description": "",
  "id": "kayak-application-home;tc02-:book-flight",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "Enter Origin and Departure",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "Enter Departure Date and Return Dates",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "Click on Search",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdefinition.enter_Origin_and_Departure()"
});
formatter.result({
  "duration": 5744247857,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.enter_Departure_Date_and_Return_Dates()"
});
formatter.result({
  "duration": 4983476311,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.click_on_Search()"
});
formatter.result({
  "duration": 7630495104,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "TC03 : Select Result N on search results page",
  "description": "",
  "id": "kayak-application-home;tc03-:-select-result-n-on-search-results-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "Select Result N",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "Assert origin and destination details are same",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "Log all information of selected flight for reporting",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdefinition.select_Result_N()"
});
formatter.result({
  "duration": 1438127648,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.assert_origin_and_destination_details_are_same()"
});
formatter.result({
  "duration": 326083581,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.log_all_information_of_selected_flight_for_reporting()"
});
formatter.result({
  "duration": 1229645269,
  "status": "passed"
});
});