package sorting;

public class SelectionSort {

    public void sort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = A[i];
            A[i] = A[minIndex];
            A[minIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        int A[] = new int[]{2, 7, 4, 1, 5, 3};
        for (int value : A) {
            System.out.print(value + " ");
        }
        SelectionSort algo = new SelectionSort();
        System.out.println(" ");
        algo.sort(A);
        for (int value : A) {
            System.out.print(value + " ");
        }
    }

}
