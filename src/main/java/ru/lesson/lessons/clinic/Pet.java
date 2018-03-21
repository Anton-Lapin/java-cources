package ru.lesson.lessons.clinic;

/**
 * Class implements a Pet
 * @author Anton Lapin
 * @since March 16, 2018
 */

public class Pet {
    private Cat cat;
    private Dog dog;
    private CatDog catDog;

    /**
     * Constructor with cat's input param
     * @param cat
     */
    public Pet(Cat cat) {
        this.cat = cat;
    }

    /**
     * Constructor with dog's input param
     * @param dog
     */
    public Pet(Dog dog) {
        this.dog = dog;
    }

    /**
     * Constructor with catdog input param
     * @param catDog
     */
    public Pet(CatDog catDog) {
        this.catDog = catDog;
    }

    /**
     * Default constructor
     */
    public Pet() {

    }

    /**
     * This method gets pet's name
     * @return pet's name
     */
    public String getName() {
        String name = null;
        if(this.cat != null) {
            name = this.cat.getName();
        } else if (this.dog != null){
            name = this.dog.getName();
        } else if (this.catDog != null) {
            name = this.catDog.getCat().getName() + " " + this.catDog.getDog().getName();
        }
        return name;
    }

    /**
     * This method sets pet's name
     * @param name pet's name
     */
    public void setName(final String name) {
        if(this.cat != null) {
            this.cat.setName(name);
        } else if (this.dog != null){
            this.dog.setName(name);
        } else if (this.catDog != null) {
            try {
                String[] splitName = name.split(" ");
                this.catDog.getCat().setName(splitName[0]);
                this.catDog.getDog().setName(splitName[1]);
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Incorrect pet's name!");
            }
        }
    }
}
