package dynamic_programming;

import java.util.Arrays;

public class DynamicProgramm {
    public static void main(String[] args) {

        int num = 1200;
        int[] arr = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            if (i <= 1) {
                arr[i] = i;
            } else {
                arr[i] = -1;
            }
        }
        System.out.println(Arrays.toString(arr));

//        long timeStartRecursion = System.currentTimeMillis();
//        System.out.println(fibonacciRecursion(num));
//        long timeEndRecursion = System.currentTimeMillis();
//        long timeRecursion = timeEndRecursion - timeStartRecursion;
//        System.out.println("Время выполнения fibonacciRecursion равно: " + timeStartRecursion + " - " + timeEndRecursion + " = " + timeRecursion + "ms");

        long timeStartMemoization = System.nanoTime();
        System.out.println(fibonacciDpMemoization(num, arr));
        long timeEndMemoization = System.nanoTime();
        long timeMemoization = timeEndMemoization - timeStartMemoization;
        System.out.println("Время выполнения fibonacciMemoization равно: " + timeStartMemoization + " - " + timeEndMemoization + " = " + timeMemoization + "ms");


        long timeStartTabulation = System.nanoTime();
        System.out.println(fibonacciDpTabulation(num));
        long timeEndTabulation = System.nanoTime();
        long timeTabulation = timeEndTabulation - timeStartTabulation;
        System.out.println("Время выполнения fibonacciTabulation равно: " + timeStartTabulation + " - " + timeEndTabulation + " = " + timeTabulation + "ms");

    }


    private static int fibonacciRecursion(int num) {

        if (num <= 1) {
            return num;
        }
        return fibonacciRecursion(num - 1) + fibonacciRecursion(num - 2);
    }


    private static int fibonacciDpMemoization(int num, int[] arr) {

        if (num < 2 && num > 1) {
            return 1;
        }
        if (arr[num] != -1) {
            return arr[num];
        }

        arr[num] = fibonacciDpMemoization(num - 1, arr) + fibonacciDpMemoization(num - 2, arr);
        return arr[num];
    }

    private static int fibonacciDpTabulation(int num) {
        int[] arr = new int[num + 1];
        arr[0] = 0;
        arr[1] = 1;
        int res = 0;

        for (int index = 2; index <= num; index++) {
            arr[index] = arr[index - 2] + arr[index - 1];

            if (index == num) {
                res = arr[index];
            }
        }

        return res;
    }
}
