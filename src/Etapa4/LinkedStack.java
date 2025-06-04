package Etapa4;

public class LinkedStack<E> implements Stack<E> {
    private Node<E> top;
    
    public LinkedStack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public boolean isFull() {
        return false;
    }
    
    public int numElements() {
        int count =0;
        Node<E> aux = top;

        while(aux != null) {
            count++;
            aux = aux.getNext();
        }

        return count;
    }

    public void push(E el) throws OverflowException {
        if(isFull()) throw new OverflowException();

        Node<E> newNode = new Node<E>(el);
        newNode.setNext(top);
        top = newNode;
    }

    public E pop() throws UnderflowException {
        if(isEmpty()) throw new UnderflowException();

        Node<E> aux = top;
        E el = aux.getElement();
        top = top.getNext();
        aux.setNext(null);
        return el;
    }

    public E top() throws UnderflowException {
        if(isEmpty()) throw new UnderflowException();
        return top.getElement();
    }
}
