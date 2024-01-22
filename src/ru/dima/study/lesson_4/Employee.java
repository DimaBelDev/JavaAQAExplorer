package ru.dima.study.lesson_4;


public class Employee {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private long salary;
    private int age;

    public Employee(String name, String position, String email, String phoneNumber, long salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

   // i just overridden the toString method to display information about an individual
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
