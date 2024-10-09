package Exercise1;

import Exercise1.src.StatisticObject;
import Exercise1.src.Student;
import Exercise1.src.Subject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentRunner {
    public static void main(String[] args) {
        Map<Subject, Double> scores1 = Map.of(
                Subject.Math, 5.0,
                Subject.Physik, 3.3,
                Subject.Literature, 4.4
        );
        Map<Subject, Double> scores2 = Map.of(
                Subject.Math, 3.0,
                Subject.Physik, 3.3,
                Subject.Literature, 4.0,
                Subject.Russian, 5.0
        );
        Map<Subject, Double> scores3 = Map.of(
                Subject.Math, 4.0,
                Subject.Physik, 3.0
        );
        Map<Subject, Double> scores4 = Map.of(
                Subject.Math, 5.0,
                Subject.Physik, 3.3,
                Subject.Chemistry, 4.5,
                Subject.Literature, 3.0
        );
        Map<Subject, Double> scores5 = Map.of(
                Subject.Math, 5.0,
                Subject.Physik, 5.0,
                Subject.Literature, 5.0,
                Subject.Russian, 5.0,
                Subject.Chemistry, 5.0
        );
        Student student1 = new Student("Ivan", "Ivanov", 2233, scores1);
        Student student2 = new Student("Sidor", "Sidorov", 2233, scores2);
        Student student3 = new Student("Alena", "Pirogova", 2211, scores3);
        Student student4 = new Student("Stepan", "Andreev", 2211, scores4);
        Student student5 = new Student("Egor", "Petrov", 2233, scores5);

        List<Student> students = List.of(student1, student2, student3, student4, student5);

        Map<Integer, List<Student>> groups = buildGroups(students);
        Map<Integer, Double> result1 = groups.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        value -> value.getValue().stream().mapToDouble(Student::getAverageScore).average().orElse(0)
                ));

        Map<Integer, List<String>> result2 = groups.entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                value -> value.getValue().stream().map(Student::getFullName).sorted().toList()
                        ));
        Map<Integer, StatisticObject> result3 = new HashMap<>();
        groups.keySet().forEach(value -> result3.put(value, new StatisticObject(result2.get(value), result1.get(value))));
        System.out.println(result1);
        System.out.println();
        System.out.println(result2);
        System.out.println();
        System.out.println(result3);
    }

    public static Map<Integer, List<Student>> buildGroups(List<Student> studentList) {
       return studentList.stream().collect(Collectors.groupingBy(
               Student::getNumberCourse,
                Collectors.mapping(value -> value, Collectors.toList())));

    }
}
