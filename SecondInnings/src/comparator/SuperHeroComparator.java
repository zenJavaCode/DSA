package comparator;

import comparable.SuperHero;

import java.util.Comparator;

public class SuperHeroComparator implements Comparator<SuperHero> {
    @Override
    public int compare(SuperHero hero1, SuperHero hero2) {
        // First, compare by age in ascending order
        int ageComparison = Integer.compare(hero1.getAge(), hero2.getAge());

        if (ageComparison != 0) {
            return ageComparison;
        }

        // If ages are equal, compare by name in descending order
        return hero2.getName().compareTo(hero1.getName());
    }
}
