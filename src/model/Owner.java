package model;

public class Owner extends User{

	private String accountNumber;
	private String bankName;

	/**
	 * Owner: constructor of the owner class.
	 * @param idType user's identification type.
	 * @param identificationNumber user's number identification.
	 * @param name user's name.
	 * @param contactNumber user's contact number.
	 * @param typePhone user's type phone.
	 * @param accountNumber user's account number.
	 * @param bankName user's bank name.
	 * */

	public Owner(String idType, String identificationNumber, String name, String contactNumber, int typePhone, String accountNumber, String bankName){
		super(idType, identificationNumber, name, contactNumber, typePhone);
		this.accountNumber = accountNumber;
		this.bankName = bankName;
	}

	public String getAccountNumber(){
		return accountNumber;
	}

	public String getBankName(){
		return bankName;
	}
}