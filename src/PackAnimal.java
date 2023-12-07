import java.util.Date;

class PackAnimal extends Animal {
    private String cargoType;

    public PackAnimal(String name, Date birthDate, String cargoType) {
        super(name, birthDate);
        this.cargoType = cargoType;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Cargo Type: " + cargoType);
    }
}