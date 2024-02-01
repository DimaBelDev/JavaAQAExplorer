package ru.dima.study.lesson_5.task_1;

public class Dog extends Animal {
    private static final int limitRunMeter = 500;
    private static final int limitSwimMeter = 10;
    private static int countOfDog = 0;


    public Dog(String name){
        super(name);
        countOfDog++;
    }

    public void run(int meter) {
           super.run(meter, limitRunMeter);
    }
    @Override
    public void swim(int meter) {
        if(meter < 0) {
            System.out.println("вы указали отрицательное число");
        } else if(limitSwimMeter >= meter) {
            System.out.printf("%s проплыл %d м.%n", super.getName(), meter);
        } else {
            int restOfDistance = meter - limitSwimMeter;
            System.out.printf("%s проплыл %d м. и устал, дустацию в %d оставим напотом%n", super.getName(), limitSwimMeter, restOfDistance);
        }

    }
    public static int getCountOfDog() {
        return countOfDog;
    }
}
