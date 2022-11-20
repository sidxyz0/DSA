class Node<T> {
    public T val;
    public Node<T> next;

    Node(T o) {
        this.val = o;
        this.next = null;
    }
}

class List<T> {
    private Node<T> head;
    private int length;
    private Node<T> tail;

    List() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    List(T val) {
        this.head = new Node<T>(val);
        this.tail = head;
        this.length = 1;
    }

    public void addNode(T val) {
        if (this.head != null) {
            Node<T> curr = this.head;
            Node<T> prev = null;
            while (curr != null) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = new Node<T>(val);
            this.tail = prev.next;
            this.length++;
        } else {
            this.head = new Node<T>(val);
            this.tail = head;
            this.length = 1;
        }
    }

    public void addNodeAt(int n, T val) {
        if (this.head != null) {
            if (n >= 0) {
                if (this.head != this.tail) {
                    if (n < this.length) {
                        if (n != 0) {
                            int i = 0;
                            Node<T> curr = this.head;
                            Node<T> prev = null;
                            while (curr != null && i < n) {
                                prev = curr;
                                i++;
                                curr = curr.next;
                            }
                            Node<T> a = new Node<T>(val);
                            a.next = curr;
                            prev.next = a;
                            this.length++;
                        } else {
                            Node<T> a = new Node<T>(val);
                            a.next = this.head;
                            this.head = a;
                            this.length++;
                        }

                    } else if (n == this.length) {
                        this.addNode(val);

                    } else if (n > this.length) {
                        System.out.println(
                                "Length of the linked list is smaller than provided index. Cannot insert node. ");
                    }

                } else if (this.head == this.tail) {
                    if (n == 0) {
                        Node<T> a = new Node<T>(val);
                        this.head = a;
                        this.head.next = this.tail;
                        this.length++;
                    } else if (n == 1) {
                        this.addNode(val);
                    } else {
                        System.out.println(
                                "Length of the linked list is smaller than provided index. Cannot insert node. ");
                    }

                }
            } else {
                System.out.println("Cannot insert node at negative index. ");
            }

        } else {
            if (n == 0) {
                this.addNode(val);
            } else {
                System.out.println("Length of the linked list is smaller than provided index. Cannot insert node. ");
            }

        }
    }

    public int getListLength() {
        return this.length;
    }

    public String listToString() {
        StringBuilder str = new StringBuilder();
        if (this.head != null) {
            Node<T> curr = this.head;
            int i = 0;
            while (curr != null) {
                i++;
                if (i == this.length) {
                    str.append(curr.val + "");
                } else {
                    str.append(curr.val + ", ");
                }
                curr = curr.next;
            }
            return "[" + str.toString() + "]";
        } else {
            return "List is empty. ";
        }
    }

    public void removeNode() {
        if (this.head != null) {
            if (this.head != this.tail) {
                Node<T> curr = head;
                Node<T> prev = null;
                while (curr.next != null) {
                    prev = curr;
                    curr = curr.next;
                }
                prev.next = null;
                this.tail = prev;
                this.length--;
            } else {
                this.head = null;
                this.tail = null;
                this.length = 0;
            }
        } else {
            System.out.println("Cannot remove node from an empty Linked List. ");
        }
    }

    public void removeNodeAt(int n) {
        if (this.head != null) {
            if (n < this.length - 1 && n >= 0) {
                if (this.head != this.tail) {
                    if (n != 0) {
                        Node<T> curr = head;
                        Node<T> prev = null;
                        int i = 0;
                        while (curr.next != null && i < n) {
                            prev = curr;
                            i++;
                            curr = curr.next;
                        }
                        prev.next = curr.next;
                    } else {
                        this.head = this.head.next;
                    }
                    this.length--;
                } else {
                    this.head = null;
                    this.tail = null;
                    this.length = 0;
                }
            } else if (n == this.length - 1 && n >= 0) {
                removeNode();
            } else {
                System.out.println("Provided index in invalid. Cannot remove node. ");
            }
        } else {
            System.out.println("Cannot remove node from an empty Linked List. ");
        }
    }

    public int findIndexOf(T val) {
        Node<T> curr = this.head;
        int i = 0;
        boolean found = false;
        while (curr != null && found == false) {
            if (curr.val == val) {
                found = true;
            } else {
                curr = curr.next;
                i++;
            }
        }
        if (found) {
            return i;
        } else {
            System.out.println("Value does not exist in the Linked List. ");
            return -1;
        }
    }

    public T getValueAt(int n) {
        if (this.head != null) {
            if (n >= 0 && n < this.length) {
                int i = 0;
                Node<T> curr = this.head;
                while (curr.next != null && i < n) {
                    i++;
                    curr = curr.next;
                }
                return curr.val;
            } else {
                System.out.println("No node exists at provided index. ");
                return null;
            }
        } else {
            System.out.println("Linked list i empty. ");
            return null;
        }
    }

    public void reverseIt() {
        if (this.head != null) {
            if (this.head != this.tail) {
                Node<T> prev = null;
                Node<T> curr = this.head;
                Node<T> nx = null;
                while (curr != null) {
                    nx = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = nx;
                }
                Node<T> temp = this.head;
                this.head = this.tail;
                this.tail = temp;
            }
        }

    }

    public List<T> getReverse() {
        List<T> b = new List<T>();
        if (this.head != null) {
            if (this.head != this.tail) {
                Node<T> curr = this.head;
                while (curr != null) {
                    b.addNodeAt(0, curr.val);
                    curr = curr.next;
                }
            } else {
                b.addNodeAt(0, this.head.val);
            }
        }

        return b;

    }
}

public class linkedList {
    public static void main(String args[]) {
        List<Object> a = new List<Object>("2");
        a.addNode("3");
        a.addNode("4");
        a.addNode("5");
        System.out.println("List: " + a.listToString());
        System.out.println("Length: " + a.getListLength());

        // Test Cases
        a.removeNode();
        System.out.println("List: " + a.listToString());
        System.out.println("Length: " + a.getListLength());

        a.removeNodeAt(4);
        System.out.println("List: " + a.listToString());
        System.out.println("Length: " + a.getListLength());

        a.removeNodeAt(-1);
        System.out.println("List: " + a.listToString());
        System.out.println("Length: " + a.getListLength());

        a.removeNodeAt(0);
        System.out.println("List: " + a.listToString());
        System.out.println("Length: " + a.getListLength());

        a.removeNodeAt(1);
        System.out.println("List: " + a.listToString());
        System.out.println("Length: " + a.getListLength());

        a.addNode("4");
        a.addNode("6");
        System.out.println("List: " + a.listToString());
        System.out.println("Length: " + a.getListLength());

        a.addNodeAt(0, "1");
        System.out.println("List: " + a.listToString());
        System.out.println("Length: " + a.getListLength());

        a.addNodeAt(3, "1");
        System.out.println("List: " + a.listToString());
        System.out.println("Length: " + a.getListLength());

        a.addNodeAt(5, "5");
        System.out.println("List: " + a.listToString());
        System.out.println("Length: " + a.getListLength());

        System.out.println(a.findIndexOf("6"));
        System.out.println(a.getValueAt(3));

        List<Object> c = a.getReverse();
        System.out.println(c.listToString());
        System.out.println(a.listToString());

        a.reverseIt();
        System.out.println(a.listToString());

        List<Integer> b = new List<Integer>(1);
        System.out.println(b.listToString());
        b.removeNode();
        b.reverseIt();
        System.out.println(b.listToString());
    }
}