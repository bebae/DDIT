package Exercise.class07;

public class BankTest2 {
	public static void main(String[] args) {
		Bank2 bank = new Bank2();

		Customer2 customer1 = new Customer2("Tony", "Stark");
		SavingsAccount customer1SavingsAccount = new SavingsAccount(2000, 0.01);
		customer1.addAccount(customer1SavingsAccount);
		customer1.addAccount(new CheckingAccount(3000, customer1SavingsAccount));
		bank.addCustomer(customer1);

		Customer2 customer2 = new Customer2("Peter", "Parker");
		customer2.addAccount(new CheckingAccount(2000));
		bank.addCustomer(customer2);

		Customer2 customer3 = new Customer2("Steve", "Rogers");
		SavingsAccount customer3SavingsAccount = new SavingsAccount(2000, 0.03);
		customer3.addAccount(customer3SavingsAccount);
		customer3.addAccount(new CheckingAccount(1000, customer3SavingsAccount));
		bank.addCustomer(customer3);

		System.out.println(customer3.getFirstName() + "의 SavingsAccount 잔고: " + customer3.getAccount(0) + "원");
		System.out.println(customer3.getFirstName() + "의 CheckingAccount 잔고: " + customer3.getAccount(1) + "원");
		System.out.println();
		System.out.println("새로운 withdraw 메소드 실험(1,400원 인출)");
		customer3.getAccount(1).withdraw(1400);
		System.out.println(customer3.getFirstName() + "의 SavingsAccount 잔고: " + customer3.getAccount(0) + "원");
		System.out.println(customer3.getFirstName() + "의 CheckingAccount 잔고: " + customer3.getAccount(1) + "원");

		System.out.println();
		printCustomers(bank.getCustomers());
		// 10개월 후의 이자 계산
		for (Customer2 c : bank.getCustomers()) {
			if (c != null) {
				for (int i = 0; i < c.getNumberOfAccounts(); i++) {
					if (c.getAccount(i) instanceof SavingsAccount) {
						((SavingsAccount) c.getAccount(i)).updateBalance(10);
					}
				}
			}
		}
		System.out.println("10개월 후 잔액");
		printCustomers(bank.getCustomers());
	}

	private static void printCustomers(Customer2[] customers) {
		for (Customer2 c : customers) {
			if (c != null) {
				System.out.println(c);
				for (int i = 0; i < c.getNumberOfAccounts(); i++) {
					System.out.println("계좌 종류: " + c.getAccount(i).getClass().getSimpleName() + ", 잔고: " + c.getAccount(i) + "원");
				}
				System.out.println();
			}
		}
	}
}
