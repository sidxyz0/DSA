class BinarySearch {
    int[] arr;
    int foundIndex = -1;

    BinarySearch(int[] a) {
        this.arr = a;
    }

    private int[] getLeftSubArr(int[] subArr) {
        int[] tempArr = new int[subArr.length / 2];
        for (int i = 0; i < (tempArr.length); i++) {
            tempArr[i] = subArr[i];
        }
        return tempArr;
    }

    private int[] getRightSubArr(int[] subArr) {
        int[] tempArr = new int[subArr.length - subArr.length / 2];
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = subArr[(subArr.length / 2) + i];
        }
        return tempArr;
    }

    public int searchFor(int n) {
        this.search(this.arr, n, 0);
        int f = this.foundIndex;
        this.foundIndex = -1;
        return f;
    }

    private void search(int[] a, int n, int startingIndex) {
        if (a.length > 1) {
            int[] left = this.getLeftSubArr(a);
            int[] right = this.getRightSubArr(a);
            if (left[left.length - 1] < n) {
                this.search(right, n, startingIndex + (a.length / 2));
            } else if (left[left.length - 1] > n) {
                this.search(left, n, startingIndex);
            } else {
                foundIndex = startingIndex + left.length - 1;
            }
        } else if (a.length == 1 && a[0] == n) {
            foundIndex = startingIndex;
        }
    }
}

public class BinarySearchImpl {
    public static void main(String args[]) {

        // works only with sorted array
        int[] a = { 1, 3, 4, 6, 7, 8 };
        BinarySearch arr = new BinarySearch(a);
        System.out.println(arr.searchFor(6));
        System.out.println(arr.searchFor(4));
    }
}
