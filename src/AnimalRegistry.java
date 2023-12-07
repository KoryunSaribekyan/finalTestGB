import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AnimalRegistry {
    private ArrayList<Animal> animals = new ArrayList<>();
    private int animalCounter = 0;

    public void addAnimal(Animal animal) {
        animals.add(animal);
        animalCounter++;
        System.out.println("Animal added to the registry.");
    }

    public void listCommands(Pet pet) {
        pet.printCommands();
    }

    public void trainCommand(Pet pet, String newCommand) {
        pet.train(newCommand);
    }

    public void listAnimalsByBirthDate() {
        animals.sort((a1, a2) -> a1.getBirthDate().compareTo(a2.getBirthDate()));
        for (Animal animal : animals) {
            animal.printInfo();
        }
    }

    public void printAnimalCounter() {
        System.out.println("Total number of animals: " + animalCounter);
    }

    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAnimal Registry Menu:");
            System.out.println("1. Add new animal");
            System.out.println("2. List commands for a pet");
            System.out.println("3. Train a new command for a pet");
            System.out.println("4. List animals by birth date");
            System.out.println("5. Print total number of animals");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter animal name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter birth date (yyyy-MM-dd): ");
                    String birthDateString = scanner.nextLine();
                    Date birthDate = java.sql.Date.valueOf(birthDateString);

                    System.out.println("Choose animal type: ");
                    System.out.println("1. Pet");
                    System.out.println("2. Pack Animal");
                    int animalTypeChoice = scanner.nextInt();

                    if (animalTypeChoice == 1) {
                        Pet pet = new Pet(name, birthDate);
                        registry.addAnimal(pet);
                    } else if (animalTypeChoice == 2) {
                        System.out.print("Enter cargo type: ");
                        String cargoType = scanner.next();
                        PackAnimal packAnimal = new PackAnimal(name, birthDate, cargoType);
                        registry.addAnimal(packAnimal);
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 2:
                    System.out.print("Enter pet name: ");
                    String petName = scanner.nextLine();
                    for (Animal animal : registry.animals) {
                        if (animal instanceof Pet && animal.getName().equals(petName)) {
                            registry.listCommands((Pet) animal);
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter pet name: ");
                    petName = scanner.nextLine();
                    for (Animal animal : registry.animals) {
                        if (animal instanceof Pet && animal.getName().equals(petName)) {
                            System.out.print("Enter new command: ");
                            String newCommand = scanner.nextLine();
                            registry.trainCommand((Pet) animal, newCommand);
                            break;
                        }
                    }
                    break;

                case 4:
                    registry.listAnimalsByBirthDate();
                    break;

                case 5:
                    registry.printAnimalCounter();
                    break;

                case 0:
                    System.out.println("Exiting the program.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}