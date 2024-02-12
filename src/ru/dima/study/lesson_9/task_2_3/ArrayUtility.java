package ru.dima.study.lesson_9.task_2_3;

import java.util.Comparator;
import java.util.List;

public class ArrayUtility {

    public static long countHighOccurrences(List<String> elements) {
        return elements.stream()
                .filter(a -> a.equals("High"))
                .count();
    }

    public static String getFirstElementOrZero(List<String> elements) {
        return elements.stream()
                .findFirst()
                .orElse("0");
    }

    public static String getLastElementOrZero(List<String> elements) {
        return elements.stream()
                .reduce((first, last) -> last)
                .orElse("0");
    }


    public static String[] sortAndConvertToArray(List<String> elements) {
        return elements.stream()
                .sorted(Comparator.comparingInt(String::length)).
                toArray(String[]::new);
    }

}
