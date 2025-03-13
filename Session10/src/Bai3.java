import java.time.Year;

class Car {
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        setYear(year);
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        int currentYear = Year.now().getValue();
        if (year > currentYear) {
            System.out.println("Năm sản xuất không hợp lệ! Đặt về năm hiện tại.");
            this.year = currentYear;
        } else {
            this.year = year;
        }
    }

    public void displayCarInfo() {
        System.out.println("Car Info: " + make + " " + model + " (" + year + ")");
    }
}

public class Bai3 {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", "Corolla", 2022);
        myCar.displayCarInfo();

        myCar.setMake("Honda");
        myCar.setModel("Civic");
        myCar.setYear(2025);

        myCar.displayCarInfo();
    }
}

