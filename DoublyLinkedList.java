import java.util.Arrays;

/**
 * This class implements a doubly linked list
 *
 * @author Cardin Nguyen
 * @version 1.0, 11/3/2023
 * @see Arrays
 */
public class DoublyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    /**
     * adds an element to the tail of the linked list
     * @param element
     */
    public void add(E element) {

        Node<E> addedElement = new Node(element, null, null);
        Node<E> originalTail = tail;

        //defines head if it doesn't exist
        if (head == null) {

            head = addedElement;

        } else if (size == 1) {

            tail = addedElement;
            tail.setPrevious(head);
            head.setNext(tail);

        } else {

            //makes the current tail point to the new element
            originalTail.setNext(addedElement);

            //redefines the tail
            tail = addedElement;

            //makes the tail point correctly
            tail.setPrevious(originalTail);
            tail.setNext(null);
        }

        size++;
    }

    /**
     * adds an element at a certain index in the linked list
     *
     * @param index
     * @param element
     */

    public void add(int index, E element) {

        Node<E> addedElement = new Node(element, null, null);

        //creates a new node that starts at the head
        Node<E> previous = head;

        //counts up to the node before the indexed element
        for (int i = 0; i < index - 1; i++) {

            previous = previous.getNext();

        }

        //checks if previous itself is null
        if (previous != null) {

            //checks if the indexed element is the tail
            if (previous.getNext() != null) {

                //element that's where the index is
                Node<E> temp = previous.getNext();

                //points the previous node to added element
                previous.setNext(addedElement);

                //points indexed element to added element
                temp.setPrevious(addedElement);

                //points the added node to the rest of the list
                addedElement.setNext(temp);
                addedElement.setPrevious(previous);

                size++;

            } else {

                //uses the currently existing add method to add it to the end
                add(element);

            }

        } else {

            //uses the currently existing add method to add it to the end
            add(element);

        }
    }

    /**
     * removes the tail of the linked list
     *
     * @return the deleted element (the tail)
     */

    public E remove() {

        //checks if the list is going to be empty after remove method
        if (size == 1) {

            Node<E> deletedElement = head;

            head = null;
            tail = null;

            size--;

            return deletedElement.getValue();
        }

        //creates a new node that starts at the tail
        Node<E> deletedElement = tail;

        //makes a node that's the previous element before the tail;
        Node<E> previous = tail.getPrevious();

        //makes the original tail point to nothing
        deletedElement.setNext(null);
        deletedElement.setPrevious(null);

        //gives the previous element tail characteristics
        previous.setNext(null);
        tail = previous;

        size--;

        return deletedElement.getValue();
    }

    /**
     * sets an element in the linked list at a specific index
     *
     * @param index
     * @param element
     * @return
     */
    public E set(int index, E element) {

        //creates a new node that starts at the head
        Node<E> indexed = head;

        //counts up to the element at the indexed element
        for (int i = 0; i < index; i++) {

            indexed = indexed.getNext();

        }

        //makes a temporary node that stores the value of the indexed element
        Node<E> temp = indexed;

        //makes the indexed element the new value that's going to be set
        indexed.setValue(element);

        return temp.getValue();
    }

    /**
     * removes an element in the linked tail at a specific index
     *
     * @param index
     * @return the removed element at the index
     */
    public E remove(int index) {

        //creates a new node that starts at the head
        Node<E> previous = head;

        //counts up to the node at the indexed element
        for (int i = 0; i < index - 1; i++) {

            previous = previous.getNext();

        }

        //checks if the node after previous is null
        if (previous.getNext() != null) {

            //checks if your deleting at the end of the list
            if (previous.getNext().getNext() != null) {

                System.out.println(previous.getValue());

                //creates a new node that's after the indexed element
                Node<E> temp = previous.getNext();

                //points the previous node to the node after the indexed element
                previous.setNext(temp.getNext());

                //points the node after the indexed element to the previous node
                temp.getNext().setPrevious(previous);

                //makes the indexed element point to nothing
                temp.setNext(null);
                temp.setPrevious(null);

                size--;

                return temp.getValue();

            } else {

                //uses the existing remove method to remove from the tail
                remove();

            }

        } else {

            //uses the existing remove method to remove from the tail
            remove();
        }

        return previous.getValue();

    }

    /**
     * Turns the linked list as a readable string
     * @return the linked list as a string
     */

    public String toString() {

        Node<E> current = head;
        String[] list = new String[size];

        for (int i = 0; i < size; i++) {

            list[i] = String.valueOf(current.getValue());
            current = current.getNext();

        }

        return Arrays.toString(list);
    }
}
