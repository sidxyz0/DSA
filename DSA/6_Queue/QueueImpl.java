import java.util.ArrayList;
import java.util.Stack;

interface QueueInterface<T>{
    void enqueue(T val);
    T dequeue();
    T peek();
    int getLength();
    String queueToString();
}

class Queue<T> implements QueueInterface<T> {
    private ArrayList<T> arr;

    Queue() {
        this.arr = new ArrayList<T>();
    }

    Queue(T val) {
        this.arr = new ArrayList<T>();
        this.arr.add(val);
    }

    public void enqueue(T val) {
        this.arr.add(val);
    }

    public T dequeue() {
        T val = this.arr.get(0);
        this.arr.remove(0);
        return val;
    }

    public T peek(){
        T val = this.arr.get(0);
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

    public void reverseIt() {
        if (this.getLength() > 0) {
            Stack<T> s = new Stack<T>();
            while (this.getLength() > 0) {
                s.push(this.dequeue());
            }
            while (s.size() > 0) {
                this.enqueue(s.pop());
            }
        } else {
            System.out.println("Queue is empty. Cannot reverse. ");
        }
    }

    public Queue<T> getReverse() {
        Stack<T> s = new Stack<T>();
        Queue<T> q = new Queue<T>();
        if (this.getLength() > 0) {
            while (this.getLength() > 0) {
                s.push(this.dequeue());
            }
            while (s.size() > 0) {
                T temp = s.pop();
                this.enqueue(temp);
                q.enqueue(temp);
            }
        } else {
            System.out.println("Queue is empty. Cannot reverse. ");
        }

        return q;
    }
}

public class QueueImpl {
    public static void main(String args[]) {
        Queue<Integer> q = new Queue<Integer>(1);

        // Test cases
        q.enqueue(2);
        q.enqueue(4);
        q.enqueue(3);
        q.enqueue(5);
        System.out.println(q.queueToString());

        q.dequeue();
        System.out.println(q.queueToString());

        q.reverseIt();
        System.out.println(q.queueToString());

        System.out.println(q.getReverse().queueToString());

    }
}
