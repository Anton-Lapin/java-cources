package clinic;

/**
 *
 * @author Anton Lapin
 * @sinse March 16, 2018
 */

import java.util.ArrayList;

public class ClinicRunner {

    public static void main(String[] args) {
        Clinic clinic = new Clinic(10);
        Client[] clients;
        ArrayList<Client> clientArrayList = new ArrayList<>();
        clinic.addNewClient(0, new Client("Ivanov", new Pet(new Cat("Vaska"))));
        clinic.addNewClient(1, new Client("Petrov", new Pet(new Dog("Mukha"))));
        clinic.addNewClient(2, new Client("Ivanov2", new Pet(new Cat("Vaska"))));
        clinic.addNewClient(3, new Client("Petrov2", new Pet(new Dog("Mukha"))));
        clinic.addNewClient(0, new Client("Ivanov3", new Pet(new Cat("Vaska"))));
        clinic.addNewClient(1, new Client("Petrov3", new Pet(new Dog("Mukha"))));
        clinic.addNewClient(4, new Client("Sidorov", new Pet(new CatDog(
                new Cat("Vaska"), new Dog("Chappy")))));
        System.out.println("------------");
        clients = clinic.getClients();

        System.out.println("------------");

        clientArrayList = clinic.findClientByPetsName("Vaska");
        for (Client cl: clientArrayList) {
            System.out.println("client: " + cl.getId() + " pet: " + cl.getPet().getName());
        }
//        System.out.println("-------------");
//        clientArrayList = clinic.findClientById("Ivanov");
//        for (Client cl: clientArrayList) {
//            System.out.println("client: " + cl.getId() + " pet: " + cl.getPet().getName());
//        }
//        System.out.println("-------------");
//        System.out.println("Before edit client id");
//        clients = clinic.getClients();
//        for (int i = 0; i < clients.length; i++) {
//            if (clients[i] != null) {
//                System.out.println("pos: " + i + " client: " + clients[i].getId() + " pet: "
//                        + clients[i].getPet().getName());
//            }
//        }
//        clinic.editClientsId("Ivanov2", "Sidorov");
//        System.out.println("After edit client id");
//        clients = clinic.getClients();
//        for (int i = 0; i < clients.length; i++) {
//            if (clients[i] != null) {
//                System.out.println("pos: " + i + " client: " + clients[i].getId() + " pet: "
//                        + clients[i].getPet().getName());
//            }
//        }
//        System.out.println("--------------");
//        System.out.println("before edit pets name");
//        clients = clinic.getClients();
//        for (int i = 0; i < clients.length; i++) {
//            if (clients[i] != null) {
//                System.out.println("pos: " + i + " client: " + clients[i].getId() + " pet: "
//                        + clients[i].getPet().getName());
//            }
//        }
//        System.out.println("After edit pets name");
//        clinic.editPetsNameByClientId("Petrov", "Mos`ka");
//        clients = clinic.getClients();
//        for (int i = 0; i < clients.length; i++) {
//            if (clients[i] != null) {
//                System.out.println("pos: " + i + " client: " + clients[i].getId() + " pet: "
//                        + clients[i].getPet().getName());
//            }
//        }

    }
}
