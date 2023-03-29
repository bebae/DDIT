package Exercise.class07;

public class SavingsAccount extends BankAccount2{
	private double intersetRate;

	public SavingsAccount(int balance, double intersetRate) {
		super(balance);
		this.intersetRate = intersetRate;
	}
	
	public void updateBalance(int period) {
		balance = (int)(double)(balance * intersetRate * period + balance);
	}
}
