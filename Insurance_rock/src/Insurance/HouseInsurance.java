package Insurance;

/**
 * @author ansm6
 * @version 1.0
 * @created 08-5-2022 ���� 10:34:18
 */
public class HouseInsurance extends Insurance {

	private int housePremiumRate;

	public HouseInsurance(boolean longTerm){
		super(EInsurance.house, longTerm);
	}
	public HouseInsurance(){
		super(EInsurance.house);
	}
	
	public void finalize() throws Throwable {
		super.finalize();
	}
	public void measureStandardFee(){
		this.setStandardFee(10000);
	}

	public void verifyPremium(){

	}
}//end houseInsurance