package Exercise.class07;

public class Bank{

	private Customer[] customers;
	private int numberOfCustomers;
	
	public Bank() {
		this.customers = new Customer[10];
	}
	
	public void addCustomer(Customer customer) {
		this.customers[numberOfCustomers++] = customer;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	
	public Customer getCustomer(int index) {
		return this.customers[index];
	}
	
}
