package Etapa3;

public class StaticStack<E> implements Stack<E> {
    private E[] elements;
    private int top;

    @SuppressWarnings("unchecked")
    public StaticStack(int maxSize) {
        elements = (E[]) new Object[maxSize];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == elements.length - 1;
    }

    public int numElements() {
        return top + 1;
    }

    public void push(E el) throws OverflowException {
        if (isFull()) throw new OverflowException();
        elements[++top] = el;
    }

    public E pop() throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();

        E el = elements[top];
        elements[top] = null;
        top--;
        return el;
    }

    public E top() throws UnderflowException {
        if (isEmpty()) throw new UnderflowException();
        return elements[top];
    }

    @Override
    public String toString() {
        return "StaticStack{" +
                "elements=" + elements +
                ", posição=" + top +
                '}';
    }
}
