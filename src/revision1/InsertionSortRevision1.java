package revision1;

public class InsertionSortRevision1 {

    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int hole = i;
            while (hole > 0 && array[hole - 1] > value) {
                array[hole] = array[hole - 1];
                hole--;
            }
            array[hole] = value;
        }
    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        InsertionSortRevision1 selectionSort = new InsertionSortRevision1();
        int[] array = {6, 2, 8, 9, 5, 1, 7, 3, 4};
        selectionSort.print(array);
        selectionSort.sort(array);
        System.out.println(" ");
        selectionSort.print(array);
    }

}
