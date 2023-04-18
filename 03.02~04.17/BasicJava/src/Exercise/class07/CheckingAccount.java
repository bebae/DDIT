package Exercise.class07;

public class CheckingAccount extends BankAccount2 {
	SavingsAccount protectedBy = new SavingsAccount(0, 0);

	public CheckingAccount(int balance) {
		super(balance);
	}
	public CheckingAccount(int balance, SavingsAccount protectedBy) {
		super(balance);
		this.protectedBy = protectedBy;
	}
	
	public boolean withdraw(int amount) {
		if (amount > balance) {
			protectedBy.balance -= amount-balance;
			balance = 0;
		} else {
			balance -= amount;
		}
		return true;
	}
	
}
