package multithreading;

public class LiveLocks {

    private static class Spoon {
        private Diner owner;

        public Spoon(Diner d) { owner = d; }

        public synchronized void use() {
            System.out.printf("%s has eaten!", owner.name);
        }
    }
    private static class Diner {
        private final String name;
        private boolean isHungry;

        public Diner(String n) {
            name = n;
            isHungry = true;
        }

        public void eatWith(Spoon spoon, Diner spouse) {
            while (isHungry) {
                if (spoon.owner != this) {
                    try { Thread.sleep(1); } catch (InterruptedException e) {}
                    continue;
                }

                if (spouse.isHungry) {
                    System.out.printf("%s: You eat first my dear %s!%n", name, spouse.name);
                    spoon.owner = spouse;
                    continue;
                }

                spoon.use();
                isHungry = false;
                System.out.printf("%s: I am full!%n", name);
                spoon.owner = spouse;
            }
        }
    }

    public static void main(String[] args) {
        final Diner husband = new Diner("Husband");
        final Diner wife = new Diner("Wife");

        final Spoon spoon = new Spoon(husband);

        new Thread(() -> husband.eatWith(spoon, wife)).start();
        new Thread(() -> wife.eatWith(spoon, husband)).start();
    }
}
