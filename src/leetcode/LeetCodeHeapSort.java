package leetcode;

import sorting.HeapSort;

public class LeetCodeHeapSort {

    public void sort(int[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
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
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
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
        LeetCodeHeapSort heapSort = new LeetCodeHeapSort();
        heapSort.print(arr);
        System.out.println(" ");
        heapSort.sort(arr);
        heapSort.print(arr);
    }

}
