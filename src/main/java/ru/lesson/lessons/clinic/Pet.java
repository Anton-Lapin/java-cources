package ru.lesson.lessons.clinic;

/**
 * Class implements Pet's variables and behaviors
 * @author Anton Lapin
 * @since March 16, 2018
 */

public class Pet {
    private Cat cat;
    private Dog dog;
    private CatDog catDog;

    public Pet(Cat cat) {
        this.cat = cat;
    }

    public Pet(Dog dog) {
        this.dog = dog;
    }

    public Pet(CatDog catDog) {
        this.catDog = catDog;
    }

    public Pet() {

    }

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
