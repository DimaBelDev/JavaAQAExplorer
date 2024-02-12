package ru.dima.study.lesson_9.task_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginsProcess {

    public static void loginHandel(){
        List<String> enteredLogins = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите логин (пустая строка для завершения): ");
            String login = scanner.nextLine();

            if (login.trim().isEmpty())
                break;

            enteredLogins.add(login.trim());
        }

        displayValuesStartWithF(enteredLogins);
    }

    private static void displayValuesStartWithF(List<String> list) {
        list.stream().filter(a -> a.startsWith("f")).forEach(System.out::println);
    }



}
