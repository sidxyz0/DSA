class LinearSearch {
    int[] arr;

    LinearSearch(int[] a) {
        this.arr = a;
    }

    public int searchFor(int a) {
        int foundIndex = -1;
        if (this.arr.length > 0) {
            for (int i = 0; i < this.arr.length; i++) {
                if (a == this.arr[i]) {
                    foundIndex = i;
                }
            }
        }
        return foundIndex;
    }
}

public class LinearSearchImpl {
    public static void main(String args[]) {
        int[] a = {1,4,3,6,7,8};
        LinearSearch arr = new LinearSearch(a);
        System.out.println(arr.searchFor(6));
    }
}
