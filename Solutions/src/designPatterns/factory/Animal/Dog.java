package designPatterns.factory.Animal;

public class Dog implements Animal{
    @Override
    public void makeSound() {
        System.out.println("Dog is barking.");
    }

    @Override
    public void behaviour() {
        System.out.println("Behaving like a dog.");
    }
}
