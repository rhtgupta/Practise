package revision1;

public class HeapSortRevision1 {

    public void sort(int[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, i, n);
        }

        for (int i = n - 1; i >= 0; i--) {
            int tmp = array[i];
            array[i] = array[0];
            array[0] = tmp;
            heapify(array, 0, i);
        }
    }

    public void heapify(int[] array, int i, int n) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int tmp = array[largest];
            array[largest] = array[i];
            array[i] = tmp;
            heapify(array, largest, n);
        }
    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        HeapSortRevision1 selectionSort = new HeapSortRevision1();
        int[] array = {6, 2, 8, 9, 5, 1, 7, 3, 4};
        selectionSort.print(array);
        selectionSort.sort(array);
        System.out.println(" ");
        selectionSort.print(array);
    }
}
