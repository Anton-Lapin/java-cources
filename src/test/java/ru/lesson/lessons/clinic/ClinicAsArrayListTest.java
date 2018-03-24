package ru.lesson.lessons.clinic;

import org.junit.Test;

import java.util.ArrayList;

/**
 * This class contains tests for ClinicAsArray class
 * @author Anton Lapin
 * @since March 24, 2018
 */
public class ClinicAsArrayListTest {
    @Test
    public void addNewClient() throws Exception {
        ClinicAsArrayList clinic = new ClinicAsArrayList();
        clinic.addNewClient(new Client("Ivanov", new Pet(new Cat("Vaska"))));
        clinic.addNewClient(new Client("Petrov", new Pet(new Dog("Kuska"))));
        clinic.addNewClient(new Client("Sidorov", new Pet(new CatDog(new Cat("Murka"), new Dog("Mukha")))));
        clinic.info();
    }

    @Test
    public void findClientByPetsName1() throws Exception {
        ClinicAsArrayList clinic = new ClinicAsArrayList();
        clinic.addNewClient(new Client("Ivanov", new Pet(new Cat("Vaska"))));
        clinic.addNewClient(new Client("Petrov", new Pet(new Dog("Kuska"))));
        clinic.addNewClient(new Client("Sidorov", new Pet(new CatDog(new Cat("Murka"), new Dog("Mukha")))));
        clinic.info();
        ArrayList<Client> clients = clinic.findClientByPetsName("Murka Mukha");
        for (Client client : clients) {
            System.out.println(client.getId() + " " + client.getPet().getName());
        }
    }

    @Test(expected = UserException.class)
    public void findClientByPetsName2() throws UserException {
        ClinicAsArrayList clinic = new ClinicAsArrayList();
        clinic.info();
        ArrayList<Client> clients = clinic.findClientByPetsName("Murka Mukha");
        for (Client client : clients) {
            System.out.println(client.getId() + " " + client.getPet().getName());
        }
    }

    @Test
    public void findClientById1() throws Exception {
        ClinicAsArrayList clinic = new ClinicAsArrayList();
        clinic.addNewClient(new Client("Ivanov", new Pet(new Cat("Vaska"))));
        clinic.addNewClient(new Client("Petrov", new Pet(new Dog("Kuska"))));
        clinic.addNewClient(new Client("Sidorov", new Pet(new CatDog(new Cat("Murka"), new Dog("Mukha")))));
        clinic.info();
        ArrayList<Client> clients = clinic.findClientById("Ivanov");
        for (Client client : clients) {
            System.out.println(client.getId() + " " + client.getPet().getName());
        }
    }

    @Test(expected = UserException.class)
    public void findClientById2() throws UserException {
        ClinicAsArrayList clinic = new ClinicAsArrayList();
        clinic.info();
        ArrayList<Client> clients = clinic.findClientById("Ivanov");
        for (Client client : clients) {
            System.out.println(client.getId() + " " + client.getPet().getName());
        }
    }

    @Test
    public void editClientId1() throws Exception {
        ClinicAsArrayList clinic = new ClinicAsArrayList();
        clinic.addNewClient(new Client("Ivanov", new Pet(new Cat("Vaska"))));
        clinic.addNewClient(new Client("Petrov", new Pet(new Dog("Kuska"))));
        clinic.addNewClient(new Client("Sidorov", new Pet(new CatDog(new Cat("Murka"), new Dog("Mukha")))));
        clinic.info();
        clinic.editClientId("Petrov", "Sokolov");
        clinic.info();
    }

    @Test(expected = UserException.class)
    public void editClientId2() throws UserException {
        ClinicAsArrayList clinic = new ClinicAsArrayList();
        clinic.info();
        clinic.editClientId("Petrov", "Sokolov");
        clinic.info();
    }

    @Test
    public void editPetsNameByClientId1() throws Exception {
        ClinicAsArrayList clinic = new ClinicAsArrayList();
        clinic.addNewClient(new Client("Ivanov", new Pet(new Cat("Vaska"))));
        clinic.addNewClient(new Client("Petrov", new Pet(new Dog("Kuska"))));
        clinic.addNewClient(new Client("Sidorov", new Pet(new CatDog(new Cat("Murka"), new Dog("Mukha")))));
        clinic.info();
        clinic.editPetsNameByClientId("Sidorov", "Cora Munya");
        clinic.info();
    }

    @Test(expected = UserException.class)
    public void editPetsNameByClientId2() throws UserException {
        ClinicAsArrayList clinic = new ClinicAsArrayList();
        clinic.info();
        clinic.editPetsNameByClientId("Sidorov", "Cora Munya");
        clinic.info();
    }

    @Test
    public void removeClientById1() throws Exception {
        ClinicAsArrayList clinic = new ClinicAsArrayList();
        clinic.addNewClient(new Client("Ivanov", new Pet(new Cat("Vaska"))));
        clinic.addNewClient(new Client("Ivanov", new Pet(new Dog("Kuska"))));
        clinic.addNewClient(new Client("Sidorov", new Pet(new CatDog(new Cat("Murka"), new Dog("Mukha")))));
        clinic.info();
        clinic.removeClientById("Ivanov");
        clinic.info();
    }

    @Test(expected = UserException.class)
    public void removeClientById2() throws UserException {
        ClinicAsArrayList clinic = new ClinicAsArrayList();
        clinic.info();
        clinic.removeClientById("Vaska");
        clinic.info();
    }

    @Test
    public void removePetFromClient1() throws Exception {
        ClinicAsArrayList clinic = new ClinicAsArrayList();
        clinic.addNewClient(new Client("Ivanov", new Pet(new Cat("Vaska"))));
        clinic.addNewClient(new Client("Ivanov", new Pet(new Dog("Kuska"))));
        clinic.addNewClient(new Client("Sidorov", new Pet(new CatDog(new Cat("Murka"), new Dog("Mukha")))));
        clinic.info();
        clinic.removePetFromClient("Ivanov");
        clinic.info();
    }

    @Test(expected = UserException.class)
    public void removePetFromClient2() throws UserException {
        ClinicAsArrayList clinic = new ClinicAsArrayList();
        clinic.info();
        clinic.removePetFromClient("Ivanov");
        clinic.info();
    }
}