package sorting_algo_revision;

public class SelectionSortRevision {

    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minElementIndex];
            array[minElementIndex] = tmp;
        }
    }

    public static void main(String[] args) {
        int A[] = new int[]{2, 7, 4, 1, 5, 3};
        for (int value : A) {
            System.out.print(value + " ");
        }
        SelectionSortRevision algo = new SelectionSortRevision();
        System.out.println(" ");
        algo.sort(A);
        for (int value : A) {
            System.out.print(value + " ");
        }
    }

}
