import java.util.ArrayList;

interface PriorityQueueInterface {
    void enqueue(int val);
    int dequeue();
    int peek();
    int getLength();
    String queueToString();
}

class PriorityQueue implements PriorityQueueInterface {
    private ArrayList<Integer> arr;

    PriorityQueue() {
        this.arr = new ArrayList<Integer>();
    }

    PriorityQueue(int val) {
        this.arr = new ArrayList<Integer>();
        this.arr.add(val);
    }

    public void enqueue(int val) {
        for (int i = 0; i < this.arr.size(); i++) {
            if (val <= this.arr.get(i)) {
                this.arr.add(i, val);
                break;
            } else if (i == this.arr.size() - 1 && val > this.arr.get(i)) {
                this.arr.add(val);
                break;
            }
        }

    }

    public int dequeue() {
        int val = this.arr.get(0);
        this.arr.remove(0);
        return val;
    }

    public int peek() {
        int val = this.arr.get(0);
        return val;
    }

    public int getLength() {
        return this.arr.size();
    }

    public String queueToString() {
        int n = 0;
        StringBuilder str = new StringBuilder("");
        if (this.arr.size() > 1) {
            while (n < this.arr.size()) {
                if (n == 0) {
                    str.append("[" + this.arr.get(n).toString() + ", ");
                } else if (n == this.arr.size() - 1) {
                    str.append(this.arr.get(n).toString() + "]");
                } else {
                    str.append(this.arr.get(n).toString() + ", ");
                }
                n++;
            }
        } else if (this.arr.size() == 1) {
            str.append("[" + this.arr.get(0).toString() + "]");
        }

        else {
            System.out.println("Queue is empty. ");
        }

        return str.toString();
    }

}

public class PriorityQueueImpl {
    public static void main(String args[]){
        PriorityQueue q = new PriorityQueue(9);

        // Test cases
        q.enqueue(5);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        System.out.println(q.queueToString());

        q.dequeue();
        System.out.println(q.queueToString());
    }
}
