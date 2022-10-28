package ui;

import java.util.Scanner;
import model.RealStateController;

public class Main{

	private Scanner reader;
	private RealStateController controller;

	public Main(){

		reader = new Scanner(System.in);
		controller = new RealStateController();
	}

	public RealStateController getController(){
		return controller;
	}

	public Scanner getReader(){
		return reader;
	}

	public static void main(String[] args){
		Main main = new Main();
		int option = 0;
		do{
			option = main.getOptionShowMenu(); 
			main.executeOption(option);
		}
		while(option != 0);
		main.getReader().close();
	}

	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println("\n" +
			"<<<<< Welcome to Real State >>>>>");
		System.out.println(
				"1. Registrar edifico.\n" +
				"2. Registrar apartamento a un edificio.\n" +
				"3. Registrar al propietario de un apartamento.\n" +
				"4. Registrar al arrendatario de un apartamento.\n" +
				"5. Consultar cuantos apartamentos hay disponibles en un edificio.\n" +
				"6. Consultar el valor mensual total de los apartamentos arrendados.\n" +
				"7. Consultar si un apartamento se encuentra disponible.\n" +
				"8. Consultar la cantidad de apartamentos que tiene arrendada una persona.\n" +
				"9. Consultar el valor total que recibira el propietario de un apartamento.\n" +
				"0. Exit." +
				"\n");
		option = reader.nextInt(); 

		return option; 
	}

	public void executeOption(int option){

		String idName = "";
		String idType = "";
		int numberOfApartments = 0;
		String name = "";
		String identificationNumber = "";
		String contactNumber = "";
		String address = "";
		String accountNumber = "";
		int typePhone;
		String id = "";
		String bankName = "";
		int numberOfRooms = 0;
		int numberOfBathrooms = 0;
		int balcony = 0;
		double leaseValue = 0;

		switch(option){

		    case 1:

		    	System.out.println("\nIngrese el nombre identificador del edificio: ");
		    	idName = reader.next();
		    	System.out.println("\nIngrese el numero de apartamentos del edificio: ");
		    	numberOfApartments = reader.nextInt();
		    	System.out.println("\nIngrese la direccion del edifico: ");
		    	address = reader.next();

		    	String msj = controller.createBuilding(idName, numberOfApartments, address);
		    	System.out.println(msj);

		    	break;

		    case 2:

		    	System.out.println("Ingrese el ID del edificio a agregar el apartamento: ");
				idName = reader.next();
				boolean isEmpty = controller.callEmptyPos(idName);
				if(isEmpty){
					
					System.out.println("Ingrese el ID del apartamento: ");
					id = reader.next();
					System.out.println("Ingrese el numero de habitaciones del apartamento: ");
					numberOfRooms = reader.nextInt();
					System.out.println("Ingrese el numero de banyos del apartamento: ");
					numberOfBathrooms = reader.nextInt();
					System.out.println("El apartamento cuenta con balcones? \n1. Si. \n2. No. ");
					balcony = reader.nextInt();
					System.out.println("Ingrese el valor de la renta del apartamento: ");
					leaseValue = reader.nextDouble();

					msj = controller.addApartmentToBuilding(id, numberOfRooms, numberOfBathrooms, balcony, leaseValue, idName);
					System.out.println(msj);

				}else{
					System.out.println("El edificio no se encuentra en la inmobiliaria.");
				}


		    	break;

		    case 3:

		    	System.out.println("Ingrese el ID del apartamento a agregar el propietario: ");
				id = reader.next();
				isEmpty = controller.callEmptyOwnerPos(id);
				if(isEmpty){

					System.out.println("Ingrese el tipo de identificacion: ");
					idType = reader.next();
					System.out.println("Ingrese el numero de identificacion: ");
					identificationNumber = reader.next();
					System.out.println("Ingrese el nombre: ");
					name = reader.next();
					System.out.println("Ingrese el numero de contacto: ");
					contactNumber = reader.next();
					System.out.println("Ingrese el numero de cuenta: ");
					accountNumber = reader.next();
					System.out.println("Ingrese el nombre del banco: ");
					bankName = reader.next();
					System.out.println("Ingrese el tipo de telefono: \n1. Home. \n2. Office. \n3. Movil. \n4. Family. \n5. Other.");
					typePhone = reader.nextInt();

					msj = controller.addOwnerToApartment(idType, identificationNumber, name, contactNumber, typePhone, accountNumber, bankName, id);
					System.out.println(msj);

				}else{
					System.out.println("El apartamento no se encuentra en la inmobiliaria o ya tiene un propietario.");
				}

		    	break;

		    case 4:

		    	System.out.println("Ingrese el ID del apartamento a agregar el arrendatario: ");
				id = reader.next();
				isEmpty = controller.callEmptyTenantPos(id);
				if(isEmpty){

					System.out.println("Ingrese el tipo de identificacion: ");
					idType = reader.next();
					System.out.println("Ingrese el numero de identificacion: ");
					identificationNumber = reader.next();
					System.out.println("Ingrese el nombre: ");
					name = reader.next();
					System.out.println("Ingrese el numero de contacto: ");
					contactNumber = reader.next();
					System.out.println("Ingrese el tipo de telefono: ");
					typePhone = reader.nextInt();

					msj = controller.addTenantToApartment(idType, identificationNumber, name, contactNumber, typePhone, id);
					System.out.println(msj);

				}else{
					System.out.println("El apartamento no se encuentra en la inmobiliaria o ya tiene un arrendatario.");
				}


		    	break;

		    case 5:

		    	System.out.println("Ingrese el ID del edificio a agregar el apartamento: ");
				idName = reader.next();
				isEmpty = controller.callEmptyPos(idName);
				if(isEmpty){
			
					msj = controller.getApartmentsAvailables(numberOfApartments, idName);
					System.out.println(msj);

				}else{
					System.out.println("El edificio no se encuentra en la inmobiliaria.");
				}

		    	break;

		    case 6:

		    	msj = controller.countTotalOfValue();
		    	System.out.println(msj);


		    	break;

		    case 7:

		    	System.out.println("Ingrese el ID del apartamento a ver disponibilidad: ");
				id = reader.next();
				isEmpty = controller.callEmptyTenantPos(id);
				if(isEmpty){

					System.out.println("El apartamento se encuentra disponible.");

				}else{
					System.out.println("El apartamento no se encuentra disponible.");
				}


		    	break;

		    case 8:

		    	System.out.println("Ingrese el nombre del propietario a buscar: ");
				name = reader.next();
				isEmpty = controller.callEmptyOwnersPos(name);
				if(isEmpty){

					msj = controller.countApartmentsOfOwners(name);
		    	    System.out.println(msj);

				}else{
					System.out.println("El propietario no se encuntra.");
				}

		    	break;

		    case 9:


		    	break;

		    case 0:

		    	System.out.println("Exit program.");
				break; 

			default: 
				System.out.println("Invalid Option");
				break; 
		}
	}
}