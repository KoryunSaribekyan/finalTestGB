import java.util.Date;

class Animal {
    private String name;
    private Date birthDate;

    public Animal(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void printInfo() {
        System.out.println("Name: " + name + ", Birth Date: " + birthDate);
    }
}
