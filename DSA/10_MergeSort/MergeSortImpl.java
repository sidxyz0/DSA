class MergeSort {
    int[] arr;

    MergeSort(int[] a) {
        this.arr = a;
    }

    public void sort() {
        this.sortIt(this.arr);
    }

    public MergeSort getNewSorted(){
        int temp[] = new int[this.arr.length];
        for(int i=0; i<this.arr.length;i++){
            temp[i] = this.arr[i];
        }

        this.sortIt(temp);
        return new MergeSort(temp);
    }

    private void sortIt(int[] subArr) {
        int[] leftSubArr;
        int[] rightSubArr;
        if (subArr.length > 1) {
            leftSubArr = getLeftSubArr(subArr);
            rightSubArr = getRightSubArr(subArr);
            this.sortIt(leftSubArr);
            this.sortIt(rightSubArr);
            this.merge(leftSubArr, rightSubArr, subArr);
        }
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

    private void merge(int[] leftSubArr, int[] rightSubArr, int[] subArr) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftSubArr.length && j < rightSubArr.length) {
            if (leftSubArr[i] <= rightSubArr[j]) {
                subArr[k] = leftSubArr[i];
                i++;
                k++;
            } else {
                subArr[k] = rightSubArr[j];
                j++;
                k++;
            }
        }

        if (i == leftSubArr.length) {
            while (j < rightSubArr.length) {
                subArr[k] = rightSubArr[j];
                k++;
                j++;
            }
        } else if (j == rightSubArr.length) {
            while (i < leftSubArr.length) {
                subArr[k] = leftSubArr[i];
                k++;
                i++;
            }
        }
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

public class MergeSortImpl {
    public static void main(String args[]) {

        int[] a = { 2, 3, 1, 7, 9, 1, 4, 6, 5 };
        MergeSort abc = new MergeSort(a);
        //abc.sort();
        MergeSort def = abc.getNewSorted();
        System.out.println(def.toString());
        System.out.println(abc.toString());
    }
}
