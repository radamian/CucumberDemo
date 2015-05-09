package atm;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class WithdrawSteps {

	private static Account account;
	private static ATM atm = new ATM();
	private static Integer returnedAmount;

	@Given("^there is enough money on my account$")
	public void there_is_enough_money_on_my_account() throws Throwable {
		account = new Account(200);
	}

	@When("^I make a withdrawal$")
	public void i_make_a_withdrawal() throws Throwable {
		returnedAmount = atm.withdraw(account, 100);
	}

	@Then("^I get the expected amount of money from the ATM$")
	public void i_get_the_expected_amount_of_money_from_the_ATM()
			throws Throwable {
		assertThat(returnedAmount, is(100));
	}

	@Given("^there is a lack of money on my account$")
	public void there_is_a_lack_of_money_on_my_account() throws Throwable {
		account = new Account(50);
	}

	@Then("^I get no money from the ATM$")
	public void i_get_no_money_from_the_ATM() throws Throwable {
		assertThat(returnedAmount, is(0));
	}
}
