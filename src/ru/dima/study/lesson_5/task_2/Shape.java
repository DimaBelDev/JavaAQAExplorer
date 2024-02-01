package ru.dima.study.lesson_5.task_2;

public interface Shape {
    double calculatePerimeter();

    double calculateArea();

    void setFillColor(String fillColor);

    void setBorderColor(String borderColor);

    void printCharacteristics();
}
