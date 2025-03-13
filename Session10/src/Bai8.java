class Animals {
    protected String name;
    protected int age;

    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Tên: " + name + ", Tuổi: " + age);
    }

    public String makeSound() {
        return "Some generic sound";
    }
}

class Dog extends Animals {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = (breed == null || breed.trim().isEmpty()) ? "Unknown Breed" : breed;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Giống chó: " + breed);
    }

    @Override
    public String makeSound() {
        return "Woof Woof";
    }
}

class Cat extends Animals {
    private String furColor;

    // Constructor
    public Cat(String name, int age, String furColor) {
        super(name, age);
        this.furColor = (furColor == null || furColor.trim().isEmpty()) ? "Unknown Color" : furColor;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Màu lông: " + furColor);
    }

    @Override
    public String makeSound() {
        return "Meow Meow";
    }
}

public class Bai8 {
    public static void main(String[] args) {
        Animals[] animals = {
                new Dog("Đen", 3, "Ngao Tây Tạng"),
                new Cat("Tỏn", 2, "Trắng - đen")
        };

        for (Animals animal : animals) {
            animal.displayInfo();
            System.out.println("Âm thanh: " + animal.makeSound());
            System.out.println();
        }
    }
}
