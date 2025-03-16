package Bai8;

public class Garage {
    public static void main(String[] args) {
        Car[] car = new Car[] {
                new ElectricCar("Tesla Model 3", 2023, 50000),
                new GasCar("Toyota Camry", 2022, 35000),
                new ElectricCar("VinFast VF8", 2024, 45000),
                new GasCar("Ford Mustang", 2021, 60000)
        };

        for (Car c : car) {
            c.start();
            c.refuel();
            c.stop();
            System.out.println("==================================================");
        }
    }
}

