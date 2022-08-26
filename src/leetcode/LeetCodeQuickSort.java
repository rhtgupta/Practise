package leetcode;

import sorting.QuickSort;

public class LeetCodeQuickSort {

    public void sort(int[] array, int start, int end) {
        if (start > end) {
            return;
        }
        int partitionId = calculatePartitionId(array, start, end);
        sort(array, start, partitionId - 1);
        sort(array, partitionId + 1, end);
    }

    public int calculatePartitionId(int[] array, int start, int end) {
        int pivot = array[end];
        int pivotIndex = start;
        for (int i = start; i < end; i++) {
            if (array[i] < pivot) {
                int temp = array[i];
                array[i] = array[pivotIndex];
                array[pivotIndex] = temp;
                pivotIndex++;
            }
        }
        int temp = array[end];
        array[end] = array[pivotIndex];
        array[pivotIndex] = temp;
        return pivotIndex;
    }

    public static void main(String[] args) {
        int A[] = new int[]{7, 2, 1, 6, 8, 5, 3, 4};
        for (int value : A) {
            System.out.print(value + " ");
        }
        LeetCodeQuickSort algo = new LeetCodeQuickSort();
        System.out.println(" ");
        algo.sort(A, 0, A.length - 1);
        for (int value : A) {
            System.out.print(value + " ");
        }
    }

}
