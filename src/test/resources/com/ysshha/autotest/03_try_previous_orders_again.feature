Feature: Multiple hopefully successful orders from a scenario outline
	Changed orders to succeed, following scenario 02. Should have 5 orders at the end

    Scenario Outline: App can only deal with whole numbers amount
		Given I start browser
		And I load url "http://localhost:8080/"
		And I check Homepage
		And I fill in an order with Card: <card> , Pass: <pass> , for Amount: <amount>
		And I see Create is enabled
		When I push Create

		Examples:
			|	card		|	pass		|	amount	|
			|	"3"			|	"88"		|	"4"	|
			|	"4"			|	"669"		|	"1000"	|
			|	"5"			|	"8"			|	"3000"|

