package model;

public class Building{

	public static final int SIZE_OF_APARTMENTS = 10;
	public static final int SIZE_OF_USERS = 20;

	private String idName;
	private int numberOfApartments;
	private String address;
	private Apartment[] apartments;
	private Owner[] owners;
	private Tenant[] tenants;


	/**
	 * Building: building class constructor.
	 * @param idName building identifier name.
	 * @param numberOfApartments number of apartments in the building.
	 * @param address building address.
	 * */

	public Building(String idName, int numberOfApartments, String address){
		this.idName = idName;
		this.numberOfApartments = numberOfApartments;
		this.address = address;
		apartments = new Apartment[SIZE_OF_APARTMENTS];
		owners = new Owner[SIZE_OF_USERS];
		tenants = new Tenant[SIZE_OF_USERS];
	}

	public String getIdName(){
		return idName;
	}

	public int getNumberOfApartments(){
		return numberOfApartments;
	}

	public String getAddress(){
		return address;
	}

	/**
	 * addApartment: adds a new apartment to the first empty position in the array.
	 * @param id apartment identifier.
	 * @param numberOfRooms number of rooms in the apartment.
	 * @param numberOfBathrooms number of bathrooms in the apartment.
	 * @param balcony the balcony has or does not have a balcony.
	 * @param leaseValue rental value of the apartment.
	 * @return confirmation message about creating the apartment.
	 * */

	public String addApartment(String id, int numberOfRooms, int numberOfBathrooms, int balcony, double leaseValue){
		String msj = "";
		Apartment newApartment = new Apartment(id, numberOfRooms, numberOfBathrooms, balcony, leaseValue);
		boolean isEmpty = false;
		for(int i = 0; i < SIZE_OF_APARTMENTS && !isEmpty; i++){
			if(apartments[i] == null){
				apartments[i] = newApartment;
				isEmpty = true;
				msj = "Apartamento agregado.";
			}
		} 
		return msj;
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