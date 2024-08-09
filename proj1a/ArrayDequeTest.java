
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

    public static void Resize(ArrayDeque<Integer> adt) {
        for (int i = 0; i < 20; i++) {
            adt.addLast(i);
        }
    }

    public static void GetRemove(ArrayDeque<Integer> adt) {
        for (int i = 0; i < 20; i++) {
            int element = adt.removeFirst();
            System.out.println("Remove:" + ' ' + element + "\n");
            System.out.println("Get:" + ' ' + adt.get(2) + "\n");
        }
    }

    public static void AddFirstRemoveLast(ArrayDeque<Integer> adt) {
        for (int i = 0; i < 20; i++) {
            adt.addFirst(i);
        }
        for (int i = 0; i < 20; i++) {
            int element = adt.removeLast();
            System.out.println(element + "\n");
        }
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> adt = new ArrayDeque<>();
        AddFirstRemoveLast(adt);
    }
}
