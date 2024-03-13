package task2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        int[] arr = {12, 34, 56, 78, 90, 23, 45, 67, 89, 10};

        MaxMinCalculator calculator1 = new MaxMinCalculator(Arrays.copyOfRange(arr, 0, arr.length / 2));
        MaxMinCalculator calculator2 = new MaxMinCalculator(Arrays.copyOfRange(arr, arr.length / 2, arr.length));

        Thread thread1 = new Thread(calculator1);
        Thread thread2 = new Thread(calculator2);
        System.out.println("Starting calculation...");
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        int min = Math.min(calculator1.getMin(), calculator2.getMin());
        int max = Math.max(calculator1.getMax(), calculator2.getMax());
        System.out.printf("Calculated. Min - %d, max - %d", min, max);
    }
}

class MaxMinCalculator implements Runnable{
    private int[] arr;
    private int min;
    private int max;
    MaxMinCalculator(int[] arr){
        this.arr = arr;
    }

    @Override
    public void run() {
        calculate();
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public void calculate(){

        if (arr.length < 0){
            return;
        }

        int currentMin = arr[0];
        int currentMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < currentMin) {
                currentMin = arr[i];
            }
            if (arr[i] > currentMax) {
                currentMax = arr[i];
            }
        }

        this.min = currentMin;
        this.max = currentMax;
    }
}