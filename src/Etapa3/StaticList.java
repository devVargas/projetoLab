package Etapa3;

public class StaticList<E> implements Lista<E> {
    private E[] elements;
    private int size;
    
    @SuppressWarnings("unchecked")
    public StaticList(int maxSize) {
        elements = (E[]) new Object[maxSize];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public void insert(E el, int pos) throws OverflowException, IndexOutOfBoundsException {
        if (isFull()) throw new OverflowException();
        if (pos < 0 || pos > size) throw new IndexOutOfBoundsException();

        for(int i = size-1; i >= pos; i--) {
            elements[i+1] = elements[i];
        }

        elements[pos] = el;
        size++;
    }

    public E remove(int pos) throws UnderflowException, IndexOutOfBoundsException {
        if (isEmpty()) throw new UnderflowException();
        if (pos < 0 || pos >= size) throw new IndexOutOfBoundsException();

        E el = elements[pos];

        for(int i = pos; i < size-1; i++) {
            elements[i] = elements[i+1];
        }

        elements[size-1] = null;
        size--;
        return el;
    }

    public E get(int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos >= size) throw new IndexOutOfBoundsException();
        return elements[pos];
    }

    public int numElements() {
        return size;
    }

    public int contaElementos(E el) throws IllegalArgumentException {
        if (el == null) throw new IllegalArgumentException();
        return contaElementosRecursivo(el, 0);
    }

    private int contaElementosRecursivo(E el, int i) {
        if (i >= size) return 0;
        if (elements[i].equals(el)) return 1 + contaElementosRecursivo(el, i+1);
        return contaElementosRecursivo(el, i+1);
    }
}
