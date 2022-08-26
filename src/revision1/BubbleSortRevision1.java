package revision1;

public class BubbleSortRevision1 {

    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        BubbleSortRevision1 selectionSort = new BubbleSortRevision1();
        int[] array = {6, 2, 8, 9, 5, 1, 7, 3, 4};
        selectionSort.print(array);
        selectionSort.sort(array);
        System.out.println(" ");
        selectionSort.print(array);
    }
}
