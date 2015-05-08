Feature: Withdraw money
    In order to avoid going to the bank
    As a customer
    I want to withdraw money from an ATM

    Scenario: Withdraw less money than the account has
        Given there is enough money on my account 
        When I make a withdrawal 
        Then I get the expected amount of money from the ATM

    Scenario: Withdraw more money than the account has
        Given there is a lack of money on my account 
        When I make a withdrawal 
        Then I get no money from the ATM