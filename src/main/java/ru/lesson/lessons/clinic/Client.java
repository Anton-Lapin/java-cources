package ru.lesson.lessons.clinic;

/**
 * This class implements Client
 * @author Anton Lapin
 * @since March 16, 2018
 */
public class Client {
    private String id;
    private Pet pet;

    /**
     * Full constructor of this class
     * @param id
     * @param pet
     */
    public Client(String id, Pet pet) {
        this.id = id;
        this.pet = pet;
    }

    /**
     * Default constructor of this class
     */
    public Client() {}

    /**
     * This method gets a pet
     * @return pet-object
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * This method gets client's id
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * This method sets client's id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method removes pet-object
     */
    public void removePet() {
        this.pet = new Pet();
    }
}
