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
		
	
	