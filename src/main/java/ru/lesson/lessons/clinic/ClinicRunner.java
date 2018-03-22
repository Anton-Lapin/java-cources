package ru.lesson.lessons.clinic;

import java.util.Scanner;

/**
 * This class implements Clinic interactive user's menu.
 * @author Anton Lapin
 * @sinse March 16, 2018
 */

public class ClinicRunner {

    private Clinic clinic;
    private Scanner scanner = new Scanner(System.in);
    private int size = 0;
    private String choice;
    private String[] clientData;


    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        ClinicRunner clinicRunner = new ClinicRunner();
        clinicRunner.run();
    }

    /**
     * This method runs this program
     */
    public void run() {
        System.out.println("***C L I N I C***");
        System.out.println("Welcome in Main Menu!");
        String exit = "no";
        do {
            System.out.println("Please, enter command:\n-1(set size);\n-2(add client);\n-3(edit client);\n" +
                    "-4(edit pet);\n-5(remove client);\n-6(remove pet);\n-0(exit)");
            int choice = Integer.valueOf(this.scanner.nextLine());
            switch (choice) {
                case 1:
                    try {
                        settingSizeOfClientsList();
                    } catch (UserException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        addingClientsIntoClinicList();
                    } catch (UserException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        editingClients();
                    } catch (UserException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        editingPets();
                    } catch (UserException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        removingClient();
                    } catch (UserException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        removingPets();
                    } catch (UserException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Exit from program? - yes/no");
                    exit = this.scanner.nextLine();
            }
        } while (exit.equals("no"));
        System.out.println("Good bye!");
    }

    /**
     * This method allows to user to set size of client's list
     * @throws UserException if list's size installed already
     */
    private void settingSizeOfClientsList() throws UserException {
        if (this.size == 0) {
            System.out.println("Set size of client's list");
            System.out.println("Please, enter size of clients list...");
            this.size = Integer.valueOf(this.scanner.nextLine());
            this.clinic = new Clinic(this.size);
        } else {
            throw new UserException("List's size installed already");
        }
    }

    /**
     * This method allows to user to add clients into client's list
     * @throws UserException if list's size not installed
     */
    private void addingClientsIntoClinicList() throws UserException {
        if (this.size != 0) {
            System.out.println("Add new client");
            do {
                this.clientData = inputClientData();
                Pet pet = petsDeterminate(this.clientData[2], this.clientData[3]);
                try {
                    this.clinic.addNewClient(Integer.valueOf(this.clientData[0]), new Client(this.clientData[1], pet));
                } catch (UserException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Do you want to continue the adding of clients into list? - yes/no");
                this.choice = scanner.nextLine();
            } while (this.choice.equals("yes"));
            System.out.println("<------------------------>");
            this.clinic.info();
        } else {
            throw new UserException("List's size not installed. Please choose 1 position on Main Menu");
        }
    }

    /**
     * This method allow to user to enter his pet's data
     * @param type type of pet
     * @param name pet's name
     * @return pet
     */
    private Pet petsDeterminate(String type, String name) {
        Pet pet = new Pet();
        if (type.equals("cat")) {
            pet = new Pet(new Cat(name));
        } else if (type.equals("dog")) {
            pet = new Pet(new Dog(name));
        } else if (type.equals("catdog")) {
            pet = new Pet(new CatDog(new Cat(name + "-cat"), new Dog(name + "-dog")));
        }
        return pet;
    }

    /**
     * This method allows to user to enter client's data
     * @return client's data array
     */
    private String[] inputClientData() {
        String[] data = new String[4];
        System.out.println("Please, enter position...");
        data[0] = this.scanner.nextLine();
        System.out.println("Please, enter client's name...");
        data[1] = this.scanner.nextLine();
        System.out.println("Please, enter type of pet (cat, dog, catdog)...");
        data[2] = this.scanner.nextLine();
        System.out.println("Please, enter pet's name...");
        data[3] = this.scanner.nextLine();
        return data;
    }

    /**
     * This method allows to user to edit client's name into client's list
     * @throws UserException if list's size not installed
     */
    private void editingClients() throws UserException {
        if (this.size != 0) {
            System.out.println("Edit client's name");
            do {
                System.out.println("Please, enter current client's name...");
                String oldId = this.scanner.nextLine();
                System.out.println("Please, enter new client's name...");
                String newId = this.scanner.nextLine();
                this.clinic.editClientsId(oldId, newId);
                System.out.println("Do you want to continue to edit clients list? - yes/no");
                this.choice = this.scanner.nextLine();
            } while (this.choice.equals("yes"));
            System.out.println("<------------------------>");
            this.clinic.info();
        } else {
            throw new UserException("List's size not installed. Please choose 1 position on Main Menu");
        }
    }

    /**
     * This method allows to user to edit pet's name into client's list
     * @throws UserException if list's size not installed
     */
    private void editingPets() throws UserException {
        if (this.size != 0) {
            System.out.println("Edit pet's name");
            do {
                System.out.println("Please, enter client's name...");
                String clientName = this.scanner.nextLine();
                System.out.println("Please, enter new pet's name...");
                String petsName = this.scanner.nextLine();
                this.clinic.editPetsNameByClientId(clientName, petsName);
                System.out.println("Do you want to continue to edit clients list? - yes/no");
                this.choice = this.scanner.nextLine();
            } while (this.choice.equals("yes"));
            System.out.println("<------------------------>");
            this.clinic.info();
        } else {
            throw new UserException("List's size not installed. Please choose 1 position on Main Menu");
        }
    }

    /**
     * This method allows to user to remove clients into client's list by client's name
     * @throws UserException if list's size not installed
     */
    private void removingClient() throws UserException {
        if (this.size != 0) {
            System.out.println("Remove client");
            do {
                System.out.println("Please, enter client's name...");
                String clientName = this.scanner.nextLine();
                this.clinic.removeClientById(clientName);
                System.out.println("Do you want to continue to remove clients from list? - yes/no");
                this.choice = this.scanner.nextLine();
            } while (this.choice.equals("yes"));
            System.out.println("<------------------------>");
            this.clinic.info();
        } else {
            throw new UserException("List's size not installed. Please choose 1 position on Main Menu");
        }
    }

    /**
     * This method allows to user to remove pet into client's list by client's name
     * @throws UserException if list's size not installed
     */
    private void removingPets() throws UserException {
        if (this.size != 0) {
            System.out.println("Remove pets");
            do {
                System.out.println("Please, enter client's name...");
                String clientName = this.scanner.nextLine();
                this.clinic.removePetFromClient(clientName);
                System.out.println("Do you want to continue to remove pets from list? - yes/no");
                this.choice = this.scanner.nextLine();
            } while (this.choice.equals("yes"));
            System.out.println("<------------------------>");
            this.clinic.info();
        } else {
            throw new UserException("List's size not installed. Please choose 1 position on Main Menu");
        }
    }
}
