package ru.dima.study.lesson_8;

import java.util.*;

public class PhoneDirectory {
    private static final Map<String, List<String>> directory = new HashMap<>();


    public static void add(String lastName, String phoneNumber) {
        directory.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
    }

    public static List<String> get(String lastName) {
        return directory.getOrDefault(lastName, Collections.emptyList());
    }
}
