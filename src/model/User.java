package model;

public abstract class User{

	private String idType;
	private String identificationNumber;
	private String name;
	private String contactNumber;
	private TypePhone typePhone;
	private int properties;

	/**
	 * User: constructor of the User father class.
	 * @param idType user's identification type.
	 * @param identificationNumber user's number identification.
	 * @param name user's name.
	 * @param contactNumber user's contact number.
	 * @param typePhone user's type phone.
	 * */

	public User(String idType, String identificationNumber, String name, String contactNumber, int typePhone){
		this.idType = idType;
		this.identificationNumber = identificationNumber;
		this.name = name;
		this.contactNumber = contactNumber;
		properties = 0;

		switch(typePhone){
		case 1:
			this.typePhone = TypePhone.HOME;

		case 2: 
			this.typePhone = TypePhone.OFFICE;

		case 3:
			this.typePhone = TypePhone.MOVIL;

		case 4:
			this.typePhone = TypePhone.FAMILY;

		case 5:
			this.typePhone = TypePhone.OTHER;
		}
	}

	public String getIdType(){
		return idType;
	}

	public int getProperties(){
		return properties;
	}

	public String getIdentificationNumber(){
		return identificationNumber;
	}

	public String getName(){
		return name;
	}

	public String getContactNumber(){
		return contactNumber;
	}

	public TypePhone getTypePhone(){
		return typePhone;
	}
}