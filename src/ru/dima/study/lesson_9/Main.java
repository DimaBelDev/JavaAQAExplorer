package ru.dima.study.lesson_9;

import ru.dima.study.lesson_9.task_1.ArrayProcessor;
import ru.dima.study.lesson_9.task_2_3.ArrayUtility;
import ru.dima.study.lesson_9.task_4.Gender;
import ru.dima.study.lesson_9.task_4.Student;
import ru.dima.study.lesson_9.task_4.StudentProcess;
import ru.dima.study.lesson_9.task_5.LoginsProcess;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int [] arr = ArrayProcessor.generationArr();
        List<String> list = Arrays.asList("Highload", "High", "Load", "Highload");
        List<String> listTwo = Arrays.asList("f10", "f15", "f2", "f4", "f4");
        List<String> emptyList = new ArrayList<>();
        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN)
                );

        //вывод рандомных значений
        System.out.println(Arrays.toString(arr));
        System.out.println("---------------------");
        //количество чётных чисел
        System.out.println(ArrayProcessor.countEvenNumbers(arr));
        System.out.println("---------------------");
        //сколько раз объект «High» встречается в коллекции
        System.out.println(ArrayUtility.countHighOccurrences(list));
        System.out.println("---------------------");
        //элемент в коллекции находится на первом месте
        System.out.println(ArrayUtility.getFirstElementOrZero(list));
        System.out.println("---------------------");
        //последний элемент
        System.out.println(ArrayUtility.getLastElementOrZero(list));
        System.out.println("---------------------");
        //сортировка строк по возрастанию и добавление их в массив
        System.out.println(Arrays.toString(ArrayUtility.sortAndConvertToArray(listTwo)));
        System.out.println("---------------------");
        //средний возраст студентов
        System.out.println(StudentProcess.avgAge(students));
        System.out.println("---------------------");
        //грозит получение повестки
        System.out.println(StudentProcess.checkAge(students));
        System.out.println("---------------------");
        //ввод различных логинов
        LoginsProcess.loginHandel();


    }


}
