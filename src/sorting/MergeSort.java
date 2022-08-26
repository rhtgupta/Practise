package sorting;

public class MergeSort {

    public void sort(int A[]) {

        if (A.length < 2) {
            return;
        }

        int mid = A.length / 2;
        int left[] = new int[mid];
        int right[] = new int[A.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = A[i];
        }

        for (int j = mid; j < A.length; j++) {
            right[j - mid] = A[j];
        }

        sort(left);
        sort(right);
        merge(left, right, A);

    }

    public void merge(int[] left, int[] right, int[] A) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                A[k] = left[i];
                i++;
            } else {
                A[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            A[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            A[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int A[] = new int[]{2, 4, 1, 6, 8, 5, 3, 7};
        for (int value : A) {
            System.out.print(value + " ");
        }
        MergeSort algo = new MergeSort();
        System.out.println(" ");
        algo.sort(A);
        for (int value : A) {
            System.out.print(value + " ");
        }
    }

}
