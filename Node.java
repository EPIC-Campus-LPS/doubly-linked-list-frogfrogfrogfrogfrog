public class Node<E>{

    //value of the node
    private E value;

    //next node that it is pointing to
    private Node<E> next;

    //previous node that it is pointing to
    private Node<E> previous;
    public Node(E value, Node<E> previous,Node<E> next){
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    public E getValue(){
        return value;
    }

    public Node<E> getNext(){
        return next;
    }

    public Node<E> getPrevious(){
        return previous;
    }

    public void setValue(E val){
        value = val;
    }

    public void setNext(Node <E> n){
        next = n;
    }
    public void setPrevious(Node<E> p){
        previous = p;
    }
}
