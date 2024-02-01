package ru.dima.study.lesson_5.task_1;

public abstract class Animal {

    private static int count = 0;
    private String name;

    public Animal(String name){
        this.name = name;
        count++;
    }

    public void run(int meter, int limitRunMeter) {
        if(meter < 0) {
            System.out.println("Вы указали отрицательное значение");
        } else if (meter <= limitRunMeter) {
            System.out.printf("%s пробежал %d м.%n", getName(), meter);
        } else {
            int restDistance = meter - limitRunMeter;
            System.out.printf("%s пробежал %d м. и устал, дистанцию в %d м. оставим напотом%n", getName(), limitRunMeter, restDistance);
        }
    }

    public abstract void swim(int meter);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCount() {
        return count;
    }
}
