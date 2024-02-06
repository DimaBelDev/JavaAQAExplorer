package ru.dima.study.lesson_8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordProcessor {

    public static List<String> buildUniqueListOfWords(String[] array){
        return Arrays.stream(array).distinct().collect(Collectors.toList());
    }

    public static Map<String, Long> countOfWords(String[] array){
        return Arrays.stream(array).collect(Collectors.groupingBy(String::new, Collectors.counting()));
    }
}
