package Exercise1.src;

import java.util.Map;

public class Student {
    private final String firstName;
    private final String lastName;
    private int numberCourse;
    Map<Subject, Double> scores;

    public Student(String firstName, String lastName,
                   int numberCourse, Map<Subject, Double> scores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberCourse = numberCourse;
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Student{" +
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", numberCourse=" + numberCourse +
               ", scores=" + scores +
               '}';
    }

    public double getAverageScore(){
        return scores.values().stream().
                mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNumberCourse() {
        return numberCourse;
    }

    public Map<Subject, Double> getScores() {
        return scores;
    }
}
