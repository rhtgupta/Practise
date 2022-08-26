package sorting_algo_revision;

import sorting.QuickSort;

public class QuickSortRevision {

    public void sort(int[] array, int start, int end) {
        if (start < end) {
            int partitionId = partitioning(array, start, end);
            sort(array, start, partitionId - 1);
            sort(array, partitionId + 1, end);
        }
    }

    public int partitioning(int[] array, int start, int end) {
        int pivot = array[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (array[i] < pivot) {
                int tmp = array[i];
                array[i] = array[pIndex];
                array[pIndex] = tmp;
                pIndex++;
            }
        }
        int tmp = array[pIndex];
        array[pIndex] = array[end];
        array[end] = tmp;
        return pIndex;
    }

    public static void main(String[] args) {
        int A[] = new int[]{7, 2, 1, 6, 8, 5, 3, 4};
        for (int value : A) {
            System.out.print(value + " ");
        }
        QuickSortRevision algo = new QuickSortRevision();
        System.out.println(" ");
        algo.sort(A, 0, A.length - 1);
        for (int value : A) {
            System.out.print(value + " ");
        }
    }

}
