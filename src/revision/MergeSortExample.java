package revision;

import sorting.MergeSort;

public class MergeSortExample {

    public void sortExample(int[] array) {
        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int j = mid; j < array.length; j++) {
            right[j - mid] = array[j];
        }

        sortExample(left);
        sortExample(right);
        merge(left, right, array);
    }

    public void merge(int[] left, int[] right, int[] array) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int A[] = new int[]{2, 4, 1, 6, 8, 5, 3, 7};
        for (int value : A) {
            System.out.print(value + " ");
        }
        MergeSortExample algo = new MergeSortExample();
        System.out.println(" ");
        algo.sortExample(A);
        for (int value : A) {
            System.out.print(value + " ");
        }
    }

}
