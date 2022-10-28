package model;

public class RealStateController{

	public static final int SIZE_OF_BUILDING = 5;
	public static final int SIZE_OF_USERS = 20;
	public static final int SIZE_OF_APARTMENTS = 10;

	private Building[] buildings;
	private Apartment[] apartments;
	private Owner[] owners;
 
	public RealStateController(){
		buildings = new Building[SIZE_OF_BUILDING];
		apartments = new Apartment[SIZE_OF_APARTMENTS];

		apartments[0] = new Apartment("apto1", 3, 3, 1, 790000);
		apartments[1] = new Apartment("apto2", 3, 3, 1, 995780);
		apartments[2] = new Apartment("apto2", 3, 3, 1, 1678080);
	}

	public Building[] getBuildings(){
		return buildings;
	}

	public Apartment[] getApartment(){
		return apartments;
	}

	/**
	 * createBuilding: adds a new building to the first empty position in the array.
	 * @param idName building identifier name.
	 * @param numberOfApartments number of apartments in the building.
	 * @param address building address.
	 * @return confirmation message about creating the building.
	 * */

	public String createBuilding(String idName, int numberOfApartments, String address){
		String msj = "";
		Building newBuilding = new Building(idName, numberOfApartments, address);
		boolean isEmpty = false;
		for(int i = 0; i < SIZE_OF_BUILDING && !isEmpty; i++){
			if(buildings[i] == null){
				buildings[i] = newBuilding;
				isEmpty = true;
				msj = "Edifico agregado.";
			}
		}
		return msj;
	}

	/**
	 * addApartmentToBuilding: the object created from the apartment adds it to a specific building.
	 * @param id apartment identifier.
	 * @param numberOfRooms number of rooms in the apartment.
	 * @param numberOfBathrooms number of bathrooms in the apartment.
	 * @param balcony the balcony has or does not have a balcony.
	 * @param leaseValue rental value of the apartment.
	 * @param idName identifier name of the building to add.
	 * @return previous post on the apartment creation method.
	 * */

	public String addApartmentToBuilding(String id, int numberOfRooms, int numberOfBathrooms, int balcony, double leaseValue, String idName){
		String msj = "";
		Apartment newApartment = new Apartment(id, numberOfRooms, numberOfBathrooms, balcony, leaseValue);
		int posBuilding = seacrhBuildingById(idName);
		if(posBuilding != -1){
			msj = buildings[posBuilding].addApartment(id, numberOfRooms, numberOfBathrooms, balcony, leaseValue);
		}
		return msj;
	}

	/**
	 * addOwnerToApartment: the object created from the owner adds it to a specific apartment.
	 * @param idType user's identification type.
	 * @param identificationNumber user's number identification.
	 * @param name user's name.
	 * @param contactNumber user's contact number.
	 * @param typePhone user's type phone.
	 * @param accountNumber user's account number.
	 * @param bankName user's bank name.
	 * @param id identifier name of the apartment to add.
	 * @return previous post on the owner creation method.
	 * */

	public String addOwnerToApartment(String idType, String identificationNumber, String name, String contactNumber, int typePhone, String accountNumber, String bankName, String id){
		String msj = "";
		Owner newOwner = new Owner(idType, identificationNumber, name, contactNumber, typePhone, accountNumber, bankName);
		int posApartment = seacrhApartmentById(id);
		if(posApartment != -1){
			msj = apartments[posApartment].addOwner(idType, identificationNumber, name, contactNumber, typePhone, accountNumber, bankName);
		}
		return msj;
	}

	/**
	 * addTenantToApartment: the object created from the tenant adds it to a specific apartment.
	 * @param idType user's identification type.
	 * @param identificationNumber user's number identification.
	 * @param name user's name.
	 * @param id identifying of the apartment being searched for.
	 * @param contactNumber user's contact number.
	 * @param typePhone user's type phone.
	 * @return previous post on the tenant creation method.
	 * */

	public String addTenantToApartment(String idType, String identificationNumber, String name, String contactNumber, int typePhone, String id){
		String msj = "";
		Tenant newTenant = new Tenant(idType, identificationNumber, name, contactNumber, typePhone);
		int posApartment = seacrhApartmentById(id);
		if(posApartment != -1){
			msj = apartments[posApartment].addTenant(idType, identificationNumber, name, contactNumber, typePhone);
		}
		return msj;
	}

	/**
	 * seacrhBuildingById: look for an building by id to give his position.
	 * @param idName building identifier name.
	 * @return position in the wanted building.
	 * */

	public int seacrhBuildingById(String idName){
		int pos = -1;
		boolean isFound = false;
		for(int i = 0; i < SIZE_OF_BUILDING && !isFound; i++){
			if(buildings[i] != null && buildings[i].getIdName().equals(idName)){
				pos = i;
				isFound = true;
			}
		}
		return pos;
	}

	/**
	 * seacrhApartmentById: look for an apartment by id to give his position.
	 * @param id apartment identifier.
	 * @return position in the wanted apartment.
	 * */

	public int seacrhApartmentById(String id){
		int pos = -1;
		boolean isFound = false;
		for(int i = 0; i < SIZE_OF_APARTMENTS && !isFound; i++){
			if(apartments[i] != null && apartments[i].getId().equals(id)){
				pos = i;
				isFound = true;
			}
		}
		return pos;
	}

	/**
	 * callEmptyPos: validate that the position is specific that it is sought to have an empty space.
	 * @param idName identifying name of the building being searched for.
	 * @return boolean condition on whether a position is empty.
	 * */

	public boolean callEmptyPos(String idName){
		boolean isEmpty = false;
		int posBuilding = seacrhBuildingById(idName);
		if(posBuilding != -1){
			isEmpty = buildings[posBuilding].hasEmptyApartmentPos();
		}
		return isEmpty;
	}

	/**
	 * callEmptyApartmentPos: validate that the position is specific that it is sought to have an empty space.
	 * @param id identifying of the apartment being searched for.
	 * @return boolean condition on whether a position is empty.
	 * */

	public boolean callEmptyApartmentPos(String id){
		boolean isEmpty = false;
		int posApartment = seacrhApartmentById(id);
		if(posApartment != -1){
			isEmpty = apartments[posApartment].hasEmptyApartmentPos();
		}
		return isEmpty;
	}

	/**
	 * callEmptyPos: validate that the position is specific that it is sought to have an empty space.
	 * @param id identifying of the apartment being searched for.
	 * @return boolean condition on whether a position is empty.
	 * */

	public boolean callEmptyOwnerPos(String id){
		boolean isEmpty = false;
		int posApartment = seacrhApartmentById(id);
		if(posApartment != -1){
			isEmpty = apartments[posApartment].hasEmptyOwnerPos();
		}
		return isEmpty;
	}

	/**
	 * callEmptyOwnerPos: validate that the position is specific that it is sought to have an empty space.
	 * @param name name of the owner being searched for.
	 * @return boolean condition on whether a position is empty.
	 * */

	public boolean callEmptyOwnersPos(String name){
		boolean isEmpty = false;
		int posApartment = searchOwnerByName(name);
		if(posApartment != -1){
			isEmpty = apartments[posApartment].hasEmptyOwnerPos();
		}
		return isEmpty;
	}

	/**
	 * countTotalOfValue: in the apartment arrangement, it counts those that have a rental price and adds them up.
	 * @return message with the total price of the apartments.
	 * */

	public String countTotalOfValue(){
		String msj = "";
		int count = 0;
		for(int i = 0; i < SIZE_OF_APARTMENTS; i++){
			if(apartments[i] != null){
				count += apartments[i].getLeaseValue();
			    msj = "El valor total de los apartamentos es " + count;
			}
		}
		return msj;
	}

	/**
	 * seacrhOwnerByName: look for an owners by id to give his position.
	 * @param name owner name.
	 * @return position in the wanted owners.
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
	 * countApartmentsOfOwners: validate in the owners' arrangement how many apartments a specific one has.
	 * @param name name of owner sought.
	 * @return message with the whole number of apartments you have.
	 * */

	public String countApartmentsOfOwners(String name){
		String msj = "";
		for(int i = 0; i < SIZE_OF_APARTMENTS; i++){
			if(apartments[i] != null){
				msj = apartments[i].countOwners(name);
			}
		}
		return msj;
	}

	/**
	 * callEmptyTenantPos: validate that the position is specific that it is sought to have an empty space.
	 * @param id identifying of the apartment being searched for.
	 * @return boolean condition on whether a position is empty.
	 * */

	public boolean callEmptyTenantPos(String id){
		boolean isEmpty = false;
		int posApartment = seacrhApartmentById(id);
		if(posApartment != -1){
			isEmpty = apartments[posApartment].hasEmptyTenantPos();
		}
		return isEmpty;
	}

	/**
	 * getApartmentsAvailables: get the available apartments in a specific building..
	 * @param numberOfApartments apartments in a building..
	 * @param idName identifying name of the building being searched for.
	 * @return message with the whole number of apartments available.
	 * */

	public String getApartmentsAvailables(int numberOfApartments, String idName){
		String msj = "";
		int posBuilding = seacrhBuildingById(idName);
		if(posBuilding != -1){
			msj = "Se encuentran " + buildings[posBuilding].getNumberOfApartments() + " apartamentos disponibles.";
		}
		return msj;
	}
}