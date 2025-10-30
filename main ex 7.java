import java.util.*;

class LengthException extends Exception {
    public LengthException(String message) {
        super(message);
    }
}

class FailedException extends Exception {
    public FailedException(String message) {
        super(message);
    }
}

class NotFirstClassException extends Exception {
    public NotFirstClassException(String message) {
        super(message);
    }
}

class Student {
    String name;
    int marks1, marks2, marks3;

    Student(String name, int m1, int m2, int m3) {
        this.name = name;
        this.marks1 = m1;
        this.marks2 = m2;
        this.marks3 = m3;
    }

    void checkDetails() throws LengthException, FailedException, NotFirstClassException {
        if (name.length() > 7) {
            throw new LengthException("Name length should not exceed 7 characters");
        }
        double avg = (marks1 + marks2 + marks3) / 3.0;
        System.out.println("Average Marks: " + avg);
        if (avg < 50) {
            throw new FailedException("Failed! Average below 50");
        } else if (avg < 75) {
            throw new NotFirstClassException("Not First Class! Average between 50 and 75");
        } else {
            System.out.println("First Class with Distinction!");
        }
    }
}

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter 3 subject marks: ");
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();
        Student s = new Student(name, m1, m2, m3);
        try {
            s.checkDetails();
        } catch (LengthException | FailedException | NotFirstClassException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}