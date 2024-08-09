
public class ArrayDequeTest {
    public static void get_test(ArrayDeque<Integer> adt, int element) {
        adt.addFirst(element);
        int return_val = adt.get(0);
        //int return_val = adt.getFront();
        System.out.println(return_val);
    }

    public static void AddandGetTest(LinkedListDeque<Integer> ldt, int n) {
        for (int i = 0; i < n; i++) {
            ldt.addLast(i);
        }
    }
    public static void main(String[] args) {
        LinkedListDeque<Integer> ldt = new LinkedListDeque<>();
        AddandGetTest(ldt, 10);
        System.out.println(ldt.get(4)); // 0 1 2 3 4
    }
}
