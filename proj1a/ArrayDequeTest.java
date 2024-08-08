
public class ArrayDequeTest {
    public static void get_test(ArrayDeque<Integer> adt, int element) {
        adt.addFirst(element);
        int return_val = adt.get(0);
        //int return_val = adt.getFront();
        System.out.println(return_val);
    }

    public static void AddandGetTest(ArrayDeque<Integer> adt, int n) {
        for (int i = 0; i < n; i++) {
            adt.addLast(i);
        }
    }
    public static void main(String[] args) {
        ArrayDeque<Integer> adt = new ArrayDeque<>();
        AddandGetTest(adt, 10);
        System.out.println(adt.get(4));
    }
}
