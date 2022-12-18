class BubbleSort {
    private int[] arr;

    BubbleSort(int[] a) {
        this.arr = a;
    }

    public void sort() {
        for (int i = 1; i < this.arr.length; i++) {
            int temp;
            for (int j = 0; j < this.arr.length - i; j++) {
                temp = this.arr[j];
                if (temp > this.arr[j + 1]) {
                    this.swapIndex(j, j + 1, this.arr);
                }
            }
        }
    }

    private void swapIndex(int a, int b, int[] ar) {
        int temp = ar[a];
        ar[a] = ar[b];
        ar[b] = temp;
    }

    public BubbleSort getNewSorted() {
        int[] tempArr= new int[this.arr.length];

        for(int i=0;i<this.arr.length; i++){
            tempArr[i] = this.arr[i];
        }

        for (int i = 1; i < tempArr.length; i++) {
            int temp;
            for (int j = 0; j < tempArr.length - i; j++) {
                temp = tempArr[j];
                if (temp > tempArr[j + 1]) {
                    this.swapIndex(j, j + 1, tempArr);
                }
            }
        }
        return new BubbleSort(tempArr);
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
        //abc.sort();
        BubbleSort def = abc.getNewSorted();
        System.out.println(def.toString());
        System.out.println(abc.toString());
    }
}