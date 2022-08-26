package sorting;

public class MergeSortRevision1 {

    public void sort(int[] array) {
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

        sort(left);
        sort(right);
        merge(array, left, right);
    }

    private void merge(int[] array, int[] left, int[] right) {
        int k = 0;
        int i = 0;
        int j = 0;

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


    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        MergeSortRevision1 selectionSort = new MergeSortRevision1();
        int[] array = {6, 2, 8, 9, 5, 1, 7, 3, 4};
        selectionSort.print(array);
        selectionSort.sort(array);
        System.out.println(" ");
        selectionSort.print(array);
    }
}
