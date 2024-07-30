public class ArrayDeque<T> {
    private T[] list;
    private int size, front, last;

    public ArrayDeque() {
        list = (T[]) new Object[1000];
        size = 0;
        front = 3;
        last = 4;
    }

    // get size of list
    public int size() {return size;}

    // check whether
    private boolean check_full() {
        if (size == list.length) {
            return true;
        } else {
            return false;
        }
    }

    private void resize(int capacity) {
        T[] newlist = (T[]) new Object[capacity];
        int j, i;

        j = 0;
        // front
        for (i = (front + 1) % list.length; i < list.length; i++) {
            newlist[j] = list[i];
            j++;
        }
        front = newlist.length - 1;

        // corner case : front/last at two ends
        if (front == list.length - 1 && last == 0) {
            list = newlist;
            last = list.length;
            return;
        }

        // back
        for (i = 0; i <= (last - 1); i++) {
            newlist[j] = list[i];
            j++;
        }

        list = newlist;
    }

    // add element at the last
    public void addLast(T element) {
        if (check_full()) { // control the growth of size
            resize(size * 2);
        }
        list[last] = element;
        last = (last + 1) % list.length;
        size++;
    }

    // add element at the front
    public void addFirst(T element) {
        if (check_full()) { // resizing
            resize(size * 2);
        }
        list[front] = element;
        front--;
        if (front < 0) {
            front = list.length - 1;
        }
        size++;
    }

    // Motivation behind using array
    public T get(int i) {
        return list[i];
    }

    public T getLast() {
        return list[size - 1];
    }

    // remove last element - delete
    public T removeLast() {
        last--;
        if (last < 0) {
            last = list.length - 1;
        }
        size--;
        return list[last];
    }
    // remove first element - delete
    public T removeFirst() {
        front = (front + 1) % list.length;
        size--;
        return list[front];
    }
    // determine if deque is empty
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void printDeque() {
        int begin_front = (front + 1) % list.length;
        int end_last = last - 1;
        if (end_last < 0) {
            end_last = list.length - 1;
        }

        int end = (begin_front < end_last)?end_last: list.length - 1;
        for (int i = begin_front; i <= end; i++) {
            System.out.println(list[i] + " ");
        }
        if (end == end_last) {
            return;
        }
        for (int i = 0; i <= end_last; i++) {
            System.out.println(list[i] + " ");
        }
    }
}

