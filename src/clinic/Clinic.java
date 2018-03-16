package clinic;

/**
 *
 * @author Anton Lapin
 * @since March 16, 2018
 */

import java.util.ArrayList;

public class Clinic {
    private ArrayList<Client> clients;

    public Clinic(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public void addNewClient(Client client) {
        this.clients.add(client);
    }

    public ArrayList<Client> findClientByPetsName(String name) {
        ArrayList<Client> clientsByPetsName = new ArrayList<>();
        for (int i = 0; i < clients.size(); i++) {
            if(clients.get(i).getPet().getName().equals(name)) {
                clientsByPetsName.add(new Client(clients.get(i).getId(), clients.get(i).getPet()));
            }
        }
        return clientsByPetsName;
    }

    public ArrayList<Client> findClientById(String id) {
        ArrayList<Client> clientsById = new ArrayList<>();
        for (int i = 0; i < clients.size(); i++) {
            if(clients.get(i).getId().equals(id)) {
                clientsById.add(new Client(clients.get(i).getId(), clients.get(i).getPet()));
            }
        }
        return clientsById;
    }

    public void editClietsId(String oldId, String newId) {
        for (int i = 0; i < clients.size(); i++) {
            if(clients.get(i).getId().equals(oldId)) {
                clients.get(i).setId(newId);
            }
        }
    }

    public void editPetsNameByClientsId(String id, String newPetsName) {
        for (int i = 0; i < clients.size(); i++) {
            if(clients.get(i).getId().equals(id)) {
                clients.get(i).getPet().setName(newPetsName);
            }
        }
    }

    public void removeClientById(String id) {
        for (int i = 0; i < clients.size(); i++) {
            if(clients.get(i).getId().equals(id)) {
                clients.remove(i);
            }
        }
    }

    public void removePetFromClient(String id) {
        for (int i = 0; i < clients.size(); i++) {
            if(clients.get(i).getId().equals(id)) {
                clients.get(i).removePet();
            }
        }
    }

    public ArrayList<Client> getClients() {
        return clients;
    }
}
