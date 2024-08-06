
public class ArrayDequeTest {
    public static void get_test(ArrayDeque<Integer> adt, int element) {
        adt.addFirst(element);
        int return_val = adt.get(0);
        //int return_val = adt.getFront();
        System.out.println(return_val);
    }
    public static void main(String[] args) {
        ArrayDeque<Integer> adt = new ArrayDeque<>();
        get_test(adt, 0);
    }
}
