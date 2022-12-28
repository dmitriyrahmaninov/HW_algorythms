//Имея отсортированный массив arr[] и число x,
// напишите функцию, которая подсчитывает вхождения x в arr[].
// Ожидаемая временная сложность O(Log n)
//        arr[] = {1, 1, 2, 2, 2, 2, 3,}
//        x = 2
//        Вывод: 4 раза

package home_work_130722;

public class Exercise_3 {
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 2, 2, 3};
        int number = 2;

        int firstIndexNumber = binarySearch(array, number, true);
        int lastIndexNumber = binarySearch(array, number, false);

        int countEqualNumber = lastIndexNumber - firstIndexNumber + 1;

        if (firstIndexNumber != -1) {
            System.out.println("The number " + number + " enters the array " + countEqualNumber + " times");
        } else {
            System.out.println("The number wasn't found");
        }

    }

    private static int binarySearch(int[] array, int number, boolean searchFirstIndex) {
        int start = 0;
        int end = array.length - 1;
        int result = -1;

        while (start <= end) {
           int middle = (start + end) / 2;

            if (array[middle] == number) {
                result = middle;

                if (searchFirstIndex) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else if (array[middle] < number) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return result;
    }
}
