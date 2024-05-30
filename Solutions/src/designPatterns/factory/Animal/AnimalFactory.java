package designPatterns.factory.Animal;

public class AnimalFactory {

    Animal getAnimal(AnimalType animalType){
        if(animalType == AnimalType.DOG){
            return new Dog();
        } else if (animalType == AnimalType.LION) {
            return new Lion();
        }else{
            throw new IllegalArgumentException();
        }
    }
}
