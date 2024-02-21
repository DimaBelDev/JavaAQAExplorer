package org.example;

public class MathUtils {


    public static long calculateFactorial(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Факториал определен только для неотрицательных целых чисел");

        long result = 1;

        for (int i = 1; i <= n; i++)
            result *= i;

        return result;
    }

}
