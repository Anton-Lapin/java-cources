package ru.lesson.lessons.clinic;

import java.util.Scanner;

/**
 *
 * @author Anton Lapin
 * @sinse March 16, 2018
 */

public class ClinicRunner {

    private Clinic clinic;
    private Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        ClinicRunner clinicRunner = new ClinicRunner();
        clinicRunner.run();
    }

    public void run() {
        System.out.println("Welcome in Main Menu!");
        String exit;
        do {
            System.out.println("Please, enter command:\n-1(size);\n-2(add);\n-3(edit client);\n-4(edit pet);\n" +
                    "-5(remove client);\n-6(remove pet)");
            int choice = Integer.valueOf(this.scanner.nextLine());
            switch (choice) {
                case 1:
                    settingSizeOfClientsList();
                    break;
                case 2:
                    addingClientsIntoClinicList();
                    break;
                case 3:
                    editingClients();
                    break;
                case 4:
                    editingPets();
                    break;
                case 5:
                    removingClient();
                    break;
                case 6:
                    removingPets();
            }
            System.out.println("Exit from program? - yes/no");
            exit = this.scanner.nextLine();
        } while (exit.equals("no"));
        System.out.println("Good bye!");
    }

    private void settingSizeOfClientsList() {
        System.out.println("Set size of client's list");
        int size;
        System.out.println("Please, enter size of clients list...");
        size = Integer.valueOf(this.scanner.nextLine());
        this.clinic = new Clinic(size);
    }

    private void addingClientsIntoClinicList() {
        System.out.println("Add new client");
        String choice;
        int position;
        String name;
        String type;
        String petsName;
        Pet pet = new Pet();
        do {
            System.out.println("Please, enter position...");
            position = Integer.valueOf(this.scanner.nextLine());
            System.out.println("Please, enter client's name...");
            name = this.scanner.nextLine();
            System.out.println("Please, enter type of pet (cat, dog, catdog)...");
            type = this.scanner.nextLine();
            System.out.println("Please, enter pet's name...");
            petsName = this.scanner.nextLine();
            if (type.equals("cat")) {
                pet = new Pet(new Cat(petsName));
            } else if (type.equals("dog")) {
                pet = new Pet(new Dog(petsName));
            } else if (type.equals("catdog")) {
                String[] splitted = petsName.split(" ");
                pet = new Pet(new CatDog(new Cat(splitted[0]), new Dog(splitted[1])));
            }
            try {
                this.clinic.addNewClient(position, new Client(name, pet));
            } catch (UserException e) {
                e.printStackTrace();
            }
            System.out.println("Do you want to continue the adding of clients into list? - yes/no");
            choice = scanner.nextLine();
        } while (choice.equals("yes"));
        System.out.println("<------------------------>");
        this.clinic.info();
    }

    private void editingClients() {
        System.out.println("Edit client's name");
        String choice;
        do {
            System.out.println("Please, enter current client's name...");
            String oldId = this.scanner.nextLine();
            System.out.println("Please, enter new client's name...");
            String newId = this.scanner.nextLine();
            this.clinic.editClientsId(oldId, newId);
            System.out.println("Do you want to continue to edit clients list? - yes/no");
            choice = this.scanner.nextLine();
        } while (choice.equals("yes"));
        System.out.println("<------------------------>");
        this.clinic.info();
    }

    private void editingPets() {
        System.out.println("Edit pet's name");
        String choice;
        do {
            System.out.println("Please, enter client's name...");
            String clientName = this.scanner.nextLine();
            System.out.println("Please, enter new pet's name...");
            String petsName = this.scanner.nextLine();
            this.clinic.editPetsNameByClientId(clientName, petsName);
            System.out.println("Do you want to continue to edit clients list? - yes/no");
            choice = this.scanner.nextLine();
        } while (choice.equals("yes"));
        System.out.println("<------------------------>");
        this.clinic.info();
    }

    private void removingClient() {
        System.out.println("Remove client");
        String choice;
        do {
            System.out.println("Please, enter client's name...");
            String clientName = this.scanner.nextLine();
            this.clinic.removeClientById(clientName);
            System.out.println("Do you want to continue to remove clients from list? - yes/no");
            choice = this.scanner.nextLine();
        } while (choice.equals("yes"));
        System.out.println("<------------------------>");
        this.clinic.info();
    }

    private void removingPets() {
        System.out.println("Remove pets");
        String choice;
        do {
            System.out.println("Please, enter client's name...");
            String clientName = this.scanner.nextLine();
            this.clinic.removePetFromClient(clientName);
            System.out.println("Do you want to continue to remove pets from list? - yes/no");
            choice = this.scanner.nextLine();
        } while (choice.equals("yes"));
        System.out.println("<------------------------>");
        this.clinic.info();
    }
}
