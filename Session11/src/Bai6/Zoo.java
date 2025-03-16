package Bai6;

public class Zoo {
    private Animal[] animals;

    public Zoo(Animal[] animals) {
        this.animals = animals;
    }

    public void showAnimals() {
        for (Animal animal : animals) {
            animal.sound();
            animal.move();
            System.out.println("=======================");
        }
    }
}