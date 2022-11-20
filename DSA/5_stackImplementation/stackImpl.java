import java.util.ArrayList;

class Stack<T> {
    public T top;
    private ArrayList<T> stackArr = new ArrayList<T>();
    private int length;

    Stack() {
        this.top = null;
        this.length = 0;
    }

    Stack(T o) {
        this.put(o);
    }

    public void put(T o) {
        this.top = o;
        this.stackArr.add(o);
        this.length = this.stackArr.size();
    }

    public T pick() {
        T val;
        if (this.stackArr.size() > 1) {
            val = this.top;
            this.stackArr.remove(this.stackArr.size() - 1);
            this.top = this.stackArr.get(this.stackArr.size() - 1);
            this.length = this.stackArr.size();
        } else if (this.stackArr.size() == 1) {
            val = this.top;
            this.stackArr.remove(this.stackArr.size() - 1);
            this.top = null;
            this.length = this.stackArr.size();
        } else {
            System.out.println("Stack is empty. ");
            val = null;
        }

        return val;
    }

    public T peek() {
        if (this.stackArr.size() > 0) {
            return this.top;
        } else {
            System.out.println("Stack is empty. ");
            return null;
        }
    }

    public int getSize() {
        return this.length;
    }

    public void putAt(int n, T val) {
        Stack<T> b = new Stack<T>();
        while (this.length > n) {
            b.put(this.pick());
        }
        this.put(val);
        while (b.length > 0) {
            this.put(b.pick());
        }
    }

    public T pickAt(int n) {
        Stack<T> b = new Stack<T>();
        while (this.length > n) {
            b.put(this.pick());
        }
        T a = b.pick();
        while (b.length > 0) {
            this.put(b.pick());
        }

        return a;
    }

    public T peekAt(int n) {
        Stack<T> b = new Stack<T>();
        while (this.length > n) {
            b.put(this.pick());
        }
        T a = b.peek();
        while (b.length > 0) {
            this.put(b.pick());
        }

        return a;
    }

    public void reverseIt() {
        Stack<T> b = new Stack<T>();
        Stack<T> c = new Stack<T>();
        while (this.length > 0) {
            b.put(this.pick());
        }
        while (b.length > 0) {
            c.put(b.pick());
        }
        while (c.length > 0) {
            this.put(c.pick());
        }
    }

    public Stack<T> getReverse() {
        Stack<T> b = new Stack<T>();
        while (this.length > 0) {
            b.put(this.pick());
        }
        return b;
    }

    public String stackToString() {
        int l = this.length;
        Stack<T> b = new Stack<T>();
        StringBuilder s = new StringBuilder("");
        if (l > 1) {
            while (this.length > 0) {
                if (this.length == 1) {
                    s.insert(0,"["+this.peek());
                    // s.append("["+this.peek());
                    b.put(this.pick());
                } else {
                    s.insert(0,", " + this.peek());
                    // s.append(this.peek() + ", ");
                    b.put(this.pick());
                }
            }
            while (b.length > 0) {
                this.put(b.pick());
            }
            s.append("]");
        } else if (l == 1) {
            s.append("[" + this.peek().toString() + "]");
        } else {
            System.out.println("Stack is empty. ");
        }
        return s.toString();
    }
}

public class stackImpl {
    public static void main(String args[]) {
        Stack<Integer> a = new Stack<Integer>();

        // Test cases
        a.put(1);
        a.put(2);
        a.put(3);
        a.put(4);
        System.out.println(a.peek());
        System.out.println(a.pick());

        a.put(5);
        a.reverseIt();
        a.putAt(1, 6);
        System.out.println(a.stackToString());
        
        System.out.println(a.peekAt(2));
        System.out.println(a.pickAt(2));
        System.out.println(a.stackToString());

    }
}