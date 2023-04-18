package Exercise.class10.Bank;

public class Bank {

	private Customer[] customers;
	private int numberOfCustomers;
	
	public Bank() {
		this.customers = new Customer[10];
	}
	
	public void addCustomer(Customer customer) {
		this.customers[numberOfCustomers++] = customer;
	}

	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	
	public Customer[] getCustomers() {
		return customers;
	}

	public Customer getCustomer(int index) {
		return this.customers[index];
	}
	
}
