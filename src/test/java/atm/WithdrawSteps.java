package atm;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WithdrawSteps {

	@Given("^there is enough money on my account$")
	public void there_is_enough_money_on_my_account() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^I make a withdrawal$")
	public void i_make_a_withdrawal() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I get the expected amount of money from the ATM$")
	public void i_get_the_expected_amount_of_money_from_the_ATM()
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Given("^there is a lack of money on my account$")
	public void there_is_a_lack_of_money_on_my_account() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I get no money from the ATM$")
	public void i_get_no_money_from_the_ATM() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}
}
