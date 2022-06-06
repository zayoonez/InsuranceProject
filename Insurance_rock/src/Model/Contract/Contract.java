package Model.Contract;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.UUID;

import Model.DB.ApplyContractDao;
import Model.DB.ContractDao;

public class Contract {

	private String customerID;
	private String customerName;
	private String phoneNum;
	private String insuranceID;
	private String insuranceName;
	private String contractID;
	private int insuranceFee;
	private int paymentCycle;
	private int provisionFee;
	private int securityFee;
	private int period;
	private LocalDate startDate;
	private LocalDate endDate;
	private int unpaidFee;
	private ContractDao contractDao;
	private ApplyContractDao applyContractDao;
	private int num;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Contract() {
		this.contractDao = new ContractDao();
		this.applyContractDao = new ApplyContractDao();
		this.contractID = UUID.randomUUID().toString();
	}

	public Contract(String contract) {
		
		
	}

	public void finalize() throws Throwable {

	}

	public void apply() {

	}

	public void reapply() {

	}

	public void cancelContract() {

	}

	public void checkUnpaidFee() {

	}

	public void updatePayment() {

	}

	public void renew() {
		//갱신 내용 적고 저장
	}
	
	public void permit() {
		// Customer customer = new Customer(); 고객 정보 저장
		// 계약 정보 저장

	}

	public void allowRenew() {
		// DB에 갱신 정보 저장
	}

	

	public void underwrite() {
		// 심사 대기 DB에서 받아옴

	}

	public void verify() {
		// 보험료 검증
	}

	public void verifyRenew() {
		// 보험료 검증
	}

	public void search() {

	}

	public String getContractID() {
		return contractID;
	}

	public void setContractID() {
		this.contractID = UUID.randomUUID().toString();
	}
	
	public void setContractID(String contractID) {
		this.contractID = contractID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getInsuranceFee() {
		return insuranceFee;
	}

	public void setInsuranceFee(int insuranceFee) {
		this.insuranceFee = insuranceFee;
	}

	public String getInsuranceID() {
		return insuranceID;
	}

	public void setInsuranceID(String insuranceID) {
		this.insuranceID = insuranceID;
	}

	public int getPaymentCycle() {
		return paymentCycle;
	}

	public void setPaymentCycle(int paymentCycle) {
		this.paymentCycle = paymentCycle;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getProvisionFee() {
		return provisionFee;
	}

	public void setProvisionFee(int provisionFee) {
		this.provisionFee = provisionFee;
	}

	public int getSecurityFee() {
		return securityFee;
	}

	public void setSecurityFee(int securityFee) {
		this.securityFee = securityFee;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public int getUnpaidFee() {
		return unpaidFee;
	}

	public void setUnpaidFee(int unpaidFee) {
		this.unpaidFee = unpaidFee;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}


	public ResultSet retrivecontract() {
		return contractDao.retrivecontract(this.getCustomerName(), this.getPhoneNum());
		
	}
	public void register() {
		this.contractDao = new ContractDao();
	}
	
	public void registerApplyContract() {
		this.applyContractDao = new ApplyContractDao();
		this.applyContractDao.create(this);
	}

	public ResultSet retrivelongtermFee() {
		this.contractDao = new ContractDao();
		return this.contractDao.retrivelongtermFee(this);
	}

	public void updateProvisionFee() {
		this.contractDao = new ContractDao();
		this.contractDao.updateProvisionFee(this);
		
	}

	public ResultSet getContract() {
		this.contractDao = new ContractDao();
		return this.contractDao.retrive();
	}

	public boolean updateUnpaidFee(int newUnpaidFee, String contractID) {
		// TODO Auto-generated method stub
		this.contractDao = new ContractDao();
		return this.contractDao.updateUnpaidFee(newUnpaidFee, contractID);
	}


}// end Contract