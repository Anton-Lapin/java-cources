package ru.lesson.lessons.clinic;

/**
 *
 * @author Anton Lapin
 * @since March 16, 2018
 */

public class Clinic {

    private final Client[] clients;

    public Clinic(final int size) {
        this.clients = new Client[size];
    }

    public void addNewClient(final int position, final Client client) throws UserException {
        try {
            if (this.clients[position] == null) {
                this.clients[position] = client;
            } else {
                throw new UserException("No vacation on this position!");
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("This position is not exists!");
        }
    }

    public Client[] findClientByPetsName(final String name) throws UserException {
        int size = this.clients.length;
        int count = 0;
        Client[] clientsByPetsName = new Client[size];
        for(int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && this.clients[i].getPet().getName().equals(name)) {
                clientsByPetsName[i] = this.clients[i];
                count++;
            }
        }
        if (count == 0) {
           throw new UserException("Nobody has pet with this name.");
        }
        return clientsByPetsName;
    }

    public Client[] findClientById(final String id) throws UserException {
        int size = this.clients.length;
        int count = 0;
        Client[] clientsById = new Client[size];
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && this.clients[i].getId().equals(id)) {
                clientsById[i] = this.clients[i];
                count++;
            }
        }
        if (count == 0) {
            throw new UserException("Nobody has this id.");
        }
        return clientsById;
    }

    public void editClientsId(final String oldId, final String newId) {
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && this.clients[i].getId().equals(oldId)) {
                this.clients[i].setId(newId);
            }
        }
    }

    public void editPetsNameByClientId(final String id, final String newPetName) {
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && this.clients[i].getId().equals(id)) {
                this.clients[i].getPet().setName(newPetName);
            }
        }
    }

    public void removeClientById(final String id) {
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && this.clients[i].getId().equals(id)) {
                this.clients[i] = null;
            }
        }
    }

    public void removePetFromClient(final String id) {
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && this.clients[i].getId().equals(id)) {
                this.clients[i] = new Client(this.clients[i].getId(), new Pet());
            }
        }
    }

    public Client[] getClients() {
        return this.clients;
    }

    public void info() {
        for (int i = 0; i < this.clients.length; i++) {
            if (clients[i] != null) {
                System.out.println("id: " + i + " client: " + clients[i].getId() +
                " pet: " + clients[i].getPet().getName());
            }
        }
    }
}
