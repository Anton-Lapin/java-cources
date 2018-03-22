package ru.lesson.lessons.clinic;

/**
 * This class implements Clinic
 * @author Anton Lapin
 * @since March 16, 2018
 */
public class Clinic {

    private final Client[] clients;

    /**
     * Constructor of this class
     * @param size
     */
    public Clinic(final int size) {
        this.clients = new Client[size];
    }

    /**
     * This method adds client's into clinic list
     * @param position in clinic list
     * @param client
     * @throws UserException if user enters incorrect position
     */
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

    /**
     * This method finds clients by pet's name
     * @param name of pet
     * @return clients list
     * @throws UserException if user enters incorrect pet's name
     */
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

    /**
     * This method finds clients by they id
     * @param id of client
     * @return client list
     * @throws UserException if user enters incorrect client's id
     */
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

    /**
     * This method edits client's id
     * @param oldId old client's id
     * @param newId new client's id
     */
    public void editClientsId(final String oldId, final String newId) {
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && this.clients[i].getId().equals(oldId)) {
                this.clients[i].setId(newId);
            }
        }
    }

    /**
     * This method edits pet's name by client's id
     * @param id client's id
     * @param newPetName new pet's name
     */
    public void editPetsNameByClientId(final String id, final String newPetName) {
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && this.clients[i].getId().equals(id)) {
                this.clients[i].getPet().setName(newPetName);
            }
        }
    }

    /**
     * This method removes client's by they id
     * @param id client's id
     */
    public void removeClientById(final String id) {
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && this.clients[i].getId().equals(id)) {
                this.clients[i] = null;
            }
        }
    }

    /**
     * This method removes pet form client by client's id
     * @param id client's id
     */
    public void removePetFromClient(final String id) {
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && this.clients[i].getId().equals(id)) {
                this.clients[i] = new Client(this.clients[i].getId(), new Pet());
            }
        }
    }

    /**
     * This method gets clients list
     * @return clients list
     */
    public Client[] getClients() {
        return this.clients;
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
        for (int i = 0; i < this.clients.length; i++) {
            if (clients[i] != null) {
                System.out.printf("%-1s%-5d%-32s%-26s%n","| ",i,"| " + clients[i].getId(),
                        "| " + clients[i].getPet().getName());
            }
        }
        System.out.println("+------+-------------------------------+------------------------+");
    }
}
