package lab2.task1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDeque<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    private void linkLast(final T e) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<T>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    private void linkFirst(final T e) {
        final Node<T> f = first;
        final Node<T> newNode = new Node<T>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    private T unlinkFirst(final Node<T> f) {
        final T element = f.data;
        final Node<T> next = f.next;
        f.data = null;
        f.next = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return element;
    }

    private T unlinkLast(final Node<T> l) {
        final T element = l.data;
        final Node<T> prev = l.prev;
        l.data = null;
        l.prev = null;
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        return element;
    }

    private T unlink(final Node<T> x) {
        final T element = x.data;
        final Node<T> next = x.next;
        final Node<T> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.data = null;
        size--;
        return element;
    }

    public T removeFirst() {
        final Node<T> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    public T removeLast() {
        final Node<T> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }

    public boolean remove(final Object o) {
        for (Node<T> x = first; x != null; x = x.next) {
            if (o.equals(x.data)) {
                unlink(x);
                return true;
            }
        }
        return false;
    }

    public void addFirst(final T e) {
        linkFirst(e);
    }

    public void addLast(final T e) {
        linkLast(e);
    }

    public T getFirst() {
        final Node<T> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.data;
    }

    public T getLast() {
        final Node<T> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.data;
    }

    private Node<T> node(final int index) {
        if (index < (size >> 1)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    public T get(final int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException();
        }
        return node(index).data;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    public int size() {
        return size;
    }

    class Itr implements Iterator<T> {
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public T next() {
            return get(index++);
        }
    }
}



