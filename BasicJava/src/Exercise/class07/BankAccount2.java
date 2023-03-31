package Exercise.class07;

public class BankAccount2 {
	protected int balance;

	public BankAccount2(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}
	/**
	 * 예금(입금)
	 * @param amount
	 */
	public void deposit(int amount) {
		balance += amount;
	}
	/**
	 * 출금
	 * @param amount
	 * @return boolean형
	 */
	public boolean withdraw(int amount) {
		if (balance >= amount) {
			balance -= amount;
			return true;
		}
			return false;
	}
	/**
	 * 이체
	 * @param amount 이체금액 (이체금액이 현재 잔액보다 클 수 없다.)
	 * @param otherAccount 이체할 계좌번호
	 * @return
	 */
	public boolean transfer(int amount, BankAccount2 otherAccount) {
		if (withdraw(amount)) {
			balance -= amount;
			otherAccount.balance += amount;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("현재 잔액: %,d", balance);
	}
	
}
