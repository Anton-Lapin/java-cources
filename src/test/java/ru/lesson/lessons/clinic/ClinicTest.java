package ru.lesson.lessons.clinic;

import org.junit.Test;

/**
 * This is test-class of Clinic class
 * @author Anton Lapin
 * @since March 20, 2018
 */
public class ClinicTest {

    @Test
    public void addNewClient1() throws Exception {
        Clinic clinic = new Clinic(10);
        clinic.addNewClient(0, new Client("0", new Pet(new Cat("Vaska"))));
        clinic.info();
        clinic.addNewClient(0, new Client("1", new Pet()));
        clinic.info();
        clinic.addNewClient(10, new Client("10", new Pet()));
        clinic.info();
    }

    @Test
    public void findClientByPetsName() throws Exception {
        Clinic clinic = new Clinic(10);
        clinic.addNewClient(0, new Client("0", new Pet(new Cat("Vaska"))));
        clinic.addNewClient(5, new Client("5", new Pet(new Dog("Chappy"))));
        clinic.info();
        System.out.println("Ok...");
        Client[] clients = clinic.findClientByPetsName("Vaska");
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null) {
                System.out.println("id: " + i + " client: " + clients[i].getId() + " pet: " +
                        clients[i].getPet().getName());
            }
        }
        System.out.println("Not Ok...");
        clients = clinic.findClientByPetsName("Murka");
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null) {
                System.out.println("id: " + i + " client: " + clients[i].getId() + " pet: " +
                        clients[i].getPet().getName());
            }
        }
    }

    @Test
    public void findClientById() throws Exception {
        Clinic clinic = new Clinic(10);
        clinic.addNewClient(0, new Client("0", new Pet(new Cat("Vaska"))));
        clinic.addNewClient(5, new Client("5", new Pet(new Dog("Chappy"))));
        clinic.info();
        System.out.println("Ok...");
        Client[] clients = clinic.findClientById("5");
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null) {
                System.out.println("id: " + i + " client: " + clients[i].getId() + " pet: " +
                        clients[i].getPet().getName());
            }
        }
        System.out.println("Not Ok...");
        clients = clinic.findClientById("3");
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null) {
                System.out.println("id: " + i + " client: " + clients[i].getId() + " pet: " +
                        clients[i].getPet().getName());
            }
        }
    }

    @Test
    public void editClientsId() throws Exception {
        Clinic clinic = new Clinic(10);
        clinic.addNewClient(0, new Client("0", new Pet(new Cat("Vaska"))));
        clinic.addNewClient(5, new Client("5", new Pet(new Dog("Chappy"))));
        clinic.addNewClient(9, new Client("9", new Pet(new CatDog(new Cat("Murka"), new Dog("Mukha")))));
        clinic.info();
        System.out.println("Ok...");
        clinic.editClientsId("5","55");
        clinic.info();
        System.out.println("Not Ok...");
        clinic.editClientsId("1", "2");
        clinic.info();
    }

    @Test
    public void editPetsNameByClientId() throws Exception {
        Clinic clinic = new Clinic(10);
        clinic.addNewClient(0, new Client("0", new Pet(new Cat("Vaska"))));
        clinic.addNewClient(5, new Client("5", new Pet(new Dog("Chappy"))));
        clinic.addNewClient(9, new Client("9", new Pet(new CatDog(new Cat("Murka"), new Dog("Mukha")))));
        clinic.info();
        System.out.println("Ok...");
        clinic.editPetsNameByClientId("9","Habra Kadabra");
        clinic.info();
        System.out.println("Not Ok...");
        clinic.editPetsNameByClientId("1","Habra");
        clinic.info();
        System.out.println("Not Ok...");
        clinic.editPetsNameByClientId("9","Habra");
        clinic.info();
    }

    @Test
    public void removeClientById() throws Exception {
        Clinic clinic = new Clinic(10);
        clinic.addNewClient(0, new Client("0", new Pet(new Cat("Vaska"))));
        clinic.addNewClient(5, new Client("5", new Pet(new Dog("Chappy"))));
        clinic.addNewClient(9, new Client("9", new Pet(new CatDog(new Cat("Murka"), new Dog("Mukha")))));
        clinic.info();
        System.out.println("Ok...");
        clinic.removeClientById("9");
        clinic.info();
        System.out.println("Not Ok...");
        clinic.removeClientById("55");
        clinic.info();
    }

    @Test
    public void removePetFromClient() throws Exception {
        Clinic clinic = new Clinic(10);
        clinic.addNewClient(0, new Client("0", new Pet(new Cat("Vaska"))));
        clinic.addNewClient(5, new Client("5", new Pet(new Dog("Chappy"))));
        clinic.addNewClient(9, new Client("9", new Pet(new CatDog(new Cat("Murka"), new Dog("Mukha")))));
        clinic.info();
        System.out.println("Ok...");
        clinic.removePetFromClient("0");
        clinic.info();
        System.out.println("Not Ok...");
        clinic.removePetFromClient("2");
        clinic.info();
    }

}