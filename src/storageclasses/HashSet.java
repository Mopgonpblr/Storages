package storageclasses;

import java.util.Iterator;
import java.util.Random;

public class HashSet<E> {

    private Entry<E> start;

    public void put(E object) {

        Entry<E> set = start;
        Entry<E> newEntry = new Entry<>(object);
        Random random = new Random();

        if (set == null) {
            this.start = newEntry;
        } else if (!contains(object)) {
            if (random.nextBoolean()) {
                while (set.getNext() != null) {
                    set = set.getNext();
                }
                set.setNext(newEntry);
            } else {
                newEntry.setNext(this.start);
                this.start = newEntry;
            }
        }
    }

    public boolean contains(E object) {
        Entry<E> set = find(object);
        return set != null;
    }

    private Entry<E> find(E object) {
        Entry<E> set = start;

        while (set != null) {
            if (set.getValue().hashCode() == object.hashCode()
                    && set.getValue().equals(object)) {
                return set;
            }
            set = set.getNext();
        }

        return null;
    }


    public Iterator<E> iterator() {
        return new Iterator<>() {
            Entry<E> entry = start;

            @Override
            public boolean hasNext() {
                return entry != null;
            }

            @Override
            public E next() {
                E object = entry.getValue();
                entry = entry.getNext();
                return object;
            }
        };
    }

    public void delete(E object) {
        Entry<E> set = start;
        Entry<E> previous = start;
        if (set != null) {
            do {
                if (set.getValue().hashCode() == object.hashCode()
                        && set.getValue().equals(object)) {
                    if (set == start) {
                        start = start.getNext();
                    } else if (set.getNext() == null) {
                        previous.setNext(null);
                    } else {
                        previous.setNext(set.getNext());
                    }
                    break;
                }
                previous = set;
                set = set.getNext();
            } while (set != null);
        }
    }

}


class Entry<E> {
    private E value;
    private Entry<E> next;
    private int hash;

    public Entry(E value) {
        this.value = value;
        this.hash = 31 * value.hashCode();
    }

    public E getValue() {
        return value;
    }

    public Entry<E> getNext() {
        return next;
    }

    public void setNext(Entry<E> next) {
        this.next = next;
    }

    public int getHash() {
        return hash;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}