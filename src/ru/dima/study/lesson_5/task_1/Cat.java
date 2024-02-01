package ru.dima.study.lesson_5.task_1;

public class Cat extends Animal {
    private static final int limitRunMeter = 200;
    private static int countOfCat = 0;
    private Bowl bowl;
    private boolean satiety = false;

    public Cat(String name){
        super(name);
        countOfCat++;
    }

    public void run(int meter) {
          super.run(meter, limitRunMeter);
    }
    @Override
    public void swim(int meter) {
        if (meter < 0) {
            System.out.println("Вы указали отрицательное значение!");
        } else {
            System.out.println("Кот не умеет плавать!");
        }
    }
    public void eat(int amountOfDesiredFood) {
        if (bowl.decreaseFood(amountOfDesiredFood)) {
            System.out.println(super.getName() + " поел и теперь сыт!");
            satiety = true;
        } else {
            System.out.println(super.getName() + " не смог поесть из пустой миски!");
        }
    }
    public static int getCountOfCat() {
        return countOfCat;
    }
    public void setBowl(Bowl bowl) {
        this.bowl = bowl;
    }
    public boolean isSatiety() {
        return satiety;
    }
}
