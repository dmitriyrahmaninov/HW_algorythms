//Имея два отсортированных массива размера m и n соответственно,
// вам нужно найти элемент, который будет находиться на k-й позиции в конечном отсортированном массиве.
//Массив 1 - 100 112 256 349 770
//Массив 2 - 72 86 113 119 265 445 892
//к = 7
//Вывод : 256
//Окончательный отсортированный массив -
//72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
//7-й элемент этого массива равен 256.

package home_work_130722;

import java.util.Arrays;

public class Exercise_2 {
    public static void main(String[] args) {
        int[] array1 = {100, 112, 256, 349, 770};
        int[] array2 = {72, 86, 113, 119, 265, 445, 892};
        int[] array3 = new int [array1.length + array2.length];
        array3 = mergeArrays(array1, array2);
        System.out.println("The new array: " + Arrays.toString(array3));

        int position = 7;
        searchNumberByPositionInArray(array3, position);
    }

    private static void searchNumberByPositionInArray(int[] array3, int position) {
       int start = 0;
       int end = array3.length -1;
       int middle = (start + end) / 2;

        while (start <= end) {
            if (middle == position) {
                System.out.println("The " + position + " element of this array is " + array3[position - 1]);
                return;
            } else if (middle < position) {
                start = middle + 1;
            } else if (middle > position) {
                end = middle - 1;
            }
            middle = (start + end) / 2;
            }
       }

    private static int[] mergeArrays(int[] array1, int[] array2) {
        int indexArray1 = 0;
        int indexArray2 = 0;
        int array1Length = array1.length;
        int array2Length = array2.length;
        int[] array3 = new int[array1Length + array2Length];
        int indexArray3 = 0;

        while (indexArray1 < array1Length && indexArray2 < array2Length) {
            if(array1[indexArray1] < array2[indexArray2]){
                array3[indexArray3] = array1[indexArray1];
                indexArray1++;
                indexArray3++;
            } else if (array1[indexArray1] > array2[indexArray2]){
                array3[indexArray3] = array2[indexArray2];
                indexArray2++;
                indexArray3++;
            } else if (array1[indexArray1] == array2[indexArray2]){
                array3[indexArray3] = array2[indexArray2];
                indexArray2++;
                indexArray2++;
                indexArray3++;
            }
        }
        while(indexArray1 < array1Length){
            array3[indexArray3] = array1Length;
            indexArray1++;
            indexArray3++;
        }
         while(indexArray2 < array2Length){
             array3[indexArray3] = array2[indexArray2];
             indexArray2++;
             indexArray3++;
         }

        return array3;
    }
}
