package Etapa3;

public interface Lista<E> {
    public void insert(E el, int pos);
    public int contaElementos(E el);
    public int numElements();
    public boolean isEmpty();
    public boolean isFull();
    public E get(int pos);
    public E remove(int pos);
}
