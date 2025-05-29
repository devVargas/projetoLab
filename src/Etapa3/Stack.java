package Etapa3;

public interface Stack<E> {
    public boolean isEmpty();
    public boolean isFull();
    public int numElements();
    public void push(E el);
    public E pop();
    public E top();
}
