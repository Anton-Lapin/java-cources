package ru.lesson.lessons.clinic;

import java.util.ArrayList;

/**
 * This class implements clinic as Array List
 * @author Anton Lapin
 * @since March 24, 2018
 */
public class ClinicAsArrayList {

    private ArrayList<Client> clients;

    /**
     * Constructor of class
     */
    public ClinicAsArrayList() {
        this.clients = new ArrayList<Client>();
    }

    /**
     * This method adds clients into client's list
     * @param client
     */
    public void addNewClient(final Client client) {
        this.clients.add(client);
    }

    /**
     * This method finds clients into client's list by pets name
     * @param petsName
     * @return selected client's list
     * @throws UserException if client's list is empty
     */
    public ArrayList<Client> findClientByPetsName(final String petsName) throws UserException {
        ArrayList<Client> clientsByPetsName = new ArrayList<Client>();
        if (!this.clients.isEmpty()) {
            for (Client client : this.clients) {
                if (client.getPet().getName().equals(petsName)) {
                    clientsByPetsName.add(client);
                }
            }
        } else {
            throw new UserException("Clinic list is empty");
        }
        return clientsByPetsName;
    }

    /**
     * This method finds clients into client's list by id
     * @param clientId
     * @return selected client's list
     * @throws UserException if client's list is empty
     */
    public ArrayList<Client> findClientById(final String clientId) throws UserException {
        ArrayList<Client> clientsById = new ArrayList<Client>();
        if (!this.clients.isEmpty()) {
            for (Client client : this.clients) {
                if (client.getId().equals(clientId)) {
                    clientsById.add(client);
                }
            }
        } else {
            throw new UserException("Clinic list is empty");
        }
        return clientsById;
    }

    /**
     * This method edits client's id into client's list
     * @param oldId
     * @param newId
     * @throws UserException if client's list is empty
     */
    public void editClientId(final String oldId, final String newId) throws UserException {
        if (!this.clients.isEmpty()) {
            for (Client client : this.clients) {
                if (client.getId().equals(oldId)) {
                    client.setId(newId);
                }
            }
        } else {
            throw new UserException("Clinic list is empty");
        }
    }

    /**
     * This method edits pet's name into client's list by client's id
     * @param clientId
     * @param newPetsName
     * @throws UserException if client's list is empty
     */
    public void editPetsNameByClientId(final String clientId, final String newPetsName) throws UserException {
        if (!this.clients.isEmpty()) {
            for (Client client : this.clients) {
                if (client.getId().equals(clientId)) {
                    client.getPet().setName(newPetsName);
                }
            }
        } else {
            throw new UserException("Clinic list is empty");
        }
    }

    /**
     * This method removes clients from client's list by client's id
     * @param clientId
     * @throws UserException if client's list is empty
     */
    public void removeClientById(final String clientId) throws UserException {
        if (!this.clients.isEmpty()) {
            for (int i = this.clients.size() - 1; i >= 0; i--) {
                if (this.clients.get(i).getId().equals(clientId)) {
                    this.clients.remove(i);
                }
            }
        } else {
            throw new UserException("Clinic list is empty");
        }
    }

    /**
     * This method removes pets from client's list by client's id
     * @param clientId
     * @throws UserException if client's list is empty
     */
    public void removePetFromClient(final String clientId) throws UserException {
        if (!this.clients.isEmpty()) {
            for (Client client : this.clients) {
                if (client.getId().equals(clientId)) {
                    client.removePet();
                }
            }
        } else {
            throw new UserException("Clinic list is empty");
        }
    }

    /**
     * This method prints client's list
     */
    public void info() {
        System.out.println("=================================================================");
        System.out.println("|                     *CLINIC LIST INFO*                        |");
        System.out.println("=================================================================");
        System.out.printf("%-7s%-32s%-26s%n","| Id","| Client","| Pet");
        System.out.println("+------+-------------------------------+------------------------+");
        if (!this.clients.isEmpty()) {
            for (int i = 0; i < this.clients.size(); i++) {
                System.out.printf("%-1s%-5d%-32s%-26s%n", "| ", i, "| " + clients.get(i).getId(),
                        "| " + clients.get(i).getPet().getName());
            }
        } else {
            System.out.println("|                           *Empty*                             |");
        }
        System.out.println("+------+-------------------------------+------------------------+");
    }
}
