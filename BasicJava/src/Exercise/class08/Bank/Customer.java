package Exercise.class08.Bank;

public class Customer {
	private String firstName;
	private String lastName;
	BankAccount[] account;
	private int numberOfAccounts;
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		account = new BankAccount[5];
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void addAccount(CheckingAccount account) {
		this.account[numberOfAccounts++] = account;
	}

	public void addAccount(SavingsAccount account) {
		this.account[numberOfAccounts++] = account;
	}

	public BankAccount getAccount(int index) {
		return account[index];
	}

	public void setAccount(BankAccount account[]) {
		this.account = account;
	}
	
	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	@Override
	public String toString() {
		return String.format("이름: %s %s, 계좌의 갯수: %s", firstName, lastName, numberOfAccounts);
	}

}
