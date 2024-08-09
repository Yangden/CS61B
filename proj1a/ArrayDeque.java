public class ArrayDeque<T> {
    private T[] list;
    private int size, front, last;

    public ArrayDeque() {
        list = (T[]) new Object[10];
        size = 0;
        front = 3;
        last = 4;
    }

    // get size of list
    public int size() {
        return size;
    }

    // check whether
    private boolean checkFull() {
        if (size == list.length) {
            return true;
        }
        return false;
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

        // corner case : front/last at two ends
        if (front == list.length - 1 && last == 0) {
            last = list.length;
            front = newlist.length - 1;
            list = newlist;
            return;
        }

        // back
        for (i = 0; i <= (last - 1); i++) {
            newlist[j] = list[i];
            j++;
        }
        front = newlist.length - 1;
        last = list.length;
        list = newlist;
    }

    // add element at the last
    public void addLast(T element) {
        if (checkFull()) { // control the growth of size
            resize(size * 2);
        }
        list[last] = element;
        last = (last + 1) % list.length;
        size++;
    }

    // add element at the front
    public void addFirst(T element) {
        if (checkFull()) { // resizing
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
    public T get(int index) {
        if (index > size - 1) {
            return null;
        }

        int pos = (front + 1) % list.length;
        int cnt = 0;
        while (cnt < index) {
            pos++;
            if (pos == list.length) pos = 0;
            cnt++;
        }
        return list[pos];
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
        int cnt = 0;
        int pos = (front + 1) % list.length;

        while (cnt < size) {
            System.out.println(list[pos] + " ");
            pos++;
            if (pos == list.length) {
                pos = 0;
            }
            cnt++;
        }
    }

}

