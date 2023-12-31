package Model.Provision;

import java.util.ArrayList;

/**
 * @author ansm6
 * @version 1.0
 * @created 08-5-2022 ���� 10:34:19
 */
public class ProvisionListImpl implements ProvisionList {

	private ArrayList<Provision> provisionList = new ArrayList<Provision>();
//	public Provision m_Provision;

	public ProvisionListImpl(){
		
	}

	public void finalize() throws Throwable {

	}

	@Override
	public boolean add(Provision provision) {
		if(this.provisionList.add(provision)) return true;
		return false;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public boolean delete(String provisionID) {
		if(this.provisionList.remove(provisionID)) return true;
		return false;
	}

	@Override
	public Provision get(String provisionID) {
		for(Provision provision : this.provisionList) {
			if(provision.getProvisionID().equals(provisionID)) return provision;
		}
		return null;
	}

	@Override
	public boolean update(String provisionID) {
		for(Provision provision : this.provisionList) {
			if(provision.getProvisionID().equals(provisionID)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Provision get(String name, String phoneNum) {
		for (Provision provision : this.provisionList) {
			if(provision.getCustomerName().equals(name) && provision.getPhoneNum().equals(phoneNum)) {
				return provision;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Provision> getProvisionBySearch(String name, String phoneNum) {
		ArrayList<Provision> provisions = new ArrayList<Provision>();
		for(Provision provision : this.provisionList) {
			if(provision.getCustomerName().equals(name) && provision.getPhoneNum().equals(phoneNum)) {
				provisions.add(provision);
			}
		}
		if(!(provisions.isEmpty())) { 
			return provisions;
		}
		return null;
	}
	

}//end ProvisionListImpl