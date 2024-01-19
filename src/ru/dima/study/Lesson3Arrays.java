package ru.dima.study;

import java.util.Arrays;

public class Lesson3Arrays {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(flipArrayElements(new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0})));
        System.out.println("----------------");
        System.out.println(Arrays.toString(fillArrayWithConsecutiveNumbers(new int[100])));
        System.out.println("----------------");
        System.out.println(Arrays.toString(multiplyNumbersLessThanSixByTwo(new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1})));
        System.out.println("----------------");
        System.out.println(Arrays.deepToString(fillDiagonal(5)));
        System.out.println("----------------");
        System.out.println(Arrays.toString(createInitializedArray(10, 3)));
    }

    static int[] flipArrayElements(int [] array) {
        for(int i = 0; i < array.length; i++)
            array[i] = (array[i]==1) ? 0 : 1;
        return array;
    }

    static int[] fillArrayWithConsecutiveNumbers(int [] array) {
        for(int i = 0, j = 1; i < array.length; i++, j++)
            array[i] = j;
        return array;
    }

    static int[] multiplyNumbersLessThanSixByTwo(int [] array) {
        for(int i = 0; i < array.length; i++)
            if(array[i] < 6)
                array[i] *= 2;
        return array;
    }

    static int[][] fillDiagonal(int size) {
        int[][] array = new int[size][size];

        for (int i = 0; i < size; i++) {
            array[i][i] = 1;
            array[i][size - 1 - i] = 1;
        }
        return array;
    }

    static int[] createInitializedArray(int len, int initialValue) {
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);
        return arr;
    }
}
