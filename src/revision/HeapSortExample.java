package revision;

import sorting.HeapSort;

public class HeapSortExample {
    public void sortExample(int[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, i, n);
        }

        for (int i = n - 1; i >= 0; i--) {
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            heapify(array, 0, i);
        }
    }

    public void heapify(int[] array, int i, int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int tmp = array[i];
            array[i] = array[largest];
            array[largest] = tmp;
            heapify(array, largest, n);
        }

    }

    public void print(int arr[]) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 9, 8, 7, 6, 4, 3};
        HeapSortExample heapSort = new HeapSortExample();
        heapSort.print(arr);
        System.out.println(" ");
        heapSort.sortExample(arr);
        heapSort.print(arr);
    }
}
