package atm;

public class ATM {

	public int withdraw(Account account, Integer amount){
		account.withdraw(amount);
		return amount;
	}
}
