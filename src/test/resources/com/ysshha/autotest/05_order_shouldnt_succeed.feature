Feature: Successful inputting wrong orders
	Enter several orders with questionable input (after scenario 3 or 4)

    Scenario: Obviously those pass and card numbers, should be numbers
		Given I start browser 
    	And I load url "http://localhost:8080/"
		And I check Homepage
		When I fill in an order with Card: "Can I try" , Pass: "a negative amount ?" , for Amount: "-1000"
		Then I see Create is enabled
		And I push Create
		And I close page
		Given I start browser
		And I load url "http://localhost:8080/"
		And I see that the list has 6 orders
		When I fill in an order with Card: "Why not" , Pass: "negative zero ? " , for Amount: "-0"
		Then I see Create is enabled
		And I push Create
		And I close page
		Given I start browser
		When I load url "http://localhost:8080/"
		Then I see that the list has 7 orders
