package revision;

public class QuickSelectRevision {

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

    public int getPartitionId(int array[], int start, int end) {
        int pivot = array[end];
        int pIndex = start;

        for (int i = start; i < end; i++) {
            if (array[i] < pivot) {
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
        int[] array = {7, 2, 1, 6, 8, 5, 3, 4};
        int kthElement = 5;
        QuickSelectRevision quickSelectRevision = new QuickSelectRevision();
        System.out.println("kth smallest element : " + quickSelectRevision.findKthElement(array, 0, array.length - 1, kthElement));

    }

}
