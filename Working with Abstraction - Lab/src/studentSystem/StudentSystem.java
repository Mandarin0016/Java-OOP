package studentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private final Map<String, Student> storage;

    public StudentSystem() {
        this.storage = new HashMap<>();
    }

    public void parseCommand(String[] args) {
        String name = args[1];
        switch (args[0]) {
            case "Create":
                int age = Integer.parseInt(args[2]);
                double grade = Double.parseDouble(args[3]);

                if (!storage.containsKey(name)) {
                    Student student = new Student(name, age, grade);
                    storage.put(name, student);
                }
                break;
            case "Show":
                if (storage.containsKey(name)) {
                    printStudent(storage.get(name));
                }
                break;
        }
    }

    private void printStudent(Student student) {
        String result = student + studentPerformance(student);
        System.out.println(result);
    }

    private String studentPerformance(Student student) {
        if (student.getGrade() >= 5.00) {
            return " Excellent student.";
        } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
            return " Average student.";
        } else {
            return " Very nice person.";
        }
    }
}
