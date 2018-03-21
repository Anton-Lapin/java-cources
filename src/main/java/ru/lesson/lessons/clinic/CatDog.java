package ru.lesson.lessons.clinic;

/**
 * This class implements CatDog-object
 * @author Anton Lapin
 * @since March 21, 2018
 */
public class CatDog {

    private Cat cat;
    private Dog dog;

    /**
     * Constructor of this class
     * @param cat
     * @param dog
     */
    public CatDog(Cat cat, Dog dog) {
        this.cat = cat;
        this.dog = dog;
    }

    /**
     * This method gets a cat
     * @return cat-object
     */
    public Cat getCat() {
        return cat;
    }

    /**
     * This method sets a cat
     * @param cat
     */
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    /**
     * This method gets a dog
     * @return dog-object
     */
    public Dog getDog() {
        return dog;
    }

    /**
     * This method sets a dog
     * @param dog
     */
    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
