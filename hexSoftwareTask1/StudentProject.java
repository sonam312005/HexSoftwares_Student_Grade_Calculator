import java.util.Scanner;

class Student {
    String name;
    int studentId;
    int[] grades;

    // Constructor
    Student(String name, int studentId, int[] grades) {
        this.name = name;
        this.studentId = studentId;
        this.grades = grades;
    }

    // Calculate average grade
    double calculateAverage() {
        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        return (double) sum / grades.length;
    }

    // Display grades
    void displayGrades() {
        System.out.print("Grades: ");
        for (int g : grades) {
            System.out.print(g + " ");
        }
        System.out.println();
    }

    // Pass or Fail
    void checkResult() {
        if (calculateAverage() >= 40) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }
}

public class StudentProject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Student[] students = new Student[n];
        double classTotal = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Name: ");
            sc.nextLine(); // consume newline
            String name = sc.nextLine();

            System.out.print("Student ID: ");
            int id = sc.nextInt();

            System.out.print("Number of subjects: ");
            int subjects = sc.nextInt();

            int[] grades = new int[subjects];
            for (int j = 0; j < subjects; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                grades[j] = sc.nextInt();
            }

            students[i] = new Student(name, id, grades);
            classTotal += students[i].calculateAverage();
        }

        // Display details
        System.out.println("\n--- Student Details ---");
        for (Student s : students) {
            System.out.println("\nName: " + s.name);
            System.out.println("Student ID: " + s.studentId);
            s.displayGrades();
            System.out.println("Average: " + s.calculateAverage());
            s.checkResult();
        }

        // Class average
        System.out.println("\nClass Average: " + (classTotal / n));
    }
}
