import java.util.Objects;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int tuitionYear;
    private String studentID;
    private String courses;
    private int tuitionBalance = 0;
    private static int costOfCourse = 1200;
    private static int id = 1000;


    // Constructor: prompt user to enter student's name and year
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter student first name: ");
        this.firstName = in.nextLine();

        System.out.println("Enter student last name: ");
        this.lastName = in.nextLine();

        System.out.println("1 - first year \n2 - second year \n3 - third year \n4 - fourth year \nEnter student grade level: ");
        this.tuitionYear = in.nextInt();

        setStudentID();
    }


    // Generate an ID
    private void setStudentID() {
        // Grade level + ID
        id++;
        this.studentID = tuitionYear + "" + id;
    }


    // Enroll in courses
    public void enroll() {
        do {
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();

            if (!Objects.equals(course, "Q")) {
                courses = courses + "\n  " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            }
            else {
                break;
            }
        } while (1 != 0);
    }


    // View balance
    public void viewBalance() {
        System.out.println("\nYour balance is: R" + tuitionBalance);
    }


    // Pay tuition
    public void payTuition() {
        viewBalance();
        System.out.print("Enter your payment: R");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();

        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of R" + payment);
        viewBalance();
    }


    // Show status
    public String showInfo() {
        return "\nName: " + firstName + " " + lastName +
                "\nGrade level: " + tuitionYear +
                "\nstudent ID: " + studentID +
                "\nCourses enrolled: " + courses +
                "\nBalance: R" + tuitionBalance;
    }
}
