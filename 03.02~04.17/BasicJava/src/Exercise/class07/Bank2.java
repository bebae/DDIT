package Exercise.class07;

public class Bank2{

	private Customer2[] customers;
	private int numberOfCustomers;
	
	public Bank2() {
		this.customers = new Customer2[10];
	}
	
	public void addCustomer(Customer2 customer) {
		this.customers[numberOfCustomers++] = customer;
	}

	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	
	public Customer2[] getCustomers() {
		return customers;
	}

	public Customer2 getCustomer(int index) {
		return this.customers[index];
	}
	
}
