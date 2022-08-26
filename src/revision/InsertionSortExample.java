package revision;

import sorting.InsertionSort;

public class InsertionSortExample {

    public void sortExample(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int hole = i;
            while (hole > 0 && array[hole - 1] > value) {
                array[hole] = array[hole - 1];
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
        InsertionSortExample algo = new InsertionSortExample();
        System.out.println(" ");
        algo.sortExample(A);
        for (int value : A) {
            System.out.print(value + " ");
        }
    }
}
