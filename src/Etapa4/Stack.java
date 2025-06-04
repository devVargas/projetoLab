package Etapa4;

public interface Stack<E> {
    public boolean isEmpty();
    public boolean isFull();
    public int numElements();
    public void push(E el) throws OverflowException;
    public E pop() throws UnderflowException;
    public E top() throws UnderflowException;
}
