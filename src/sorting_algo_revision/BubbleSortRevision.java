package sorting_algo_revision;

import sorting.BubbleSort;

public class BubbleSortRevision {
    public void sort(int[] array) {
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
        BubbleSortRevision algo = new BubbleSortRevision();
        System.out.println(" ");
        algo.sort(A);
        for (int value : A) {
            System.out.print(value + " ");
        }
    }

}
