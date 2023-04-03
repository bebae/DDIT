package Exercise.class08.Bank;

public class SavingsAccount extends BankAccount {
	private double interestRate;

	public SavingsAccount(int balance, double interestRate) {
		super(balance);
		this.interestRate = interestRate;
	}
	
	public void updateBalance(int period) {
		setBalance((int) (double) (getBalance() * interestRate * period + getBalance()));
	}

	@Override
	public String getAccountType() {
		return "저축예금";
	}
}
