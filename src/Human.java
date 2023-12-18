import java.util.Scanner;

public abstract class Human {
    private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;

    public Human() {
    }

    public Human(String firstName, String lastName, String gender,
            String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public Human(Human other) {
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.gender = other.gender;
        this.dateOfBirth = other.dateOfBirth;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nInput firstname: ");
        this.firstName = scanner.nextLine();
        System.out.print("\nInput lastname: ");
        this.lastName = scanner.nextLine();
        System.out.print("\nInput gender: ");
        this.gender = scanner.nextLine();
        System.out.print("\nInput date of birth: ");
        this.dateOfBirth = scanner.nextLine();
    }

    public void output() {
        System.out.print("Firstname: ");
        System.out.println(this.firstName);
        System.out.print("Lastname: ");
        System.out.println(this.lastName);
        System.out.print("Gender: ");
        System.out.println(this.gender);
        System.out.print("Date of birth: ");
        System.out.println(this.dateOfBirth);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getdateOfBirth() {
        return dateOfBirth;
    }

    public void setFirstName(String StudentFirstName) {
        firstName = StudentFirstName;
    }

    public void setLastName(String StudentLastName) {
        lastName = StudentLastName;
    }

    public void setGender(String StudentGender) {
        gender = StudentGender;
    }

    public void setdateOfBirth(String StudentDateOfBirth) {
        dateOfBirth = StudentDateOfBirth;
    }
}
