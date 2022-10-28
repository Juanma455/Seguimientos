package model;

public class Tenant extends User{

	/**
	 * Tenant: constructor of the tenant class.
	 * @param idType user's identification type.
	 * @param identificationNumber user's number identification.
	 * @param name user's name.
	 * @param contactNumber user's contact number.
	 * @param typePhone user's type phone.
	 * */

	public Tenant(String idType, String identificationNumber, String name, String contactNumber, int typePhone){
		super(idType, identificationNumber, name, contactNumber, typePhone);
	}
}