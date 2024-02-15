package ru.dima.study.lesson_10;


public class Main {


    public static void main(String[] args) {

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        Box<Apple> boxApple1 = new Box<>();
        Box<Apple> boxApple2 = new Box<>();

        Box<Orange> orangeBox1 = new Box<>();

        boxApple1.addFruits(apple1);
        boxApple1.addFruits(apple2);

        boxApple2.addFruits(apple3);

        orangeBox1.addFruits(orange1);
        orangeBox1.addFruits(orange2);

        //Weight
        System.out.println(boxApple1.getWeight());
        System.out.println(boxApple2.getWeight());
        System.out.println("-------------------");
        //Transfer
        boxApple1.transferFruits(boxApple2);
        System.out.println(boxApple1.getWeight());
        System.out.println(boxApple2.getWeight());
        System.out.println("-------------------");
        //Compare
        System.out.println(boxApple1.compare(boxApple2));

    }

}
