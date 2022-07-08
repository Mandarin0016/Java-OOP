package multipleInheritance;

import hierarchicalInheritance.Animal;
import hierarchicalInheritance.Dog;

public class Main {
    public static void main(String[] args) {
        Puppy puppy = new Puppy();
        Animal dndndn = new Dog();
        puppy.eat();
        puppy.bark();
        puppy.weep();
    }
}
