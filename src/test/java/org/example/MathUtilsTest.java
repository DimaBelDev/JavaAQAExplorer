package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MathUtilsTest {


    @Test
    public void testCalculateFactorialWithValidInput(){

        int n = 5;
        long expectedFactorial = 120;

        long actualFactorial = MathUtils.calculateFactorial(n);

        Assertions.assertEquals(expectedFactorial, actualFactorial);
    }

    @Test
    void testCalculateFactorialWithZeroInput() {

        int n = 0;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.calculateFactorial(n);
        });
    }

    @Test
    void testCalculateFactorialWithNegativeInput() {

        int n = -5;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.calculateFactorial(n);
        });
    }



}
