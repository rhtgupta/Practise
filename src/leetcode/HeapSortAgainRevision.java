package leetcode;

import revision.HeapSortExample;

import java.util.concurrent.atomic.AtomicLongArray;

public class HeapSortAgainRevision {

    public void sort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            heapify(array, i, 0);
        }
    }

    public void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (i != largest) {
            int tmp = array[largest];
            array[largest] = array[i];
            array[i] = tmp;
            heapify(array, n, largest);
        }
    }

    public void print(int arr[]) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 9, 8, 7, 6, 4, 3};
        HeapSortAgainRevision heapSort = new HeapSortAgainRevision();
        heapSort.print(arr);
        System.out.println(" ");
        heapSort.sort(arr);
        heapSort.print(arr);
    }

}
