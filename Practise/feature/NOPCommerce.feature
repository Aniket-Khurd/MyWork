Feature: NOP Commerce Feature 

Scenario: Add a new Customer 

	Given User Launch Chrome browser 
	When User opens URL "https://admin-demo.nopcommerce.com/login" and page title is "Your store. Login"
	And User enters email as "admin@yourstore.com" and password as "admin" 
	And clicks on login 
	Then User can view Dashboard and title is "Dashboard / nopCommerce administration"
	When User clicks on customers menu 
	And click on Customers menu item 
	And click on Add new buttton 
	Then User can View Add new Customer page and title is "Add a new customer / nopCommerce administration"
	When User enter customer info 
	And clicks on Save button 
	Then user can view confirmation message "The new customer has been added successfully." 
	And close browser