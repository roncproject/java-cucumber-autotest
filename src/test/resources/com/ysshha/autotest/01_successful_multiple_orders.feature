Feature: Successful multiple orders
	Enter several orders

    Scenario: One, and another
		Given I start browser 
    	And I load url "http://localhost:8080/"
		And I check Homepage
		When I fill in an order with Card: "1" , Pass: "01" , for Amount: "100"
		Then I see Create is enabled
		And I push Create
		And I close page
		Given I start browser
		And I load url "http://localhost:8080/"
		And I see that the list has 1 orders
		When I fill in an order with Card: "2" , Pass: "99" , for Amount: "1000"
		Then I see Create is enabled
		And I push Create
		And I close page
		Given I start browser
		When I load url "http://localhost:8080/"
		Then I see that the list has 2 orders
