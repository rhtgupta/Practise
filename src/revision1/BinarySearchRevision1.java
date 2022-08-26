package revision1;

import ds.BinarySearch;

public class BinarySearchRevision1 {

    public int searchUsingIterativeApproach(int[] array, int element) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == element) {
                return mid;
            } else if (element < array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int searchUsingRecursiveApproach(int[] array, int start, int end, int element) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        int index = -1;
        if (array[mid] == element) {
            index = mid;
        } else if (element < array[mid]) {
            index = searchUsingRecursiveApproach(array, start, mid - 1, element);
        } else {
            index = searchUsingRecursiveApproach(array, mid + 1, end, element);
        }
        return index;
    }


    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50, 60};
        BinarySearchRevision1 binarySearch = new BinarySearchRevision1();
        int element = 60;
        int index1 = binarySearch.searchUsingRecursiveApproach(array, 0, array.length - 1, element);
        if (index1 == -1) {
            System.out.println("Element does not exist in array");
        } else {
            System.out.println("Element present at index :" + index1);
        }
        int index2 = binarySearch.searchUsingIterativeApproach(array, element);
        if (index2 == -1) {
            System.out.println("Element does not exist in array");
        } else {
            System.out.println("Element present at index :" + index2);
        }

    }

}
