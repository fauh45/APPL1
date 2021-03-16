
// ****************************************************************
// FILE: IntegerList.java
//
// Purpose: Define an IntegerList class with methods to create, fill,
// sort, and search in a list of integers.
//
// ****************************************************************

public class IntegerList {
    int[] list; // values in the list
    // ------------------------------------------------------------
    // Constructor -- takes an integer and creates a list of that
    // size. All elements default to value 0.
    // ------------------------------------------------------------

    public IntegerList(int size) {
        list = new int[size];
    }

    // ------------------------------------------------------------
    // randomize -- fills the array with randomly generated integers
    // between 1 and 100, inclusive
    // ------------------------------------------------------------
    public void randomize() {
        int max = list.length;
        for (int i = 0; i < list.length; i++)
            list[i] = (int) (Math.random() * max) + 1;
    }

    // ------------------------------------------------------------
    // fillSorted -- fills the array with sorted values
    // ------------------------------------------------------------
    public void fillSorted() {
        for (int i = 0; i < list.length; i++)
            list[i] = i + 2;
    }

    // ------------------------------------------------------------
    // print -- prints array elements with indices, one per line
    // ------------------------------------------------------------
    public String toString() {
        String s = "";
        for (int i = 0; i < list.length; i++)
            s += i + ":\t" + list[i] + "\n";
        return s;
    }

    // ------------------------------------------------------------
    // linearSearch -- takes a target value and returns the index
    // of the first occurrence of target in the list. Returns -1
    // if target does not appear in the list
    // ------------------------------------------------------------
    public int linearSearch(int target) {
        int location = -1;
        for (int i = 0; i < list.length && location == -1; i++)
            if (list[i] == target)

                location = i;
        return location;
    }

    // ------------------------------------------------------------
    // sortIncreasing -- uses selection sort
    // ------------------------------------------------------------
    public void sortIncreasing() {
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = minIndex(list, i);
            swap(list, i, minIndex);
        }
    }

    public void sortDecreasing() {
        for (int index = 1; index < list.length; index++) {
            Integer key = list[index];
            int position = index;
            // Shift larger values to the right
            while (position > 0 && key.compareTo(list[position - 1]) > 0) {
                list[position] = list[position - 1];
                position--;
            }
            list[position] = key;
        }
    }

    public void swap(int[] list, int firstIndex, int secondIndex) {
        int temp = list[firstIndex];
        list[firstIndex] = list[secondIndex];
        list[secondIndex] = temp;
    }

    public int minIndex(int[] list, int index) {
        int minIndex = index;
        for (int i = index + 1; i < list.length; i++) {
            if (list[i] < list[minIndex])
                minIndex = i;
        }

        return minIndex;
    }

    public int binarySearch(int value) {
        return binarySearchRecursive(value, 0, this.list.length - 1);
    }

    public int binarySearchRecursive(int value, int start, int end) {
        int mid = start + (end - 1) / 2;

        if (end > start) {
            return -1;
        }

        if (this.list[mid] == value)
            return mid;

        if (this.list[mid] > value)
            return binarySearchRecursive(value, start, mid - 1);
        if (this.list[mid] < value)
            return binarySearchRecursive(value, mid + 1, end);

        return -1;
    }
}