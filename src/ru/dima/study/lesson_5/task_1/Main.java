package ru.dima.study.lesson_5.task_1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat("Бобер");
        cat.run(200);
        System.out.println("------------");
        cat.run(201);
        System.out.println("------------");
        cat.run(-1);
        System.out.println("------------");
        cat.swim(10);
        System.out.println("------------");
        cat.swim(-1);
        System.out.println("------------");

        Bowl bowl = new Bowl(30);

        Cat[] cats = new Cat[]{new Cat("Марс"), new Cat("Пушок"), new Cat("Вискас")};

        for(int i = 0; i < cats.length; i++)
            cats[i].setBowl(bowl);

        cats[0].eat(20);
        cats[1].eat(11);
        bowl.addFood(15);
        cats[2].eat(15);

        Arrays.stream(cats).forEach(a -> System.out.println(a.isSatiety()));
        System.out.println("------------");
        System.out.println("Количество котов: " + Cat.getCountOfCat());
        System.out.println("Количесвто животных: " + Animal.getCount());

        System.out.println("------------Dog------------");

        Dog dog = new Dog("Грэйд");

        dog.run(500);
        System.out.println("------------");
        dog.run(501);
        System.out.println("------------");
        dog.run(-1);
        System.out.println("------------");
        dog.swim(11);
        System.out.println("------------");
        dog.swim(-1);
        System.out.println("------------");
        dog.swim(10);
        System.out.println("------------");

        System.out.println("Количество собак: " + Dog.getCountOfDog());
        System.out.println("Количесвто животных: " + Animal.getCount());

    }
}
