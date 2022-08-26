package ds;

public class BinarySearch {

    public int searchUsingIterativeApproach(int array[], int element) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (element == array[mid]) return mid;
            else if (element < array[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    public int searchUsingRecursiveApproach(int[] array, int element, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        int index = 0;
        if (array[mid] == element) {
            index = mid;
        } else if (element < array[mid]) {
            index = searchUsingRecursiveApproach(array, element, start, mid - 1);
        } else {
            index = searchUsingRecursiveApproach(array, element, mid + 1, end);
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 30, 50, 60, 80, 110, 130, 140, 170};
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.searchUsingIterativeApproach(array, 30);
//        int index = binarySearch.searchUsingRecursiveApproach(array, 110, 0, array.length - 1);
        if (index == -1) {
            System.out.println("Element does not exist in array");
        } else {
            System.out.println("Element present at index :" + index);
        }
    }

}
