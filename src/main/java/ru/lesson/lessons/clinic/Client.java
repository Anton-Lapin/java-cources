package ru.lesson.lessons.clinic;

/**
 *
 * @author Anton Lapin
 * @since March 16, 2018
 */

public class Client {
    private String id;
    private Pet pet;

    public Client(String id, Pet pet) {
        this.id = id;
        this.pet = pet;
    }

    public Client() {}

    public Pet getPet() {
        return pet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void removePet() {
        this.pet = new Pet();
    }
}
