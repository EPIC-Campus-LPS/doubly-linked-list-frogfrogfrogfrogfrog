import java.util.Arrays;

public class DoublyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;

    private int size = 0;

    public void add(E element) {

        Node<E> addedElement = new Node(element, null, null);

        //defines head if it doesn't exist
        if (head == null) {

            head = addedElement;

        } else if (size == 1) {

            tail = addedElement;
            tail.setPrevious(head);
            head.setNext(tail);

        } else {

            //makes the current tail point to the new element
            tail.setNext(addedElement);

            //redefines the tail
            tail = addedElement;

            //makes it point to the previous
            tail.setPrevious(tail.getPrevious());

        }

        size++;
    }

        public void add (int index, E element){

            Node<E> addedElement = new Node(element, null, null);

            //creates a new node that starts at the head
            Node<E> previous = head;

            //counts up to the node before the indexed element
            for (int i = 0; i < index-1; i++) {

                previous = previous.getNext();

            }

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
        }

        public E remove(int index) {

            //creates a new node that starts at the head
            Node<E> previous = head;

            //counts up to the node before the indexed element
            for (int i = 0; i < index - 1; i++) {

                previous = previous.getNext();

            }

            //creates a new node that's at the indexed element
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
        }

        public E remove(){



        }

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
