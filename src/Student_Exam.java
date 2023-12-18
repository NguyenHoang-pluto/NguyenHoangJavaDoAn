import java.util.Scanner;

public class Student_Exam {
    private String examID;
    private Student student;
    private String identifier; //số báo danh

    public Student_Exam() {
    }

    public Student_Exam(String examID, Student student, String identifier) {
        this.examID = examID;
        this.student = student;
        this.identifier = identifier;
    }

    public Student_Exam(Student_Exam other) {
        examID = other.examID;
        student = other.student;
        identifier = other.identifier;
    }

    public String getExamID() {
        return examID;
    }

    public String getIdentifier() {
        return identifier;
    }
    public Student getStudent() {
        return student;
    }

    public void setExamID(String examID) {
        this.examID = examID;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void input() {
        System.out.print("Input studen infor: ");
        student.input();
        System.out.print("Input Exam ID: ");
        Scanner scanner = new Scanner(System.in);
        examID = scanner.nextLine();
    }

    public void output() {
        System.out.println("\nExam ID: " + examID);
    }

}