package ru.lesson.lessons.clinic;

import java.util.Scanner;

/**
 *
 * @author Anton Lapin
 * @since March 24, 2018
 */
public class ClinicAsALRunner {

    private ClinicAsArrayList clinic = new ClinicAsArrayList();
    private Scanner scanner = new Scanner(System.in);
    private String choice;
    private String[] clientData;


    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        ClinicAsALRunner clinicAsALRunner = new ClinicAsALRunner();
        clinicAsALRunner.run();
    }

    /**
     * This method runs this program
     */
    public void run() {
        System.out.println("***C L I N I C***");
        System.out.println("Welcome in Main Menu!");
        String exit = "no";
        do {
            System.out.println("Please, enter command:\n-1(add client);\n-2(edit client);\n" +
                    "-3(edit pet);\n-4(remove client);\n-5(remove pet);\n-0(exit)");
            this.choice = this.scanner.nextLine();
            try {
                int choiceAsInt = checkInputCommand();
                switch (choiceAsInt) {
                    case 1:
                        addingClientsIntoClinicList();
                        break;
                    case 2:
                        editingClients();
                        break;
                    case 3:
                        editingPets();
                        break;
                    case 4:
                        removingClient();
                        break;
                    case 5:
                        removingPets();
                        break;
                    case 0:
                        System.out.println("Exit from program? - yes/no");
                        exit = this.scanner.nextLine();
                }
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (exit.equals("no"));
        System.out.println("Good bye!");
    }

    /**
     * This method checks input command on number containing
     * @return number
     */
    private int checkInputCommand() throws UserException {
        int choiceAsInt;
        String[] symbs = this.choice.split("");
        for(int i = 0; i < symbs.length; i++) {
            if(symbs[i].matches("^\\D*$")){
                throw new UserException("Incorrect input data. Please, enter a number only");
            }
        }
        choiceAsInt = Integer.valueOf(this.choice);
        return choiceAsInt;
    }

    /**
     * This method allows to user to add clients into client's list
     */
    private void addingClientsIntoClinicList() {
        System.out.println("Add new client");
        do {
            this.clientData = inputClientData();
            Pet pet = petsDeterminate(this.clientData[1], this.clientData[2]);
            this.clinic.addNewClient(new Client(this.clientData[0], pet));
            System.out.println("Do you want to continue the adding of clients into list? - yes/no");
            this.choice = scanner.nextLine();
        } while (this.choice.equals("yes"));
        this.clinic.info();
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
        String[] data = new String[3];
        System.out.println("Please, enter client's name...");
        data[0] = this.scanner.nextLine();
        System.out.println("Please, enter type of pet (cat, dog, catdog)...");
        data[1] = this.scanner.nextLine();
        System.out.println("Please, enter pet's name...");
        data[2] = this.scanner.nextLine();
        return data;
    }

    /**
     * This method allows to user to edit client's name into client's list
     */
    private void editingClients() {
        System.out.println("Edit client's name");
        do {
            System.out.println("Please, enter current client's name...");
            String oldId = this.scanner.nextLine();
            System.out.println("Please, enter new client's name...");
            String newId = this.scanner.nextLine();
            try {
                this.clinic.editClientId(oldId, newId);
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Do you want to continue to edit clients list? - yes/no");
            this.choice = this.scanner.nextLine();
        } while (this.choice.equals("yes"));
        this.clinic.info();
    }

    /**
     * This method allows to user to edit pet's name into client's list
     */
    private void editingPets() {
        System.out.println("Edit pet's name");
        do {
            System.out.println("Please, enter client's name...");
            String clientName = this.scanner.nextLine();
            System.out.println("Please, enter new pet's name...");
            String petsName = this.scanner.nextLine();
            try {
                this.clinic.editPetsNameByClientId(clientName, petsName);
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Do you want to continue to edit clients list? - yes/no");
            this.choice = this.scanner.nextLine();
        } while (this.choice.equals("yes"));
        this.clinic.info();
    }

    /**
     * This method allows to user to remove clients from client's list by client's name
     */
    private void removingClient() {
        System.out.println("Remove client");
        do {
            System.out.println("Please, enter client's name...");
            String clientName = this.scanner.nextLine();
            try {
                this.clinic.removeClientById(clientName);
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Do you want to continue to remove clients from list? - yes/no");
            this.choice = this.scanner.nextLine();
        } while (this.choice.equals("yes"));
        this.clinic.info();
    }

    /**
     * This method allows to user to remove pet from client's list by client's name
     */
    private void removingPets() {
        System.out.println("Remove pets");
        do {
            System.out.println("Please, enter client's name...");
            String clientName = this.scanner.nextLine();
            try {
                this.clinic.removePetFromClient(clientName);
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Do you want to continue to remove pets from list? - yes/no");
            this.choice = this.scanner.nextLine();
        } while (this.choice.equals("yes"));
        this.clinic.info();
    }
}
