package revision;

import sorting.SelectionSort;

public class SelectionSortExample {

    public void sortExample(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        int A[] = new int[]{2, 7, 4, 1, 5, 3};
        for (int value : A) {
            System.out.print(value + " ");
        }
        SelectionSortExample algo = new SelectionSortExample();
        System.out.println(" ");
        algo.sortExample(A);
        for (int value : A) {
            System.out.print(value + " ");
        }
    }

}
