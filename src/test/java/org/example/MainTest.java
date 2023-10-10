package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    Main main;

    private double EPS = 1e-5;

    private double[] testY = {0.03456, 0.0004, -0.3456, -0.00234, 1.23445, 0.45634};

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void testCalculateBXLow() {
        double x = 0.1;
        double expected = -0.00113;
        assertEquals(main.calculateBX(x), expected, EPS);
    }

    @Test
    void testCalculateBXMiddle() {
        double x = 0.45;
        double expected = 0.28195;
        assertEquals(main.calculateBX(x), expected, EPS);
    }


    @Test
    void testCalculateBXHigh() {
        double x = 1;
        double expected = 1.90546;
        assertEquals(main.calculateBX(x), expected, EPS);
    }


    @Test
    void testCalculateSteps() {
        double start = 0.1;
        double end = 1;
        double steps = 0.001;
        int expected = 901;
        assertEquals(main.calculateSteps(start, end, steps), expected);

    }

    @Test
    void fillYFirstIndex() {
        double start = 0.1;
        double end = 1;
        double steps = 0.001;
        int index = 0;
        double expected = -0.00113;
        double[] x = main.fillX(start, end, steps);
        double[] actual = main.fillY(x);
        assertEquals(actual[index], expected, EPS);
    }

    @Test
    void fillYSecondIndex() {
        double start = 0.1;
        double end = 1;
        double steps = 0.001;
        int index = 200;
        double expected = -0.34850;
        double[] x = main.fillX(start, end, steps);
        double[] actual = main.fillY(x);
        assertEquals(actual[index], expected, EPS);
    }

    @Test
    void fillYThirdIndex() {
        double start = 0.1;
        double end = 1;
        double steps = 0.001;
        int index = 900;
        double expected = 1.90546;
        double[] x = main.fillX(start, end, steps);
        double[] actual = main.fillY(x);
        assertEquals(actual[index], expected, EPS);
    }


    @Test
    void testFindMinValueInArray() {
        double[] minMaxValue = main.findMinMaxValueInArray(testY);
        double min = minMaxValue[0];
        double expected = -0.3456;
        assertEquals(min, expected, EPS);


    }

    @Test
    void testFindMaxValueInArray() {
        double[] minMaxValue = main.findMinMaxValueInArray(testY);
        double max = minMaxValue[1];
        double expected = 1.23445;
        assertEquals(max, expected, EPS);
    }


    @Test
    void testCalculateSumOfArrayNumber() {
        double sum = main.calculateSumOfArrayNumber(testY);
        double expected = 1.37781;
        assertEquals(sum, expected, EPS);
    }


    @Test
    void testCalculateAverageNumber() {
        double average = main.calculateAverageNumber(testY);
        double expected = 0.22963;
        assertEquals(average, expected, EPS);
    }
}
