package Model.Payment;

import java.util.ArrayList;

import Model.Contract.Contract;

public interface PaymentList {


	public void finalize() throws Throwable;
	
	public boolean add(Payment payment);
	public boolean delete(String paymentID);
	public boolean update(String paymentID);
	public Payment get(String CustomerName, String CustomerPhoneNum);
	public ArrayList<Payment> getPaymentBySearch(String CustomerName, String CustomerPhoneNum);

}//end PaymentList