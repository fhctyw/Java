package lab2.task1;

import java.util.NoSuchElementException;

public class Task1 {
    public static<T> void outIterable(final Iterable<T> iterable) {
        for(final T item : iterable) {
            System.out.println(item);
        }
        System.out.println();
    }

    public static void main(final String[] args) {
        final MyDeque<String> myDeque = new MyDeque<>();
        System.out.println("Add 2 last elements");
        myDeque.addLast("test");
        myDeque.addLast("for");

        outIterable(myDeque);

        System.out.println("Add first element");
        myDeque.addFirst("before");

        outIterable(myDeque);

        System.out.println("First element = " + myDeque.getFirst());
        System.out.println("Last element = " + myDeque.getLast());
        System.out.println();

        System.out.println("Remove \"test\"");
        myDeque.remove("test");

        outIterable(myDeque);

        System.out.println("Remove first element");
        myDeque.removeFirst();

        outIterable(myDeque);

        System.out.println("Out of range");
        try {
            System.out.println(myDeque.get(0));
            System.out.println(myDeque.get(1));
        } catch (final IndexOutOfBoundsException e) {
            System.out.println("Exception IndexOutOfBoundsException has been caught");
        }

        outIterable(myDeque);

        System.out.println("Remove 2 lasts");
        try {
            myDeque.removeLast();
            myDeque.removeLast();
        } catch (final NoSuchElementException e) {
            System.out.println("Exception NoSuchElementException has been caught");
        }

        outIterable(myDeque);
    }
}
