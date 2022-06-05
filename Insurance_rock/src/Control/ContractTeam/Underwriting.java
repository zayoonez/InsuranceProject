package Control.ContractTeam;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Model.Contract.Contract;
import Model.Contract.ContractList;
import Model.Contract.ContractListImpl;
import View.Team.ContractTeamTui;
import exception.WrongInputException;

public class Underwriting {

	public Contract contract;
	public ContractList contractList;
	public ContractTeamTui contractTeamTui;

	public Underwriting() {
		this.contractTeamTui = new ContractTeamTui();
		this.contract = new Contract();
		this.contractList = new ContractListImpl();
	}

	@SuppressWarnings("resource")
	public boolean selectUnderwrite() {

		Scanner scanner = new Scanner(System.in);
		int flag = -1;
		String selectList[] = new String[] { "1", "신규", "2", "갱신", "0", "취소" };
		this.contractTeamTui.showSelectContractMethods();
		while (flag == -1) {
			try {
				flag = getflag(selectList, scanner.next());

				if (flag == 1) {

					return selectApply(scanner);
				} else if (flag == 2) {

					return selectRenew(scanner);
				} else if (flag == 0) {
					this.contractTeamTui.showCancel();
					return true;
				}

			} catch (WrongInputException e) {
				System.err.println(e.getMessage());
			}
		}
		return false;

	}

	private int getflag(String[] selectList, String select) throws WrongInputException {
		for (int i = 0; i < selectList.length; i = i + 2) {
			if (selectList[i].equals(select) || selectList[i + 1].equals(select)) {
				return Integer.parseInt(selectList[i]);
			}
		}
		throw new WrongInputException();
	}

	private boolean selectApply(Scanner scanner) {
		ResultSet resultSet = this.contract.getApply();
		try {
			while (resultSet.next()) {
				Contract applyContract = new Contract();
				applyContract.setContractID(resultSet.getString("contractID"));
				applyContract.setCustomerID(resultSet.getString("customerID"));
				applyContract.setCustomerName(resultSet.getString("customerName"));
				applyContract.setPhoneNum(resultSet.getString("customerPhoneNum"));
				applyContract.setInsuranceID(resultSet.getString("insuranceID"));
				applyContract.setInsuranceName(resultSet.getString("insuranceName"));
				applyContract.setPaymentCycle(resultSet.getInt("paymentCycle"));
				applyContract.setInsuranceFee(resultSet.getInt("insuranceFee"));
				applyContract.setSecurityFee(resultSet.getInt("securityFee"));
				applyContract.setPeriod(resultSet.getInt("period"));
				this.contractList.add(applyContract);
			}

			if (this.contractList.getAll().isEmpty()) {
				this.contractTeamTui.showNoApplyContract();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		int length = showApply();
		this.contractTeamTui.showSelectApplyContract();

		int select = -1;

		while (length < select || select < 1) {
			try {
				select = checkNum(scanner);
			} catch (WrongInputException e) {
				System.err.println(e.getMessage());
			}
		}

		this.contract = this.contractList.getCount(select - 1);
		return selectVerify(scanner);

	}

	private int showApply() {
		this.contractTeamTui.showConractColumn();
		int length = 1;

		for (Contract contract : this.contractList.getAll()) {
			this.contractTeamTui.showContracts(length, contract);
			length++;
		}
		return length;
	}

	private int checkNum(Scanner scanner) throws WrongInputException {
		if (scanner.hasNextInt()) {
			return scanner.nextInt();
		}
		scanner.next();
		throw new WrongInputException();
	}

	private boolean selectVerify(Scanner scanner) {
		this.contractTeamTui.showSelectVerification();
		int flag = -1;
		String selectList[] = new String[] { "1", "검증", "2", "취소" };

		while (flag == -1) {
			try {
				flag = getflag(selectList, scanner.next());
			} catch (WrongInputException e) {
				System.err.println(e.getMessage());
			}
		}

		if (flag == 1) {
			UnderwritingNew underwritingNew= new UnderwritingNew();
			return underwritingNew.verifyInsurance(this.contract);
		} else if (flag == 2) {
			return true;
		}
		return false;
	}

	

	private boolean selectRenew(Scanner scanner) {
		// ResultSet resultSet = this.contract.getRenew();
		return false;
	}

}
