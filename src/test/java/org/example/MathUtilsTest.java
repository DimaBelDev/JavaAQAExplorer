package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MathUtilsTest {

    @Test
    public void testCalculateFactorialWithValidInput() {

        int n = 5;
        long expectedFactorial = 120;

        long actualFactorial = MathUtils.calculateFactorial(n);

        Assert.assertEquals(actualFactorial, expectedFactorial);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateFactorialWithZeroInput() {

        int n = 0;

        MathUtils.calculateFactorial(n);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateFactorialWithNegativeInput() {

        int n = -5;

        MathUtils.calculateFactorial(n);
    }
}
