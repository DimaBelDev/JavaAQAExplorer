package ru.dima.study.lesson_3;

import java.util.Collections;

public class Lesson3Methods {

    public static void main(String[] args) {

        System.out.println(isSumWithinRange(10, 10));
        System.out.println("----------------");
        printSign(-1);
        System.out.println("----------------");
        System.out.println(isNegative(0));
        System.out.println("----------------");
        printStrings("Hello World!", 3);
        System.out.println("----------------");
        System.out.println(isLeapYear(104));

    }

    static boolean isSumWithinRange(int a, int b) {
        return a + b >=10 && a + b <= 20;
    }

    static void printSign(int a) {
        System.out.println(a >= 0 ? "Положительное" : "Отрицательное");
    }

    static boolean isNegative(int a) {
        return a < 0;
    }

    static void printStrings(String inputString,  int repetitionCount) {
        Collections.nCopies(repetitionCount, inputString).forEach(System.out::println);
    }

    static boolean isLeapYear(int year) {
        return year % 4 == 0  && (year % 400 == 0 || year % 100 != 0);
    }


}
