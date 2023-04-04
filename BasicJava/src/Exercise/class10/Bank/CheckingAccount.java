package Exercise.class10.Bank;

public class CheckingAccount extends BankAccount {
	SavingsAccount protectedBy = new SavingsAccount(0, 0);

	public CheckingAccount(int balance) {
		super(balance);
	}

	@Override
	public String getAccountType() {
		return "당좌예금";
	}

	public CheckingAccount(int balance, SavingsAccount protectedBy) {
		super(balance);
		this.protectedBy = protectedBy;
	}
	
	public boolean withdraw(int amount) {
		if (amount > getBalance()) {
			protectedBy.setBalance(protectedBy.getBalance() - (amount - getBalance()));
			setBalance(0);
		} else {
			setBalance(getBalance() - amount);
		}
		return true;
	}
}
