package ru.dima.study.lesson_5.task_1;

public class Bowl {

    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void addFood(int amount) {
        food += amount;
        System.out.println("Добавлено еды в миску: " + amount);
    }

    public void info() {
        System.out.println("В миске осталось еды: " + food);
    }
}
