package ru.dima.study.lesson_5.task_2;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.setFillColor("Красный");
        circle.setBorderColor("Черный");
        circle.printCharacteristics();
        System.out.println("-------------------------------");
        Rectangle rectangle = new Rectangle(4, 6);
        rectangle.setFillColor("Синий");
        rectangle.setBorderColor("Зеленый");
        rectangle.printCharacteristics();
        System.out.println("-------------------------------");
        Triangle triangle = new Triangle(3, 4, 5);
        triangle.setFillColor("Желтый");
        triangle.setBorderColor("Фиолетовый");
        triangle.printCharacteristics();
    }
}
