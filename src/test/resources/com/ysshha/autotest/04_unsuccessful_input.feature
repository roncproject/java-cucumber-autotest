Feature: Multiple invalid input
	Various invalid input in the add screen is rejected

	Scenario Outline: This invalid input rejection makes sense
		Given I start browser
		And I load url "http://localhost:8080/"
		When I fill in an order with Card: <card> , Pass: <pass> , for Amount: <amount>
		Then I see Create is disabled

		Examples:
			|	card		|	pass		|	amount	|
			|	""			|	""			|	""		|
			|	"1"			|	""			|	""		|
			|	""			|	"2"			|	""		|
			|	""			|	""			|	"3"		|
			|	"1"			|	"2"			|	""		|
			|	""			|	"2"			|	"3"		|
			|	"1"			|	""			|	"3"		|
