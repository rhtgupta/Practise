package sorting;

public class InsertionSort {

    public void sort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int value = A[i];
            int hole = i;
            while (hole > 0 && A[hole - 1] > value) {
                A[hole] = A[hole - 1];
                hole--;
            }
            A[hole] = value;
        }
    }

    public static void main(String[] args) {
        int A[] = new int[]{2, 7, 4, 1, 5, 3};
        for (int value : A) {
            System.out.print(value + " ");
        }
        InsertionSort algo = new InsertionSort();
        System.out.println(" ");
        algo.sort(A);
        for (int value : A) {
            System.out.print(value + " ");
        }
    }

}
