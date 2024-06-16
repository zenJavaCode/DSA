package designPatterns.factory.Animal;

public class Lion implements Animal{
    @Override
    public void makeSound() {
        System.out.println("Sher Dahad Rha hai !");
    }

    @Override
    public void behaviour() {
        System.out.println("Sher Dahad Rha hai !");
    }
}
