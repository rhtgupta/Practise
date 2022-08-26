package sorting_algo_revision;

import sorting.InsertionSort;

public class InsertionSortRevision {

    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int hole = i;
            while (hole > 0 && array[hole - 1] > value) {
                int tmp = array[hole - 1];
                array[hole - 1] = array[hole];
                array[hole] = tmp;
                hole--;
            }
            array[hole] = value;
        }
    }

    public static void main(String[] args) {
        int A[] = new int[]{2, 7, 4, 1, 5, 3};
        for (int value : A) {
            System.out.print(value + " ");
        }
        InsertionSortRevision algo = new InsertionSortRevision();
        System.out.println(" ");
        algo.sort(A);
        for (int value : A) {
            System.out.print(value + " ");
        }
    }

}
