public class Main {
    public static void main(String[] args) {

        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        //tests the regular add methods
        list.add(1); //1
        list.add(2); //12
        list.add(3); //123
        list.add(4); //1234

        //tests index add methods
        list.add(4,5); //adds to the tail 12345
        list.add(2,9); //adds in the middle 129345
        System.out.println(list);

        //tests the regular remove methods
        list.remove(); //12934
        list.remove(); //1293

        //tests index remove methods
        list.remove(3);//removes the tail 129
        list.remove(1); // removes the middle of the list 19
        System.out.println(list);

        //tests the set method
        list.set(1,2); //12
        System.out.println(list);
    }
}
