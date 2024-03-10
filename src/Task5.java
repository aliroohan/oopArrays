import java.util.Random;
import java.util.Scanner;

// Class to hold phone number details
class PhoneNumber{
    private String number;

    // Getter for phone number
    public String getNumber() {
        return number;
    }

    // Setter for phone number
    public void setNumber(String number) {
        this.number = number;
    }
}

// Class to hold student details
class Student{
    private int id; // Student's ID
    private String name; // Student's name
    private int[] marks; // Array to hold marks of each subject
    private PhoneNumber[] phone; // Array to hold phone numbers

    // Getters and setters for student details
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public PhoneNumber[] getPhone() {
        return phone;
    }

    // Constructor for student details
    public void setPhone(PhoneNumber[] phone) {
        this.phone = phone;
    }
    public Student(int id, String name, int[] marks, PhoneNumber[] phone) {
        setId(id);
        setName(name);
        setMarks(marks);
        setPhone(phone);
    }

    // Method to find the student with maximum marks
    public static int maxMarks(Student[] student){
        double max = student[0].getMarks()[0];
        int id = student[0].getId();
        for (Student value : student) {
            for (int j = 0; j < value.getMarks().length; j++) {
                if (value.getMarks()[j] > max) {
                    max = value.getMarks()[j];
                    id = value.getId();
                }
            }
        }
        return id;
    }

    // Method to calculate the average marks of all students
    public static double averageOfAllClass(Student[] student){
        double sum = 0;
        double avg;
        int subjects = 0;
        for (Student value : student) {
            subjects += value.getMarks().length;
            for (int j = 0; j < value.getMarks().length; j++) {
                sum += value.getMarks()[j];
            }
        }
        avg = sum/subjects;
        return avg;
    }

    // Method to find the student with maximum number of tests
    public static int maxNumberTest(Student []students){
        int maxTest = students[1].getMarks().length;
        int id = students[1].getId();
        for (int i = 1; i < students.length; i++){
            if (students[i].getMarks().length > maxTest){
                maxTest = students[i].getMarks().length;
                id = students[i].getId();
            }
        }
        return id;
    }

    // Method to calculate the average, minimum and maximum marks of a student
    public static double []avgMinMax(Student student){
        double []result = new double[3];
        result[0] = Task5.averageMarksOfEachStudent(student.getMarks());
        result[1] = Task5.minMarks(student.getMarks());
        result[2] = Task5.maxMarks(student.getMarks());
        return result;
    }
}

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        // Array to hold student objects

        int numberOfStudents;
        System.out.print("Enter Number of Students : ");
        numberOfStudents = scanner.nextInt();
        while (numberOfStudents > 50 || numberOfStudents < 1){
            System.out.print("Number of Student must be between 0 and 50 \nEnter Again : ");
            numberOfStudents = scanner.nextInt();
        }
        Student[] student = new Student[numberOfStudents];
        // Loop to get details of each student
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter Student "+(i+1)+" Details : ");
            System.out.print("Enter Student ID : ");
            int id = scanner.nextInt();
            System.out.print("Enter Student Name : ");
            String name = scanner.next();
            System.out.print("Enter Number of Subjects : ");
            int numberOfSubjects = scanner.nextInt();
            int []marks = new int[numberOfSubjects];
            // Loop to get marks of each subject
            for (int j = 0; j < numberOfSubjects; j++) {
//                System.out.print("Enter Marks of Subject "+(j+1)+" : ");
                marks[j] = random.nextInt(1,100);
            }
            System.out.println("Enter number of phone numbers");
            int numberOfPhoneNumbers = scanner.nextInt();
            PhoneNumber []phone = new PhoneNumber[numberOfPhoneNumbers];
            // Loop to get each phone number
            for (int j = 0; j < numberOfPhoneNumbers; j++) {
                System.out.print("Enter Phone Number "+(j+1)+" : ");
                String number = scanner.next();
                phone[j] = new PhoneNumber();
                phone[j].setNumber(number);
            }
            // Creating student object with the details
            student[i] = new Student(id,name,marks,phone);
        }
        // Loop to print details of each student
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Student "+(i+1)+" Details : ");
            System.out.println("ID : "+student[i].getId());
            System.out.println("Name : "+student[i].getName());
            System.out.println("Marks : ");
            for (int j = 0; j < student[i].getMarks().length; j++) {
                System.out.println("Subject "+(j+1)+" : "+student[i].getMarks()[j]);
            }
            System.out.println("Average Marks : " + averageMarksOfEachStudent(student[i].getMarks()));
            System.out.println("Average Marks (by passing Student): " + Student.avgMinMax(student[i])[0]);

            System.out.println("Minimum Marks : " + minMarks(student[i].getMarks()));
            System.out.println("Minimum Marks : " + Student.avgMinMax(student[i])[1]);

            System.out.println("Maximum Marks : " + maxMarks(student[i].getMarks()));
            System.out.println("Maximum Marks : " + Student.avgMinMax(student[i])[2]);
            System.out.println("Phone Numbers : ");
            for (int j = 0; j < student[i].getPhone().length; j++) {
                System.out.println("Phone Number "+(j+1)+" : "+student[i].getPhone()[j].getNumber());
            }
        }
        System.out.println("Id of student with Maximum Number of test : " + Student.maxNumberTest(student));

        System.out.print("The id of student who got Maximum marks is : ");
        System.out.println(Student.maxMarks(student));

        System.out.print("Overall average marks of all students : ");
        System.out.println(Student.averageOfAllClass(student));

        double [] marks= new double[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            marks[i] = averageMarksOfEachStudent(student[i].getMarks());
        }
        System.out.println("Id of student with maximum average : " + student[maxAverage(marks)].getId());

    }

    // Method to find the average marks of a student
    public static double averageMarksOfEachStudent(int[] marks){
        double sum = 0;
        double avg;
        int subjects = marks.length;
        for (int mark: marks){
            sum += mark;
        }
        avg = sum/subjects;
        return avg;
    }

    // Method to find the student with maximum average marks
    public static int maxAverage(double[] marks){
        double max = marks[0];
        int index = 0;
        for (int i = 1; i < marks.length; i++){
            if (marks[i] > max){
                max =marks[i];
                index = i;
            }
        }
        return index;
    }

    // Method to find the minimum marks of a student
    public static int minMarks(int[] mark){
        int min = mark[0];
        for (int i = 1; i < mark.length; i++) {
            if (mark[i] < min)
                min = mark[i];
        }
        return min;
    }

    // Method to find the maximum marks of a student
    public static int maxMarks(int[] mark){
        int max = mark[0];
        for (int i = 1; i < mark.length; i++) {
            if (mark[i] > max)
                max = mark[i];
        }
        return max;
    }
}