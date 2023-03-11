Feature: Validate create repository 

Scenario Outline: Verify create repo API 
	Given starting testcase "Verify create repo API" 
	Given create repo payload name "<name>" and description "<description>" 
	When user calls Create api "/user/repos" post api call 
	Then API call got successful with status code 201 
	Then verify Repository "name" is created "<name>" 
	Then verify repo description is "<description>" 
	And Ending Test case 
	
	Examples: 
		|name       |	description		|
		|Pravin-Repo|   My API Repo     |
		|Shruti-Repo|   Shruti API Repo |
		
Scenario Outline: Verify rename repository API
	Given starting testcase "Verify rename repository API" 
	Given create rename repo payload with new name "<newreponame>" 
	When user calls rename repo api "/repos/pravinsautomation/" call for oldrepo "<oldreponame>" 
	Then API call got successful with status code 200 
	Then verify Repository "name" is created "<newreponame>" 
	And Ending Test case 
	
	Examples: 
		|oldreponame       |   newreponame		      |
		|Pravin-Repo       |   Pravin-Repo_Renamed    |
		|Shruti-Repo       |   Shruti-Repo_Renamed    |
		
Scenario Outline: Verify delete create repo API 
	Given starting testcase "Verify delete repo API" 
	Given create repo payload name "<name>" and description "<description>" 
	When user calls Create API "/repos/pravinsautomation/" delete api call 
	Then API call got successful with status code 204 
	And Ending Test case 
	
	Examples: 
		|name                  |   description		|
		|Pravin-Repo_Renamed   |   My API Repo      |
		|Shruti-Repo_Renamed   |   Shruti API Repo  |		
		
	
	