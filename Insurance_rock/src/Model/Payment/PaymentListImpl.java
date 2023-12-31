package Model.Payment;

import java.util.ArrayList;

public class PaymentListImpl implements PaymentList {

	private ArrayList<Payment> paymentList;

	public PaymentListImpl(){
		this.paymentList = new ArrayList<Payment>();
	}

	public void finalize() throws Throwable {

	}

	@Override
	public boolean add(Payment payment) {
		if(this.paymentList.add(payment)) return true;
		return false;
	}

	@Override
	public boolean delete(String paymentID) {
		if(this.paymentList.remove(paymentID)) return true;
		return false;
	}

	@Override
	public Payment get(String CustomerName, String CustomerPhoneNum) {
		for(Payment payment : this.paymentList) {
			if(payment.getCustomerName().equals(CustomerName) && payment.getCustomerPhoneNum().equals(CustomerPhoneNum)) return payment;
		}
		return null;
	}

	@Override
	public boolean update(String paymentID) {
		for(Payment payment : this.paymentList) {
			if(payment.getPaymentID().equals(paymentID)) {
				//update
				return true;
			}
		}
		return false;
	}


	@Override
	public ArrayList<Payment> getPaymentBySearch(String CustomerName, String CustomerPhoneNum) {
		// TODO Auto-generated method stub
		ArrayList<Payment> payments = new ArrayList<Payment>();
		for(Payment payment : this.paymentList) {
			if(payment.getCustomerName().equals(CustomerName)&&payment.getCustomerPhoneNum().equals(CustomerPhoneNum)) {
				payments.add(payment);
			}
		}
		if(!(payments.isEmpty())) {
			return payments;
		}
		return null;
	}

}//end PaymentImpl
