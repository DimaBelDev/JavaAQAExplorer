package ru.dima.study.lesson_7;

import java.util.Arrays;
import java.util.regex.Pattern;

public class ArrayProcessor {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] array1 = null;

        System.out.println(processArray(array));

    }

    // Можно добавить trim для удаления пробелов
    public static int processArray(String[][] inputArray) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;

        if (inputArray == null || inputArray.length != 4 || Arrays.stream(inputArray).anyMatch(row -> row.length != 4))
            throw new MyArraySizeException();

        for (int i = 0; i < inputArray.length; i++)
            for (int j = 0; j < inputArray[i].length; j++)
                if(inputArray[i][j] != null && Pattern.matches("[0-9]+", inputArray[i][j]))
                    sum += Integer.parseInt(inputArray[i][j]);
                else
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]");
        return sum;
        }
    }