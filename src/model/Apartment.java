package model;

public class Apartment{

	private String id;
	private int numberOfRooms;
	private int numberOfBathrooms;
	private int balcony;
	private double leaseValue;
	private Apartment[] apartments;
	private Owner[] owners;
	private Tenant[] tenants;

	public static final int SIZE_OF_USERS = 20;
	public static final int SIZE_OF_APARTMENTS = 10;

	/**
	 * Apartment: apartment class constructor.
	 * @param id apartment identifier.
	 * @param numberOfRooms number of rooms in the apartment.
	 * @param numberOfBathrooms number of bathrooms in the apartment.
	 * @param balcony the balcony has or does not have a balcony.
	 * @param leaseValue rental value of the apartment.
	 * */

	public Apartment(String id, int numberOfRooms, int numberOfBathrooms, int balcony, double leaseValue){
		this.id = id;
		this.numberOfRooms = numberOfBathrooms;
		this.numberOfBathrooms = numberOfBathrooms;
		this.balcony = balcony;
		this.leaseValue = leaseValue;
		apartments = new Apartment[SIZE_OF_APARTMENTS];
		owners = new Owner[SIZE_OF_USERS];
		tenants = new Tenant[SIZE_OF_USERS];
	}

	public String getId(){
		return id;
	}

	public int getNumberOfRooms(){
		return numberOfRooms;
	}

	public int getNumberOfBathrooms(){
		return numberOfBathrooms;
	}

	public int balcony(){
		return balcony;
	}

	public double getLeaseValue(){
		return leaseValue;
	}

	/**
	 * countOwners: it does a total walk through the list of owners to count those who have an apartment.
	 * @param name owner name.
	 * @return message with the apartment accountant.
	 * */

	public String countOwners(String name){
		String msj = "";
		int count = 0;
		int posOwner = searchOwnerByName(name);
		for(int i = 0; i < SIZE_OF_USERS; i++){
			if(owners[posOwner] != null){
				count++;
				count += owners[posOwner].getProperties();
				msj = "El propietario tiene " + count + " apartamentos.";
			}
		}
		return msj;
	}

	/**
	 * searchOwnerByName: look for an owner by name to give his position.
	 * @param name owner name.
	 * @return position in the wanted owner.
	 * */

	public int searchOwnerByName(String name){
		int pos = -1;
		boolean isFound = false;
		for(int i = 0; i < SIZE_OF_USERS && !isFound; i++){
			if(owners[i] != null && owners[i].getName().equals(name)){
				pos = i;
				isFound = true;
			}
		}
		return pos;
	}

	/**
	 * addOwner: adds a new owner to the first empty position in the array.
	 * @param idType user's identification type.
	 * @param identificationNumber user's number identification.
	 * @param name user's name.
	 * @param contactNumber user's contact number.
	 * @param typePhone user's type phone.
	 * @param accountNumber user's account number.
	 * @param bankName user's bank name.
	 * @return confirmation message about creating the owner.
	 * */

	public String addOwner(String idType, String identificationNumber, String name, String contactNumber, int typePhone, String accountNumber, String bankName){
		String msj = "El apartamento ya tiene un propietario.";
		Owner newOwner = new Owner(idType, identificationNumber, name, contactNumber, typePhone, accountNumber, bankName);
		boolean isEmpty = false;
		for(int i = 0; i < SIZE_OF_USERS && !isEmpty; i++){
			if(owners[i] == null){
				owners[i] = newOwner;
				msj = "Propietario agregado.";
			}
		}
		return msj;
	}

	/**
	 * addTenant: adds a new tenant to the first empty position in the array.
	 * @param idType user's identification type.
	 * @param identificationNumber user's number identification.
	 * @param name user's name.
	 * @param contactNumber user's contact number.
	 * @param typePhone user's type phone.
	 * @return confirmation message about creating the tenant.
	 * */

	public String addTenant(String idType, String identificationNumber, String name, String contactNumber, int typePhone){
		String msj = "El apartamento ya tiene un arrendatario.";
		Tenant newTenant = new Tenant(idType, identificationNumber, name, contactNumber, typePhone);
		boolean isEmpty = false;
		for(int i = 0; i < SIZE_OF_USERS && !isEmpty; i++){
			if(tenants[i] == null){
				tenants[i] = newTenant;
				isEmpty = true;
				msj = "Arrendatario agregado.";
			}
		}
		return msj;
	}

	/**
	 * hasEmptyOwnerPos: validate that a position in the array is empty.
	 * @return boolean condition on whether a position is empty.
	 * */

	public boolean hasEmptyOwnerPos(){
		boolean isEmpty = false;
		for(int i = 0; i < SIZE_OF_USERS && !isEmpty; i++){
			if(owners[i] == null){
				isEmpty = true;
			}
		}
		return isEmpty;
	}

	/**
	 * hasEmptyTenantPos: validate that a position in the array is empty.
	 * @return boolean condition on whether a position is empty.
	 * */

	public boolean hasEmptyTenantPos(){
		boolean isEmpty = false;
		for(int i = 0; i < SIZE_OF_USERS && !isEmpty; i++){
			if(tenants[i] == null){
				isEmpty = true;
			}
		}
		return isEmpty;
	}

	/**
	 * hasEmptyApartmentPos: validate that a position in the array is empty.
	 * @return boolean condition on whether a position is empty.
	 * */

	public boolean hasEmptyApartmentPos(){
		boolean isEmpty = false;
		for(int i = 0; i < SIZE_OF_APARTMENTS && !isEmpty; i++){
			if(apartments[i] == null){
				isEmpty = true;
			}
		}
		return isEmpty;
	}

}