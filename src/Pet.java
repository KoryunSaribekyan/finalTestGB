import java.util.ArrayList;
import java.util.Date;

class Pet extends Animal {
    private ArrayList<String> commands;

    public Pet(String name, Date birthDate) {
        super(name, birthDate);
        this.commands = new ArrayList<>();
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public void printCommands() {
        System.out.println("Commands for " + getName() + ": " + commands);
    }

    public void train(String newCommand) {
        addCommand(newCommand);
        System.out.println(getName() + " learned a new command: " + newCommand);
    }
}