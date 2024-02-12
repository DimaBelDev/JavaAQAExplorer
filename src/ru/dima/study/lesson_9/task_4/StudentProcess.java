package ru.dima.study.lesson_9.task_4;

import ru.dima.study.lesson_9.task_4.Gender;
import ru.dima.study.lesson_9.task_4.Student;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StudentProcess {

    public static double avgAge(Collection<Student> students) {
        return students.stream()
                .filter(a -> a.getGender().equals(Gender.MAN))
                .map(Student::getAge)
                .mapToDouble(Integer::doubleValue)
                .average()
                .getAsDouble();
    }

    public static List<Student> checkAge(Collection<Student> students) {
        return students.stream()
                .filter(a-> (a.getAge() >= 18 && a.getAge() <= 27 && a.getGender().equals(Gender.MAN)))
                .collect(Collectors.toList());
    }

}
