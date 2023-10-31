public class Main {
    public static void main(String[] args) {

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.set(3,120398);
        list.remove();
        System.out.println(list);

    }
}
