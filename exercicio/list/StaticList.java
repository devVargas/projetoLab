package exercicio.list;

public class StaticList<E> implements List<E> {
    private E[] elements;
    private int numElements;

    @SuppressWarnings("unchecked")
    public StaticList(int maxSize) {
        elements = (E[]) new Object[maxSize];
        numElements = 0;
    }

    public int contaElementos(E el) throws IllegalArgumentException {
        if(el == null) throw new IllegalArgumentException();
        return contaElementos(el, 0);
    }
    
    private int contaElementos(E el, int i) {
        if(i >= numElements) return 0;
        if(elements[i].equals(el)) return 1 + contaElementos(el, i + 1);
        return contaElementos(el, i + 1); 
    }

    public int numElements() {
        return numElements;
    }

    public boolean isEmpty() {
        return numElements == 0;
    }

    public boolean isFull() {
        return numElements == elements.length;
    }

    public void insert(E el, int pos) throws OverflowException, IndexOutOfBoundsException {
        if(isFull()) throw new OverflowException();
        if(pos < 0 || pos > numElements) throw new IndexOutOfBoundsException();

        for(int i = numElements-1; i >= pos; i--) {
            elements[i+1] = elements[i];
        }

        elements[pos] = el;
        numElements++;
    }

    public E remove(int pos) throws UnderflowException, IndexOutOfBoundsException {
        if(isEmpty()) throw new UnderflowException();
        if(pos < 0 || pos >= numElements) throw new IndexOutOfBoundsException();

        E el = elements[pos];

        for(int i = pos; i < numElements-1; i++) {
            elements[i] = elements[i+1];
        }

        elements[numElements-1] = null;
        numElements--;
        return el;
    }

    public E get(int pos) throws IndexOutOfBoundsException {
        if(pos < 0 || pos >= numElements) throw new IndexOutOfBoundsException();
        return elements[pos];
    }

    public int search(E el) {
		for (int i = 0; i < numElements; i++) {
			if (el.equals(elements[i]))
				return i;
        }
		return -1;
	}
    
}
