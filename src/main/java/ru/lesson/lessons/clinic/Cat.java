package ru.lesson.lessons.clinic;

/**
 * This class implements a cat-object
 * @author Anton Lapin
 * @since March 21, 2018
 */
public class Cat {
    private String name;

    /**
     * Constructor of this class
     * @param name
     */
    public Cat(String name) {
        this.name = name;
    }

    /**
     * This method gets cat's name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets cat's name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
