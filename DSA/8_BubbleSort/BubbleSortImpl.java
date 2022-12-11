class BubbleSort {
    private int[] arr;

    BubbleSort(int[] a) {
        this.arr = a;
    }

    public int[] sort() {
        for (int i = 1; i < this.arr.length; i++) {
            int temp;
            for (int j = 0; j < this.arr.length - i; j++) {
                temp = this.arr[j];
                if (temp > this.arr[j + 1]) {
                    this.swapIndex(j, j + 1);
                }
            }
        }
        return this.arr;
    }

    private void swapIndex(int a, int b) {
        int temp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = temp;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        if (this.arr.length > 1) {
            int n = 0;
            while (n < this.arr.length) {
                if (n == 0) {
                    str.append("[" + this.arr[n] + ", ");
                } else if (n == this.arr.length - 1) {
                    str.append(this.arr[n] + "]");
                }

                else {
                    str.append(this.arr[n] + ", ");
                }
                n++;
            }
        } else if (this.arr.length == 1) {
            str = str.append("[" + this.arr[0] + ']');
        }

        else {
            str = str.append("[]");
        }
        return str.toString();
    }
}

public class BubbleSortImpl {
    public static void main(String args[]) {

        int[] a = { 2, 3, 1, 7, 9, 1, 4, 6, 5 };
        BubbleSort abc = new BubbleSort(a);
        abc.sort();
        System.out.println(abc.toString());
    }
}
