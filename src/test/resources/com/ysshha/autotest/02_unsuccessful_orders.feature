Feature: Multiple unsuccessful orders from a scenario outline
	More orders, following scenario 01

    Scenario Outline: App can't deal with comma's in amount (why?)
		Given I start browser
		And I load url "http://localhost:8080/"
		And I check Homepage
		When I fill in an order with Card: <card> , Pass: <pass> , for Amount: <amount>
		Then I see Create is enabled
		And I push Create

		Examples:
			|	card		|	pass		|	amount	|
			|	"3"			|	"88"		|	"0,99"	|
			|	"4"			|	"669"		|	"10,55"	|
			|	"5"			|	"8"			|	"3000,00"|

