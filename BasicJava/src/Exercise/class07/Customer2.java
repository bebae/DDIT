package Exercise.class07;

public class Customer2 {
	private String firstName;
	private String lastName;
	BankAccount2[] account;
	private int numberOfAccounts;
	
	public Customer2(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		account = new BankAccount2[5];
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
	
	public void addAccount(BankAccount2 account) {
		this.account[numberOfAccounts++] = account;
	}

	public BankAccount2 getAccount(int index) {
		return account[index];
	}

	public void setAccount(BankAccount2 account[]) {
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
