package Bai6;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Lion("Lion 1", 10),
                new Lion("Lion 2", 8),
                new Elephant("Elephant 1", 10),
                new Elephant("Elephant 2", 12)
        };

        Zoo zoo = new Zoo(animals);
        zoo.showAnimals();
    }
}
