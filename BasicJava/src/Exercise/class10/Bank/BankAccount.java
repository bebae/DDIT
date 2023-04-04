package Exercise.class10.Bank;

public abstract class BankAccount {
	private int balance;

	public BankAccount(int balance) {
		this.balance = balance;
	}

	public abstract String getAccountType();

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void deposit(int amount) {
		balance += amount;
	}

	public boolean withdraw(int amount) {
		if (balance >= amount) {
			balance -= amount;
			return true;
		}
		return false;
	}

	public boolean transfer(int amount, BankAccount otherAccount)  {
		if (amount < 0 || amount > balance) {
			throw new IllegalArgumentException();
		}
		if (withdraw(amount)) {
			balance -= amount;
			otherAccount.balance += amount;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("%d", balance);
	}
}
