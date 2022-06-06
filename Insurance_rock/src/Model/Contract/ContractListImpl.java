package Model.Contract;

import java.util.ArrayList;

public class ContractListImpl implements ContractList {
	private ArrayList<Contract> contractList;

	public ContractListImpl() {
		this.contractList = new ArrayList<Contract>();

	}

	public void finalize() throws Throwable {

	}

	public boolean add(Contract contract) {
		if (this.contractList.add(contract))
			return true;
		return false;

	}

	@SuppressWarnings("unlikely-arg-type")
	public boolean delete(String contractID) {
		if (this.contractList.remove(contractID))
			return true;
		return false;
	}

	public ArrayList<Contract> getAll() {
		return this.contractList;
	}

	public Contract getcheck(String customerName_inser, String phoneNum_inser) {
		for (Contract contract : this.contractList) {
			if (contract.getCustomerName().equals(customerName_inser)
					&& contract.getPhoneNum().equals(phoneNum_inser)) {
				return contract;
			}
		}
		return null;
	}
	

	@Override
	public Contract getCount(int select) {

		return this.contractList.get(select);
	}

//	public boolean update(){
//
//	}
	public Contract getNum(int num) {
		for (Contract contract : this.contractList) {
			if (contract.getNum() == num) {
				return contract;
			}
		}
		return null;
	}
	
	
//이거 세개 없애던가 해야함...
	@Override
	public Contract get(String name, String phoneNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Contract> getContractByNameAndNUm(String CustomerName, String CustomerPhoneNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contract get(int num) {
		// TODO Auto-generated method stub
		return null;
	}



	
}// end ContractListImpl