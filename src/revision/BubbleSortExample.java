package revision;

import sorting.BubbleSort;

public class BubbleSortExample {

    public void sortExample(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int A[] = new int[]{2, 7, 4, 1, 5, 3};
        for (int value : A) {
            System.out.print(value + " ");
        }
        BubbleSortExample algo = new BubbleSortExample();
        System.out.println(" ");
        algo.sortExample(A);
        for (int value : A) {
            System.out.print(value + " ");
        }
    }

}
