package Etapa4;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> firstNode;
    private Node<E> lastNode;

    public LinkedQueue() {
        firstNode = null;
        lastNode = null;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public boolean isFull() {
        return false;
    }

    public int numElements() {
        if(isEmpty()) {
            return 0;
        } else {
            int count = 0;
            Node<E> aux = firstNode;

            while(aux != null) {
                count++;
                aux = aux.getNext();
            } 
            return count;
        }
    }

    public void enqueue(E el) throws OverflowException {
        if (isFull()) throw new OverflowException();
        
        Node<E> newNode = new Node<E>(el);

        if(isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            lastNode.setNext(newNode);
            lastNode = newNode;
        }
    }

    public E dequeue() throws UnderflowException {
        if(isEmpty()) throw new UnderflowException();
            
        Node<E> aux = firstNode;
        E el = aux.getElement();
        firstNode = firstNode.getNext();
        aux.setNext(null);
        return el;
    }

    public E front() throws UnderflowException {
        if(isEmpty()) throw new UnderflowException();
        return firstNode.getElement();
    }

    public E back() throws UnderflowException {
        if(isEmpty()) throw new UnderflowException();
        return lastNode.getElement();
    }

    public E first() throws UnderflowException {
        if(isEmpty()) throw new UnderflowException();
        return firstNode.getElement();
    }
}
