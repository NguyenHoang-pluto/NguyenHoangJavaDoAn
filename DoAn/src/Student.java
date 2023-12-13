import java.util.Scanner;

public class Student extends Human{
    private String currentClass;
    private String ID;
    private String faculty;
    
    public Student() {
    }

    public Student(String ID, String faculty, String firstName, String lastName, String currentClass, String gender,
            String dateOfBirth) {
        super(firstName, lastName, gender, dateOfBirth);
        this.ID = ID;
        this.faculty =faculty;
        this.currentClass = currentClass;
    }

    public Student(Student other) {
        super(other);
        this.ID = other.ID;
        this.faculty = other.faculty;
        this.currentClass = other.currentClass;
    }

    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input ID: ");
        this.ID = scanner.nextLine();
        System.out.print("Input Faculty: ");
        this.faculty = scanner.nextLine();
        System.out.print("\nInput class: ");
        this.currentClass = scanner.nextLine();
    }

    public void output() {
        super.output();
        System.out.print("ID: ");
        System.out.println(this.ID);
        System.out.print("Student's faculty: ");
        System.out.println(this.faculty);
        System.out.print("Class: ");
        System.out.println(this.currentClass);
    }

    public String getCurrentClass() {
        return currentClass;
    }
    
    public void setClass(String StudentClass) {
        currentClass = StudentClass;
    }
    
    public String getId() {
        return ID;
    }

    public String getFaculty() {
        return faculty;
    }

    
    public void setId(String Student) {
        ID = Student;
    }

    public void setFaculty(String StudentFaculty) {
        faculty = StudentFaculty;
    }

}