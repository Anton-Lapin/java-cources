package clinic;

/**
 *
 * @author Anton Lapin
 * @since March 16, 2018
 */

import java.util.ArrayList;

public class Clinic {

    private final Client[] clients;

    public Clinic(final int size) {
        this.clients = new Client[size];
    }

    public void addNewClient(final int position, final Client client) {
        if (this.clients[position] == null) {
            this.clients[position] = client;
        } else {
            System.out.println("No vacation on this position!");
        }
    }

    public ArrayList<Client> findClientByPetsName(final String name) {
        ArrayList<Client> clientsByPetsName = new ArrayList<>();
        for(int i = 0; i < this.clients.length; i++) {
            if (this.clients[i].getPet().getName().equals(name)) {
                clientsByPetsName.add(this.clients[i]);
            }
        }
        return clientsByPetsName;
    }

    public ArrayList<Client> findClientById(final String id) {
        ArrayList<Client> clientsById = new ArrayList<>();
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i].getId().equals(id)) {
                clientsById.add(this.clients[i]);
            }
        }
        return clientsById;
    }

    public void editClientsId(final String oldId, final String newId) {
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i].getId().equals(oldId)) {
                this.clients[i].setId(newId);
            }
        }
    }

    public void editPetsNameByClientId(final String id, final String newPetName) {
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i].getId().equals(id)) {
                this.clients[i].getPet().setName(newPetName);
            }
        }
    }

    public void removeClientById(final String id) {
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i].getId().equals(id)) {
                this.clients[i] = new Client();
            }
        }
    }

    public void removePetFromClient(final String id) {
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i].getId().equals(id)) {
                this.clients[i] = new Client(this.clients[i].getId(), new Pet());
            }
        }
    }

    public Client[] getClients() {
        return this.clients;
    }
}
