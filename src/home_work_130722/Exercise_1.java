//Даны два целых числа x и n, напишите функцию для вычисления x^n

package home_work_130722;

import java.util.Random;

public class Exercise_1 {
    public static void main(String[] args) {
        int number = 2;
        int degree = 8;

        if (degree == 0) {
            System.out.println("The number " + number + " in 0 degree = " + 1);
            return;
        }
        numberDegreeIterative(number, degree);
        System.out.println(numberDegreeRecursion(number, degree));
        System.out.println(numberDegree(number, degree));
//        System.out.println(powerUpgrade(number, degree));
    }

//    private static int powerUpgrade(int number, int degree) {
//        int temp;
//        if (number == 0) {
//            return 1;
//        }
//        temp = powerUpgrade(number, degree / 2); // O (log n)
//        System.out.println(temp);
//        if (number % 2 == 0) {
//            return temp * temp;
//        } else {
//            return degree * temp * temp;
//        }
//    }

    private static void numberDegreeIterative(int number, int degree) { // O(n)
        int result = 1;
        for (int i = 0; i < degree; i++) {
            result *= number;
        }
        System.out.println(result);
    }

    private static int numberDegreeRecursion(int number, int degree) { // O(n)
        if (degree == 1) {
            return number;
        }
        int result = number * numberDegreeRecursion(number, degree - 1);
        return result;
    }

    private static int numberDegree(int number, int degree) { // O(log n)
        int value = (degree % 2 == 0) ? (degree / 2) : ((degree - 1) / 2);

        int result = 1;
        for (int i = 0; i < value; i++) {
            result *= number;
        }

        if (degree % 2 == 0) {
            return result * result;
        } else {
            return result * result * number;
        }
    }
}
