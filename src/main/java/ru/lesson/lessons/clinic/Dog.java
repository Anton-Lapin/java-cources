package ru.lesson.lessons.clinic;

/**
 * This class implements a Dog
 */
public class Dog {

    private String name;

    /**
     * Constructor of this class
     * @param name of dog
     */
    public Dog(String name) {
        this.name = name;
    }

    /**
     * This method gets dog's name
     * @return dog's name
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets dog's name
     * @param name dog's name
     */
    public void setName(String name) {
        this.name = name;
    }
}
