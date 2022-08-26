package sorting;

public class QuickSelect {

    public int findKthElement(int[] array, int start, int end, int k) {
        int partitionId = getPartitionId(array, start, end);

        if (partitionId == k - 1) {
            return array[partitionId];
        } else if (partitionId < k - 1) {
            return findKthElement(array, partitionId + 1, end, k);
        } else {
            return findKthElement(array, start, partitionId - 1, k);
        }
    }

    public int getPartitionId(int[] array, int start, int end) {
        int pivot = array[end];
        int pIndex = start;

        for (int i = start; i < end - 1; i++) {
            if (array[i] <= pivot) {
                int tmp = array[i];
                array[i] = array[pIndex];
                array[pIndex] = tmp;
                pIndex++;
            }
        }
        int tmp = array[end];
        array[end] = array[pIndex];
        array[pIndex] = tmp;
        return pIndex;
    }

    public static void main(String[] args) {
        int[] array = {10, 4, 5, 8, 6, 11, 26};
        int kPosition = 2;

        System.out.println(kPosition + " largest element : " + new QuickSelect().findKthElement(array, 0, array.length - 1, kPosition));
    }

}
