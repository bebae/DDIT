package Exercise.class07;

public class BankAccount2 {
	protected int balance;

	public BankAccount2(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}
	public void deposit(int amount) {
		balance += amount;
	}
	public boolean withdraw(int amount) {
		if (balance - amount < 0) {
			return false;
		} else {
			balance -= amount;
			return true;
		}
		
	}
	public boolean transfer(int amount, BankAccount2 otherAccount) {
		if (balance >= amount) {
			balance -= amount;
			otherAccount.balance += amount;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("현재 잔액: %s", balance);
	}
	
}
