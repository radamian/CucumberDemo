package atm;

public class Account {

	private Integer balance;

	public Account(Integer amount){
		this.balance = amount;
	}

	public void withdraw(Integer amount){
		this.balance -= amount;
	}
}
