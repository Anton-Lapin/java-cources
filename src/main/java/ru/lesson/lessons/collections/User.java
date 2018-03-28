package ru.lesson.lessons.collections;

/**
 *
 */
public class User {

    private String name;
    private String id;
    private Pet pet;

    /**
     * Constructor
     * @param name
     * @param id
     * @param petName
     */
    public User(String name, String id, String petName) {
        this.name = name;
        this.id = id;
        this.pet = new Pet(petName);
    }

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Pet getPet() {
        return pet;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Inner class
     */
    public class Pet {
        private String name;

        public Pet(String name) {
            this.name = name;
        }
    }
}
