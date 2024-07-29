public class LinkedListDeque <T> {
    /* nest class : naked linklist structure */
    private class Node<T> {
        public T element;
        public Node<T> next;
        public Node<T> prev;

        public Node() {
            this.next = null;
            this.prev = null;
        }
        public Node(T element) {
            this.element = element;
        }
    }
    private Node<T> sentinel;
    private int size;

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node<>();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public boolean isEmpty() {
        if (sentinel.prev == sentinel) {
            return true;
        } else {
            return false;
        }
    }

    /* add the element at the front of the list */
    public void addFirst(T element) {
        Node<T> newnode = new Node<>(element);
        /* First resolving 'prev' direction */
        if (this.isEmpty()) {
            sentinel.prev = newnode;
        } else {
            sentinel.next.prev = newnode;
        }
        newnode.prev = sentinel;
        /* resolving 'next' direction */
        newnode.next = sentinel.next;
        sentinel.next = newnode;

        size ++;

    }

    public void addLast(T element) {
        Node<T> org_last = sentinel.prev;
        Node<T> newnode = new Node<>(element);

        /* 'next' direction */
        org_last.next = newnode;
        newnode.next = sentinel;

        /* 'prev' direction */
        newnode.prev = org_last;
        sentinel.prev = newnode;

        size++;
    }

    public void removeFirst() {
        Node<T> firstnode = sentinel.next;

        /* next direction */
        sentinel.next = firstnode.next;
        /* prev direction */
        sentinel.next.prev = sentinel;

        size--;
    }

    /* return size of linkedlist */
    public int size() {
        return size;
    }

    /* print all elements in the list */
    public void printDeque() {
        for (Node<T> node = sentinel.next; node != sentinel; node = node.next) {
            System.out.println(node.element + " ");
        }
    }
}
