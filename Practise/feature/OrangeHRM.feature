Feature: Orange HRM Feature 

Scenario: Orange HRM Login 

	Given User launch Chrome browser 
	When User opens url "https://opensource-demo.orangehrmlive.com/" 
	Then Page title is "OrangeHRM" 
	Then User enters username as "Admin" and password as "admin123" 
	And User clicks on login button 
	Then User should be on Home page 
	Then User clicks on logout link 
	Then User should be on login page 
	Then User closes the browser 
	
	
Scenario Outline: Orange HRM invalid login

	Given User launch Chrome browser 
	When User opens url "https://opensource-demo.orangehrmlive.com/" 
	Then Page title is "OrangeHRM" 
	Then User enters username as "<username>" and password as "<password>" 
	And User clicks on login button 
	Then User fails to login and invalid credentials message is displayed as "Invalid credentials" 
	Then User closes the browser 
	
	Examples: 
		| username | password |
		| agnelo   | agnelo123|
		| crystle  | crystle  |