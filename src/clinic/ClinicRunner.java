package clinic;

/**
 *
 * @author Anton Lapin
 * @sinse March 16, 2018
 */

import java.util.ArrayList;

public class ClinicRunner {

    public static void main(String[] args) {
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Client> clients1;
        Clinic clinic = new Clinic(clients);
        clinic.addNewClient(new Client("Ivanov", new Pet("Vaska")));
        clinic.addNewClient(new Client("Petrov", new Pet("Muska")));
        clinic.addNewClient(new Client("Sidorov", new Pet("Laska")));
        clinic.addNewClient(new Client("Fedorov", new Pet("Layka")));
        clinic.addNewClient(new Client("Nikiforov", new Pet("Muska")));
        clients1 = clinic.findClientByPetsName("Vaska");
        for (Client client: clients1) {
            System.out.println(client.getId() + " " + client.getPet().getName());
        }
        clients1 = clinic.findClientByPetsName("Muska");
        for (Client client: clients1) {
            System.out.println(client.getId() + " " + client.getPet().getName());
        }
    }
}
