package revision1;

public class QuickSelectRevision1 {

    public int quickSelect(int[] array, int start, int end, int kthSmallest) {
        if (start > end) {
            return -1;
        }
        int partitionIndex = getPartitionIndex(array, start, end);
        if (partitionIndex == kthSmallest - 1) {
            return array[partitionIndex];
        } else if (kthSmallest - 1 > partitionIndex) {
            return quickSelect(array, partitionIndex + 1, end, kthSmallest);
        } else {
            return quickSelect(array, start, partitionIndex - 1, kthSmallest);
        }
    }

    public int getPartitionIndex(int[] array, int start, int end) {
        int pivot = array[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
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
        int[] array = {6, 2, 8, 9, 5, 1, 7, 3, 4};
        QuickSelectRevision1 quickSelect = new QuickSelectRevision1();
        quickSelect.print(array);
        System.out.println(" ");
        int kth = 3;
        System.out.println("Answer : " + quickSelect.quickSelect(array, 0, array.length - 1, kth));
    }

}
