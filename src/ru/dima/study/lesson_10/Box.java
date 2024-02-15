package ru.dima.study.lesson_10;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit>{
    private final List<T> listFruits;

    public Box(){
        this.listFruits = new ArrayList<>();
    }

    public void addFruits(T fruit) {
        listFruits.add(fruit);
    }

    public float getWeight() {
        return listFruits.stream().map(Fruit::getWeight).reduce(Float::sum).orElse(0.0f);
    }

    public boolean compare(Box<?> otherBox) {
        return this.getWeight() == otherBox.getWeight();
    }

    public void transferFruits(Box<T> otherBox) {
            otherBox.listFruits.addAll(this.listFruits);
            this.listFruits.clear();
    }



}
