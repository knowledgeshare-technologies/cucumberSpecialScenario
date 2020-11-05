Feature: This is sample feature
#@TestOne
#Scenario: This is sample Scenario
#Given This is my test one
#Then This is my test two
#And This is my test three

@Testtwo
Scenario Outline: This is Special Scenario
Given I add payload with "<VehicleData>" and then get asyncquotes api payload with "<PolicyData>"
When user calls api
Then api call is success
And message in response body success
And status in response body "200"
And get asyncquote
And user calls getquotesapi
And api call is success with code "200"
Examples:
		|VehicleData|PolicyData|
	|VehicleTestData1|PolicyTestData1|
	|VehicleTestData2|PolicyTestData2|
	|VehicleTestData3|PolicyTestData3|

	