class SelectionSort {
    int[] arr;

    SelectionSort(int[] a) {
        this.arr = a;
    }

    public void sort() {
        for (int i = 0; i < this.arr.length; i++) {
            int min = this.arr[i];
            int minIndex = i;
            for (int j = i + 1; j < this.arr.length; j++) {
                if (this.arr[j] < min) {
                    min = this.arr[j];
                    minIndex = j;
                }
            }
            this.swapIndex(i, minIndex, this.arr);
        }
    }

    private void swapIndex(int a, int b, int[] ar) {
        int temp = ar[a];
        ar[a] = ar[b];
        ar[b] = temp;
    }

    public SelectionSort getNewSorted(){
        int[] tempArr = new int[this.arr.length];
        for(int i=0;i<this.arr.length; i++){
            tempArr[i] = this.arr[i];
        }
        
        for (int i = 0; i < tempArr.length; i++) {
            int min = tempArr[i];
            int minIndex = i;
            for (int j = i + 1; j < tempArr.length; j++) {
                if (tempArr[j] < min) {
                    min = tempArr[j];
                    minIndex = j;
                }
            }
            this.swapIndex(i, minIndex, tempArr);
        }

        return new SelectionSort(tempArr);
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

public class SelectionSortImpl {
    public static void main(String args[]) {

        int[] a = { 2, 3, 1, 7, 9, 1, 4, 6, 5 };
        SelectionSort abc = new SelectionSort(a);
        //abc.sort();
        SelectionSort def = abc.getNewSorted();
        System.out.println(def.toString());
        System.out.println(abc.toString());
    }
}
