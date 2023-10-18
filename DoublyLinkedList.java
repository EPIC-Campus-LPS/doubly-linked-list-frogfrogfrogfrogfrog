public class DoublyLinkedList<E>{

    private Node<E> head;
    private Node<E> tail;
    public void add(E element){

        Node<E> addedElement = new Node(element, null, null);

        //defines head if it doesn't exist
        if (head == null){

            head = addedElement;

        } else {

            //makes the nodes point to the correct thing
            tail.setNext(addedElement);
            addedElement.setPrevious(tail);

        }

        //redefines the tail
        tail = addedElement;
    }

    public void add(int index, E element){

        //creates a new node that starts at the head
        Node<E> previous = head;

        //counts up to the node before the indexed element
        for (int i = 0; i < index; i++){

            previous = previous.getNext();

        }




    }

    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }


}
