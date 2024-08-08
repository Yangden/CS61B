public class LinkedListDeque<T> {
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

    private final Node<T> sentinel;
    private int size;

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node<>();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public boolean isEmpty() {
        return sentinel.prev == sentinel;
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

        size++;

    }

    public void addLast(T element) {
        Node<T> orgLast = sentinel.prev;
        Node<T> newnode = new Node<>(element);

        /* 'next' direction */
        orgLast.next = newnode;
        newnode.next = sentinel;

        /* 'prev' direction */
        newnode.prev = orgLast;
        sentinel.prev = newnode;

        size++;
    }

    public T removeFirst() {
        /* check list empty? */
        if (this.isEmpty()) {
            return null;
        }

        Node<T> firstnode = sentinel.next;

        /* next direction */
        sentinel.next = firstnode.next;
        /* prev direction */
        sentinel.next.prev = sentinel;

        size--;
        return firstnode.element;
    }

    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }

        /* get the last node */
        Node<T> lastnode = sentinel.prev;

        /* next direction */
        lastnode.prev.next = null;
        /* prev direction */
        sentinel.prev = lastnode.prev;

        size--;
        return lastnode.element;
    }

    /* return size of linkedlist */
    public int size()
    {
        return size;
    }

    /* return element at the given index */
    public T get(int index) {
        if (index > this.size() - 1 || this.isEmpty()){
            return null;
        }

        int cnt = 0;  // initial state: index position
        Node<T> node = sentinel.next;  // initial state : node
        while (cnt < index) { // reach to desired state
            node = node.next;
            cnt++;
        }

        return node.element;
    }

    /* recursive version of get() */
    public T getRecursive(int index) {
        if (this.isEmpty() || index > size - 1) {
            return null;
        }

        return recursive_call(sentinel.next, index);
    }

    /* recursive helper function for getRecursive() */
    private T recursive_call(Node<T> node, int cnt) {
        if (cnt == 0) return node.element;
        cnt--;
        return recursive_call(node.next, cnt);
    }

    /* print all elements in the list */
    public void printDeque() {
        for (Node<T> node = sentinel.next; node != sentinel; node = node.next) {
            System.out.println(node.element + " ");
        }
    }
}
