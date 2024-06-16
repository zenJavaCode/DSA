package comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SuperHero implements Comparable<SuperHero> {

    private final String id;
    private final String name;
    private final int age;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public SuperHero(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(final SuperHero superHero) {
        return this.id.compareTo(superHero.id);
    }

    public static void main(String[] args) {
        ArrayList<Integer> result = new ArrayList<>();

        SuperHero hero1 = new SuperHero("hero1", "Hanuman", 23);
        SuperHero hero2 = new SuperHero("hero2", "Superman", 30);
        SuperHero hero3 = new SuperHero("hero3", "Batman", 35);
        List<SuperHero> heroes = new ArrayList<>();
        heroes.add(hero1);
        heroes.add(hero2);
        heroes.add(hero3);
        Collections.sort(heroes);

        Comparator<SuperHero> ageComparator = Comparator.comparingInt(SuperHero::getAge).
                                            thenComparing(Comparator.comparing(SuperHero::getName,Comparator.reverseOrder()));
        Collections.sort(heroes, ageComparator);



    }
}