package Model.Customer;

public interface CustomerList {

	public void finalize() throws Throwable;
	
	public boolean add(Customer customer);
	
	public boolean delete(String customerID);

	public boolean edit(String customerID);

	public Customer search(String name, String phoneNum);

	boolean editInsuranceNum(String customerID);


}//end CustomerList