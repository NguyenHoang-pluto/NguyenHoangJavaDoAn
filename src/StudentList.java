
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class StudentList {
    Student[] StudentArray;
    int n;
    
    public StudentList() {
        this.StudentArray = new Student[100];
        this.n = 0;
    }

    public Student[] getStudentArray() {
		return StudentArray;
	}

	public void setStudentArray(Student[] studentArray) {
		StudentArray = studentArray;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public void addStudent() {
        Student st = new Student();
        st.input();
        StudentArray[n] = st;
        n++;
    }

    public void addStudent(int number) {
        for (int i = 0; i < number; i++) {
            Student st = new Student();
            st.input();
            StudentArray[n] = st;
            n++;
        }
    }

    public void addStudent(Student other) {
        Student st = new Student(other);
        StudentArray[n] = st;
        n++;
    }

    public void addStudent(String id, String faculty, String firstName, String lastName, String currentClass,
            String gender,
            String dateOfBirth) {
        Student st = new Student(id, faculty, firstName, lastName, currentClass, gender, dateOfBirth);
        StudentArray[n] = st;
        n++;
    }

    public void printList() {
        System.out.println(
                "---------------------------------------------------------------------------------------------------");
        System.out.printf("| %-4s | %-10s | %-15s | %-15s | %-10s | %-8s | %-15s |\n",
                "ID", "Faculty", "First Name", "Last Name", "Class", "Gender", "Date of Birth");
        System.out.println(
                "---------------------------------------------------------------------------------------------------");

        for (int i = 0; i < this.n; i++) {
            Student st = this.StudentArray[i];
            System.out.printf("| %-4s | %-10s | %-15s | %-15s | %-10s | %-8s | %-15s |\n",
                    st.getId(), st.getFaculty(), st.getFirstName(), st.getLastName(),
                    st.getCurrentClass(), st.getGender(), st.getdateOfBirth());
        }

        System.out.println(
                "---------------------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\tTotal students: " + this.n + "\t\t\t\t\t  |");
        System.out.println(
                "---------------------------------------------------------------------------------------------------");
    }
    
    public void searchId(int n) {
    	for(int i = 0 ; i < this.n ; i++) {
    		if(n == i) {
    			System.out.println("Student " + (i + 1) + ":");
                Student st = this.StudentArray[i];
                System.out.println("\tid: " + st.getId());
                System.out.println("\tFaculty: " + st.getFaculty());
                System.out.println("\tFirst name: " + st.getFirstName());
                System.out.println("\tLast name: " + st.getLastName());
                System.out.println("\tClass: " + st.getCurrentClass());
                System.out.println("\tGender: " + st.getGender());
                System.out.println("\tdate of birth: " + st.getdateOfBirth());
    		}
    	}
    }
    
    // loi ne
//   public static void readFile(StudentList studentList) throws FileNotFoundException {
//              FileReader file = new FileReader("student-data.txt");
//             Scanner scanner = new Scanner(file);
//        try {
//             
//            while (scanner.hasNextLine()) {
//                String[] studentData = scanner.nextLine().split(",");
//                studentList.addStudent(studentData[0], studentData[1], studentData[2], studentData[3], studentData[4],
//                        studentData[5], studentData[6]);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public void readFile(String filePath) {
    	try (FileReader file = new FileReader(filePath); 
	            BufferedReader buffer = new BufferedReader(file)) {
            String line;
            n = 0;
            StudentArray = new Student[1];
            while ((line = buffer.readLine()) != null) {
                String[] data = new String[7];
                String[] parts = line.split(",");
                n++;
                StudentArray = Arrays.copyOf(StudentArray, n);
                // Copy dữ liệu từ parts vào mảng data
                for (int i = 0; i < parts.length; i++) {
                    data[i] = parts[i];
                }

                // Lưu mảng data vào StudentArray
                StudentArray[n - 1] = new Student(data[0], data[1],data[2],data[3],data[4],data[5],data[6]);
            }
        } catch (IOException ex) {
        	System.out.println("Loi khi mo File!");
        }
    }
   
   //
    public void insertList(StudentList otherList) {
        for (int i = 0; i < otherList.n; i++) {
            this.addStudent(otherList.StudentArray[i]);
        }
    }

    public void deleteById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Student id which you want to delete: ");
        String id = scanner.nextLine();
        int position = -1;
        for (int i = 0; i < n; i++) {
            if (StudentArray[i].getId().indexOf(id) == 0) {
                position = i;
                break;
            }
        }
        if (position != -1) {
            for (int j = position; j < n + 1; j++) {
                StudentArray[j] = StudentArray[j + 1];
            }
            StudentArray[n - 1] = null;
            n--;
            System.out.println("Student: " + id + "was deleted");
        } else {
            System.out.println("Didn't find " + id);
        }
    }

    public void deleteById(String id) {
        int position = -1;
        for (int i = 0; i < n; i++) {
            if (StudentArray[i].getId().indexOf(id) == 0) {
                position = i;
                break;
            }
        }
        if (position != -1) {
            for (int j = position; j < n + 1; j++) {
                StudentArray[j] = StudentArray[j + 1];
            }
            StudentArray[n - 1] = null;
            n--;
            System.out.println("Student: " + id + "was deleted");
        } else {
            System.out.println("Didn't find " + id);
        }
    }

    public void deleteByPosition(int position) {
        for (int j = position; j < n + 1; j++) {
            StudentArray[j] = StudentArray[j + 1];
        }
        StudentArray[n - 1] = null;
        n--;
        System.out.println("Student: " + position + "was deleted");
    }

    public void deleteByPosition() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input position where you want to delete: ");
        int position = scanner.nextInt();
        for (int j = position; j < n + 1; j++) {
            StudentArray[j] = StudentArray[j + 1];
        }
        StudentArray[n - 1] = null;
        n--;
        System.out.println("Student: " + position + "was deleted");
    }
    public void updateId(int id) {
    	Scanner scanner = new Scanner(System.in);
    	 int position = -1;
         for (int i = 0; i < n; i++) {
             if (Integer.parseInt(StudentArray[i].getId())  == id) {
                 position = i;
                 break;
             }
         }
         if (position != -1) {
             System.out.println("What information do you want to update?");
             System.out.println("1. id");
             System.out.println("2. First name");
             System.out.println("3. Last name");
             System.out.println("4. Class");
             System.out.println("5. Gender");
             System.out.println("6. date of birth");
             System.out.println("7. faculty");
             scanner.next();
             int option = scanner.nextInt();

             switch (option) {
                 case 1:
                     System.out.print("Input new id: ");
                     String newId = scanner.nextLine();
                     StudentArray[position].setId(newId);
                     break;
                 case 2:
                     System.out.print("Input new first name: ");
                     String newFirstName = scanner.nextLine();
                     StudentArray[position].setFirstName(newFirstName);
                     break;
                 case 3:
                     System.out.print("Input new last name: ");
                     String newLastName = scanner.nextLine();
                     StudentArray[position].setLastName(newLastName);
                     break;
                 case 4:
                     System.out.print("Input new class: ");
                     String newClass = scanner.nextLine();
                     StudentArray[position].setClass(newClass);
                     break;
                 case 5:
                     System.out.print("Input new gender: ");
                     String newGender = scanner.nextLine();
                     StudentArray[position].setGender(newGender);
                     break;
                 case 6:
                     System.out.print("Input new date of birth: ");
                     String newDateOfBirth = scanner.nextLine();
                     StudentArray[position].setdateOfBirth(newDateOfBirth);
                     break;
                 case 7:
                     System.out.print("Input new faculty: ");
                     String newFaculty = scanner.nextLine();
                     StudentArray[position].setFaculty(newFaculty);
                     break;
             }

             System.out.println("Student information has been updated successfully.");
         } 
    }
    
    public void updateInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Student id which you want to update: ");
        String id = scanner.nextLine();

        int position = -1;
        for (int i = 0; i < n; i++) {
            if (StudentArray[i].getId().equals(id)) {
                position = i;
                break;
            }
        }
        if (position != -1) {
            System.out.println("What information do you want to update?");
            System.out.println("1. id");
            System.out.println("2. First name");
            System.out.println("3. Last name");
            System.out.println("4. Class");
            System.out.println("5. Gender");
            System.out.println("6. date of birth");
            System.out.println("7. faculty");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Input new id: ");
                    String newId = scanner.nextLine();
                    StudentArray[position].setId(newId);
                    break;
                case 2:
                    System.out.print("Input new first name: ");
                    String newFirstName = scanner.nextLine();
                    StudentArray[position].setFirstName(newFirstName);
                    break;
                case 3:
                    System.out.print("Input new last name: ");
                    String newLastName = scanner.nextLine();
                    StudentArray[position].setLastName(newLastName);
                    break;
                case 4:
                    System.out.print("Input new class: ");
                    String newClass = scanner.nextLine();
                    StudentArray[position].setClass(newClass);
                    break;
                case 5:
                    System.out.print("Input new gender: ");
                    String newGender = scanner.nextLine();
                    StudentArray[position].setGender(newGender);
                    break;
                case 6:
                    System.out.print("Input new date of birth: ");
                    String newDateOfBirth = scanner.nextLine();
                    StudentArray[position].setdateOfBirth(newDateOfBirth);
                    break;
                case 7:
                    System.out.print("Input new faculty: ");
                    String newFaculty = scanner.nextLine();
                    StudentArray[position].setFaculty(newFaculty);
                    break;
            }

            System.out.println("Student information has been updated successfully.");
        } else {
            System.out.println("Didn't find " + id);
        }
    }

    public void searchStudents() {
        StudentList results = new StudentList();
        System.out.println("Select search criteria:");
        System.out.println("1. id");
        System.out.println("2. First name");
        System.out.println("3. Last name");
        System.out.println("4. Class");
        System.out.println("5. Gender");
        System.out.println("6. date of birth");
        System.out.println("7. faculty");
        System.out.print("Select search option: ");
        Scanner scanner = new Scanner(System.in);
        int option = Integer.parseInt(scanner.nextLine());

        switch (option) {
            case 1:
                System.out.print("Input Student id: ");
                String id = scanner.nextLine();
                results = searchStudentsById(id);
                break;
            case 2:
                System.out.print("Input first name: ");
                String firstName = scanner.nextLine();
                results = searchStudentsByFirstName(firstName);
                break;
            case 3:
                System.out.print("Input last name: ");
                String lastName = scanner.nextLine();
                results = searchStudentsByLastName(lastName);
                break;
            case 4:
                System.out.print("Input class: ");
                String classId = scanner.nextLine();
                results = searchStudentsByClass(classId);
                break;
            case 5:
                System.out.print("Input gender: ");
                String gender = scanner.nextLine();
                results = searchStudentsByGender(gender);
                break;
            case 6:
                System.out.print("Input date of birth: ");
                String dateOfBirth = scanner.nextLine();
                results = searchStudentsByDateOfBirth(dateOfBirth);
                break;
            case 7:
                System.out.print("Input faculty: ");
                String faculty = scanner.nextLine();
                results = searchStudentsByFaculty(faculty);
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
        results.printList();
        System.out.println("Do you want to search students continuously?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("You choose: ");
        int option1 = Integer.parseInt(scanner.nextLine());
        switch (option1) {
            case 1:
                results.searchStudents();
                break;
            case 2:
                return;
        }
    }

    public StudentList searchStudentsById(String id) {
        StudentList results = new StudentList();
        for (int i = 0; i < n; i++) {
            if (StudentArray[i].getId().equals(id)) {
                results.addStudent(StudentArray[i]);
            }
        }

        return results;
    }
    public StudentList searchStudentsByFirstName(String firstName) {
        StudentList results = new StudentList();
        for (int i = 0; i < n; i++) {
            if (StudentArray[i].getFirstName().contains(firstName)) {
                results.addStudent(StudentArray[i]);
            }
        }

        return results;
    }

    public StudentList searchStudentsByLastName(String lastName) {
        StudentList results = new StudentList();
        for (int i = 0; i < n; i++) {
            if (StudentArray[i].getLastName().contains(lastName)) {
                results.addStudent(StudentArray[i]);
            }
        }

        return results;
    }

    public StudentList searchStudentsByClass(String classId) {
        StudentList results = new StudentList();
        for (int i = 0; i < n; i++) {
            if (StudentArray[i].getCurrentClass().equals(classId)) {
                results.addStudent(StudentArray[i]);
            }
        }

        return results;
    }

    public StudentList searchStudentsByGender(String gender) {
        StudentList results = new StudentList();
        for (int i = 0; i < n; i++) {
            if (StudentArray[i].getGender().equals(gender)) {
                results.addStudent(StudentArray[i]);
            }
        }

        return results;
    }

    public StudentList searchStudentsByDateOfBirth(String dateOfBirth) {
        StudentList results = new StudentList();
        for (int i = 0; i < n; i++) {
            if (StudentArray[i].getdateOfBirth().equals(dateOfBirth)) {
                results.addStudent(StudentArray[i]);
            }
        }

        return results;
    }

    public StudentList searchStudentsByFaculty(String faculty) {
        StudentList results = new StudentList();
        for (int i = 0; i < n; i++) {
            if (StudentArray[i].getFaculty().equals(faculty)) {
                results.addStudent(StudentArray[i]);
            }
        }

        return results;
    }
 
    public StudentList statistics() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select statistics criteria:");
        System.out.println("1. Class");
        System.out.println("2. Faculty");
        System.out.println("3. Gender");
        System.out.print("Select statistics option: ");
        int option = Integer.parseInt(scanner.nextLine());
        StudentList result = new StudentList();
        switch (option) {
            case 1:
                System.out.println("Do you want to print individual students?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.print("Select option: ");
                int option1 = Integer.parseInt(scanner.nextLine());
                switch (option1) {
                    case 1:
                        statisticsByClassIndividually();
                        break;
                    case 2:
                        statisticsByClass();
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
                break;
            case 2:
                System.out.println("Do you want to print individual students in a faculty?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.print("Select option: ");
                int option2 = Integer.parseInt(scanner.nextLine());
                switch (option2) {
                    case 1:
                        statisticsByFacultyIndividually();
                        break;
                    case 2:
                        statisticsByFaculty();
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
                break;
            case 3:
                System.out.println("Do you want to print individual students in a faculty?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.print("Select option: ");
                int option3 = Integer.parseInt(scanner.nextLine());
                switch (option3) {
                    case 1:
                        statisticsByGenderIndividually();
                        break;
                    case 2:
                        statisticsByGender();
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
        return result;
    }

    public void statisticsByClass() {
        String[] classArray = new String[StudentArray.length];
        int m = 0;
        for (int i = 0; i < n; i++) {
boolean found = false;
            for (int j = 0; j < m; j++) {
                if (StudentArray[i].getCurrentClass().equals(classArray[j])) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                classArray[m] = StudentArray[i].getCurrentClass();
                m++;
            }
        }
        System.out.println("----------------------\nStatistic by class:");
        System.out.printf("| %-10s | %-8s |\n", "Class", "Students");
        System.out.println("----------------------");
        for (int i = 0; i < m; i++) {
            StudentList result = new StudentList();
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (StudentArray[j].getCurrentClass().equals(classArray[i])) {
                    result.addStudent(StudentArray[j]);
                    count++;
                }
            }
            System.out.printf("| %-10s | %-8s |\n", classArray[i], count);
        }
    }

    public void statisticsByClassIndividually() {
        String[] classArray = new String[StudentArray.length];
        int m = 0;
        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = 0; j < m; j++) {
                if (StudentArray[i].getCurrentClass().equals(classArray[j])) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                classArray[m] = StudentArray[i].getCurrentClass();
                m++;
            }
        }
        System.out.println("----------------------\nStatistic by class:");
        System.out.printf("| %-10s | %-8s |\n", "Class", "Students");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = 0; i < m; i++) {
            StudentList result = new StudentList();
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (StudentArray[j].getCurrentClass().equals(classArray[i])) {
                    result.addStudent(StudentArray[j]);
                    count++;
                }
            }
            System.out.printf("| %-10s | %-56s |\n", classArray[i], count);
            if (count > 0) {
                System.out.println("-------------------------------------------------------------------------");
                System.out.printf("| %-4s | %-15s | %-15s | %-8s | %-15s |\n",
                        "ID", "First Name", "Last Name", "Gender", "Date of Birth");
                System.out.println("-------------------------------------------------------------------------");
            }
            for (int k = 0; k < count; k++) {
                Student student = result.StudentArray[k];
                System.out.printf("| %-4s | %-15s | %-15s | %-8s | %-15s |\n",
                        student.getId(), student.getFirstName(), student.getLastName(),
student.getGender(), student.getdateOfBirth());

            }
            System.out.println("-------------------------------------------------------------------------");
            System.out.printf("| %-69s |\n",
                    "Total: " + count);
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("\n");
            System.out.println("-------------------------------------------------------------------------");
        }
    }

    public void statisticsByFaculty() {
        String[] facultyArray = new String[StudentArray.length];
        int m = 0;
        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = 0; j < m; j++) {
                if (StudentArray[i].getFaculty().equals(facultyArray[j])) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                facultyArray[m] = StudentArray[i].getFaculty();
                m++;
            }
        }
        System.out.println("-------------------------\nStatistic by faculty:");
        System.out.printf("| %-10s | %-8s |\n", "faculty", "Students");
        System.out.println("-------------------------");
        for (int i = 0; i < m; i++) {
            StudentList result = new StudentList();
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (StudentArray[j].getFaculty().equals(facultyArray[i])) {
                    result.addStudent(StudentArray[j]);
                    count++;
                }
            }
            System.out.printf("| %-10s | %-8s |\n", facultyArray[i], count);
        }
        System.out.println("-------------------------");
    }

    public void statisticsByFacultyIndividually() {
        String[] facultyArray = new String[StudentArray.length];
        int m = 0;
        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = 0; j < m; j++) {
                if (StudentArray[i].getFaculty().equals(facultyArray[j])) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                facultyArray[m] = StudentArray[i].getFaculty();
                m++;
            }
        }
        System.out.println("----------------------\nStatistic by faculty individually:");
        System.out.printf("| %-10s | %-8s |\n", "Faculty", "Students");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = 0; i < m; i++) {
            StudentList result = new StudentList();
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (StudentArray[j].getFaculty().equals(facultyArray[i])) {
                    result.addStudent(StudentArray[j]);
                    count++;
                }
            }
System.out.printf("| %-10s | %-56s |\n", facultyArray[i], count);
            if (count > 0) {
                System.out.println("-------------------------------------------------------------------------");
                System.out.printf("| %-4s | %-15s | %-15s | %-8s | %-15s |\n",
                        "ID", "First Name", "Last Name", "Gender", "Date of Birth");
                System.out.println("-------------------------------------------------------------------------");
            }
            for (int k = 0; k < count; k++) {
                Student student = result.StudentArray[k];
                System.out.printf("| %-4s | %-15s | %-15s | %-8s | %-15s |\n",
                        student.getId(), student.getFirstName(), student.getLastName(),
                        student.getGender(), student.getdateOfBirth());

            }
            System.out.println("-------------------------------------------------------------------------");
            System.out.printf("| %-69s |\n",
                    "Total: " + count);
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("\n");
            System.out.println("-------------------------------------------------------------------------");
        }
    }

    public void statisticsByGender() {
        String[] genderArray = new String[StudentArray.length];
        int m = 0;
        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = 0; j < m; j++) {
                if (StudentArray[i].getGender().equals(genderArray[j])) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                genderArray[m] = StudentArray[i].getGender();
                m++;
            }
        }
        System.out.println("-------------------------\nStatistic by gender:");
        System.out.printf("| %-10s | %-8s |\n", "gender", "Students");
        System.out.println("-------------------------");
        for (int i = 0; i < m; i++) {
            StudentList result = new StudentList();
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (StudentArray[j].getGender().equals(genderArray[i])) {
                    result.addStudent(StudentArray[j]);
                    count++;
                }
            }
            System.out.printf("| %-10s | %-8s |\n", genderArray[i], count);
        }
        System.out.println("-------------------------");
    }

    public void statisticsByGenderIndividually() {
        String[] genderArray = new String[StudentArray.length];
        int m = 0;
        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = 0; j < m; j++) {
                if (StudentArray[i].getGender().equals(genderArray[j])) {
                    found = true;
                    break;
                }
            }
if (!found) {
                genderArray[m] = StudentArray[i].getGender();
                m++;
            }
        }
        System.out.println("----------------------\nStatistic by gender individually:");
        System.out.printf("| %-10s | %-8s |\n", "Gender", "Students");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = 0; i < m; i++) {
            StudentList result = new StudentList();
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (StudentArray[j].getGender().equals(genderArray[i])) {
                    result.addStudent(StudentArray[j]);
                    count++;
                }
            }
            System.out.printf("| %-10s | %-56s |\n", genderArray[i], count);
            if (count > 0) {
                System.out.println("-------------------------------------------------------------------------");
                System.out.printf("| %-4s | %-15s | %-15s | %-8s | %-15s |\n",
                        "ID", "First Name", "Last Name", "Gender", "Date of Birth");
                System.out.println("-------------------------------------------------------------------------");
            }
            for (int k = 0; k < count; k++) {
                Student student = result.StudentArray[k];
                System.out.printf("| %-4s | %-15s | %-15s | %-8s | %-15s |\n",
                        student.getId(), student.getFirstName(), student.getLastName(),
                        student.getGender(), student.getdateOfBirth());

            }
            System.out.println("-------------------------------------------------------------------------");
            System.out.printf("| %-69s |\n",
                    "Total: " + count);
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("\n");
            System.out.println("-------------------------------------------------------------------------");
        }
    }

    

}