package ru.dima.study.lesson_9.task_1;

import java.util.Arrays;
import java.util.Random;

public class ArrayProcessor {

    public static long countEvenNumbers(int... array) {
        return Arrays.stream(array)
                .filter(a -> a % 2 == 0)
                .count();
    }

    public static int[] generationArr() {
        Random random = new Random();
        int[] randomNumberArr = new int[10];
        for(int i = 0; i < 10;i++)
            randomNumberArr[i] = random.nextInt(100);
        return randomNumberArr;
    }
}
