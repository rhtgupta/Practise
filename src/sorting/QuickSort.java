package sorting;

public class QuickSort {

    public void quickSort(int[] A, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(A, start, end);
            quickSort(A, start, partitionIndex - 1);
            quickSort(A, partitionIndex + 1, end);
        }
    }

    public int partition(int[] A, int start, int end) {
        int pIndex = start;
        int pivotData = A[end];
        for (int i = start; i < end; i++) {
            if (A[i] <= pivotData) {
                int tmp = A[i];
                A[i] = A[pIndex];
                A[pIndex] = tmp;
                pIndex++;
            }
        }
        int tmp = A[pIndex];
        A[pIndex] = A[end];
        A[end] = tmp;
        return pIndex;
    }

    public static void main(String[] args) {
        int A[] = new int[]{7, 2, 1, 6, 8, 5, 3, 4};
        for (int value : A) {
            System.out.print(value + " ");
        }
        QuickSort algo = new QuickSort();
        System.out.println(" ");
        algo.quickSort(A, 0, A.length - 1);
        for (int value : A) {
            System.out.print(value + " ");
        }
    }
}
