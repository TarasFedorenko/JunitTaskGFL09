package org.example;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();

        double[] x = main.fillX(0.1, 1.0,0.001);
        double[] y = main.fillY(x);

        main.printMin(x,y);
        main.printMax(x,y);

    }

    public double calculateBX(double x) {
        double y;
        double b = 1.5;
        double bx = x * b;
        if (bx <= 0.45) {
            y = bx - Math.tan(bx);
        } else {
            y = bx + Math.log(bx);
        }
        return y;
    }

    public double[] fillX(double start, double end, double step) {
        int n = calculateSteps(start, end, step);
        return IntStream.range(0, n).mapToDouble(v -> start + v * step).toArray();
    }

    public double[] fillY(double[] x) {
        return Arrays.stream(x).map(this::calculateBX).toArray();
    }

    public int calculateSteps(double start, double end, double step) {
        return (int) Math.round((end - start) / step) + 1;
    }

    public double[] findMinMaxValueInArray(double[] y) {

        double min = Arrays.stream(y).min().getAsDouble();
        double max = Arrays.stream(y).max().getAsDouble();
        return new double[]{min, max};
    }

    public int[] findIndexOfMinMaxValueInArray(double[] y) {
        int minIndex = 0;
        int maxIndex = 0;
        double[] minMax = findMinMaxValueInArray(y);
        for (int i = 0; i < y.length; i++) {
            if (y[i] == minMax[0]) {
                minIndex = i;
            }
            if (y[i] == minMax[1]) {
                maxIndex = i;
            }
        }
        return new int[]{minIndex, maxIndex};
    }
    public double calculateSumOfArrayNumber(double[] y){
        double sum = 0;
        for(Double number: y){
            sum+=number;
        }
        return sum;
    }

    public double calculateAverageNumber(double[] y){
        return calculateSumOfArrayNumber(y)/y.length;
    }

    private void printMin(double[] x, double []y){
        DecimalFormat df = new DecimalFormat("#.#####");
        System.out.println("Min value of array is: " + findMinMaxValueInArray(y)[0]
                + " in index: " + findIndexOfMinMaxValueInArray(y)[0]
                + " with argument " + df.format(x[findIndexOfMinMaxValueInArray(y)[0]]));
    }
    private void printMax(double[] x, double []y){
        DecimalFormat df = new DecimalFormat("#.#####");
        System.out.println("Max value of array is: " + findMinMaxValueInArray(y)[1]
                + " in index: " + findIndexOfMinMaxValueInArray(y)[1]
                + " with argument " + df.format(x[findIndexOfMinMaxValueInArray(y)[1]]));
    }


}