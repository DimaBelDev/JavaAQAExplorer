package ru.dima.study;

import java.util.List;

public class Lesson2 {
    public static void main(String[] args) {
        printThreeWords();
        System.out.println("------------------------------");
        checkSumSign();
        System.out.println("------------------------------");
        printColor();
        System.out.println("------------------------------");
        compareNumbers();
    }

    static void printThreeWords() {
        List.of("Orange","Banana", "Apple" ).forEach(System.out::println);
    }

    static void checkSumSign() {
        int a = 0;
        int b = -1;

        String sum = a + b >= 0 ? "Сумма положительная" : "Сумма отрицательная";
        System.out.println(sum);
    }

    static void printColor() {
        int value = 101;

        if (value <= 0)
            System.out.println("Красный");
        else if (value > 0 && value <= 100)
            System.out.println("Желтый");
        else if (value > 100)
            System.out.println("Зеленый");

    }

    static void compareNumbers() {
        int a = 1;
        int b = 2;

        String sum = a >= b ? "a >= b" : "a < b";

        System.out.println(sum);
    }
}
