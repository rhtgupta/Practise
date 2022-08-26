package revision1;

public class QuickSortRevision1 {

    public void sort(int[] array, int start, int end) {
        if (start > end) {
            return;
        }
        int partitionIndex = getPartitionId(array, start, end);
        sort(array, start, partitionIndex - 1);
        sort(array, partitionIndex + 1, end);
    }

    public int getPartitionId(int[] array, int start, int end) {
        int pivot = array[end];
        int pIndex = start;
        for (int i = start; i <= end; i++) {
            if (array[i] < pivot) {
                int temp = array[i];
                array[i] = array[pIndex];
                array[pIndex] = temp;
                pIndex++;
            }
        }
        int temp = array[pIndex];
        array[pIndex] = array[end];
        array[end] = temp;
        return pIndex;
    }

    public void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        QuickSortRevision1 selectionSort = new QuickSortRevision1();
        int[] array = {6, 2, 8, 9, 5, 1, 7, 3, 4};
        selectionSort.print(array);
        selectionSort.sort(array, 0, array.length - 1);
        System.out.println(" ");
        selectionSort.print(array);
    }

}
