package ru.dima.study.lesson_4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Ivan Ivanov", "Salesforce Developer", "ivanov@gmail.com", "+375291111111", 1000, 21);
        employees[1] = new Employee("Sergey Burak", "Marketer", "sergey@gmail.com", "+3752953445534", 700, 28);
        employees[2] = new Employee("Anastasia Ivleeva ", "HEAD", "ivleeva@gmail.com", "+375297777777", 50, 30);
        employees[3] = new Employee("Vika Ivanova", "Marketing Cloud Developer", "ivanoga@gmail.com", "+375296666454", 850, 25);
        employees[4] = new Employee("Sona Persuk", "CTO", "sona_1@gmail.com", "+37529999999", 1111, 24);

        Arrays.stream(employees).forEach(System.out::println);


        System.out.println("-----------------------------");

        Park park = new Park("Dreamland");

        park.addNewAttraction("Wave pool", "10:00", "19:00", 12);
        park.addNewAttraction("lazy river", "09:00", "18:00",8);

        park.removeByName("Wave pool");

        park.displayAttractions();
    }
}
