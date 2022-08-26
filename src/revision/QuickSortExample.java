package revision;

import sorting.QuickSort;

public class QuickSortExample {

    public void sortExample(int[] array, int start, int end) {
        if (start < end) {
            int partitionIndex = getPartitionIndex(array, start, end);
            sortExample(array, start, partitionIndex - 1);
            sortExample(array, partitionIndex + 1, end);
        }
    }

    public int getPartitionIndex(int[] array, int start, int end) {
        int pivot = array[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {
                int tmp = array[i];
                array[i] = array[pIndex];
                array[pIndex] = tmp;
                pIndex++;
            }
        }
        int tmp = array[end];
        array[end] = array[pIndex];
        array[pIndex] = tmp;
        return pIndex;
    }

    public static void main(String[] args) {
        int A[] = new int[]{7, 2, 1, 6, 8, 5, 3, 4};
        for (int value : A) {
            System.out.print(value + " ");
        }
        QuickSortExample algo = new QuickSortExample();
        System.out.println(" ");
        algo.sortExample(A, 0, A.length - 1);
        for (int value : A) {
            System.out.print(value + " ");
        }
    }

}
