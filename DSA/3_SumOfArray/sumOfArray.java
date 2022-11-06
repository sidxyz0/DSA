class sumArr {
    private int[] arr;

    sumArr(int[] n) {
        this.arr = n;
    }

    public int findSum() {
        int sum;
        if (this.arr.length < 1) {
            System.out.println("Provided array is empty");
            return 0;
        } else {
            sum = this.getSum(this.arr);
            return sum;
        }
    }

    private int getSum(int[] ar) {
        if (ar.length < 2) {
            return ar[0];
        } else {
            return ar[ar.length - 1] + getSum(this.getleftArr(ar));
        }
    }

    private int[] getleftArr(int[] ar) {
        if (ar.length > 1) {
            int[] a = new int[ar.length - 1];
            for (int i = 0; i < ar.length - 1; i++) {
                a[i] = ar[i];
            }
            return a;
        } else {
            return ar;
        }
    }
}

public class sumOfArray {
    public static void main(String args[]) {
        int[] n = { 10, 20, 30, 40 };
        sumArr a = new sumArr(n);
        System.out.println(a.findSum());
    }
}