package clinic;

/**
 *
 * @author Anton Lapin
 * @sinse March 16, 2018
 */

public class ClinicRunner {

    public static void main(String[] args) {
        Clinic clinic = new Clinic(10);
        Client[] clients;
        clinic.addNewClient(0, new Client("Ivanov", new Pet(new Cat("Vaska"))));
        clinic.addNewClient(1, new Client("Petrov", new Pet(new Dog("Mukha"))));
        clinic.addNewClient(2, new Client("Ivanov2", new Pet(new Cat("Vaska"))));
        clinic.addNewClient(3, new Client("Petrov2", new Pet(new Dog("Mukha"))));
        clinic.addNewClient(0, new Client("Ivanov3", new Pet(new Cat("Vaska"))));
        clinic.addNewClient(1, new Client("Petrov3", new Pet(new Dog("Mukha"))));
        clinic.addNewClient(4, new Client("Sidorov", new Pet(new CatDog(
                new Cat("Vaska"), new Dog("Chappy")))));
        System.out.println("------------");
        clinic.info();
        System.out.println("------------");
        clients = clinic.findClientByPetsName("Vaska");

        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null) {
                System.out.println("id: " + i + " client: " + clients[i].getId() + " pet: " +
                        clients[i].getPet().getName());
            }
        }
        System.out.println("-------------");

        clients = clinic.findClientById("Ivanov");
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null) {
                System.out.println("id: " + i + " client: " + clients[i].getId() + " pet: " +
                        clients[i].getPet().getName());
            }
        }
        System.out.println("-------------");
        System.out.println("Before edit client id");
        clinic.info();
        clinic.editClientsId("Ivanov2", "Kozlov");
        System.out.println("After edit client id");
        clinic.info();
        System.out.println("--------------");
        System.out.println("before edit pets name");
        clinic.info();
        System.out.println("After edit pets name");
        clinic.editPetsNameByClientId("Petrov", "Mos`ka");
        clinic.info();
        System.out.println("---------------");
        System.out.println("before removing by id");
        clinic.info();
        clinic.removeClientById("Petrov");
        System.out.println("after removing by id");
        clinic.info();
        System.out.println("----------------");
        System.out.println("before removing pet by client id");
        clinic.info();
        clinic.removePetFromClient("Sidorov");
        System.out.println("after removing pet by client id");
        clinic.info();
    }
}
