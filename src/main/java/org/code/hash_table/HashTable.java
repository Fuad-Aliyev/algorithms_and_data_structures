package org.code.hash_table;

public class HashTable<T> {
    static final int DEFAULT_INITIAL_SIZE = 16;
    private Node<T>[] table;

    // Create a HashTable with an array size of `initialCapacity`.
    public HashTable(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("initialCapacity is of a negative number.");
        } else {
            table = new Node[initialCapacity];
        }
    }

    // Create a HashTable with an array size of `DEFAULT_INITIAL_SIZE`.
    public HashTable() {
        table = new Node[DEFAULT_INITIAL_SIZE];
    }

    // Inserts a new key-value pair into the hash table.
    public void insert(T key, T value) {
        Node<T> newNode = new Node<>(key, value);
        int possiblePosition = calculatePosition(key);
        if (table[possiblePosition] == null) { // The first position is empty
            table[possiblePosition] = newNode;
        } else {
            Node retrievedNode = table[possiblePosition];
            while (retrievedNode != null) {
                if (retrievedNode.getKey() == key) {
                    retrievedNode.setValue(value);
                    return;
                }

                if (retrievedNode.getNext() == null) {
                    retrievedNode.setNext(newNode);
                    newNode.setPrev(retrievedNode);
                    return;
                }

                retrievedNode = retrievedNode.getNext();
            }
        }
    }

    // Removes the element which contains the same 'key'.
    // Returns the Node if found, else returns `null`.
    public Node remove(T key) {
        Node<T> removedNode = getElement(key);
        Node<T> prevNode = removedNode.getPrev();
        Node<T> nextNode = removedNode.getNext();

        if (nextNode != null) {
            nextNode.setPrev(prevNode);
        }

        if (prevNode != null) {
            prevNode.setNext(nextNode);
        } else {
            int lookupPosition = calculatePosition(key);
            table[lookupPosition] = nextNode;
        }
        return removedNode;
    }

    public Node getElement(T key) {
        int lookupPosition = calculatePosition(key);
        Node<T> retrievedNode = table[lookupPosition];
        while (retrievedNode != null) {
            if (retrievedNode.getKey() == key) {
                return retrievedNode;
            } else {
                retrievedNode = retrievedNode.getNext();
            }
        }
        return null;
    }

    // Bob Jenkin's One-at-a-Time hashing function is used if we're using strings,
    // otherwise we Java's built in hash code
    private int calculatePosition(T key) {
        if (key instanceof String) {
            int h = 0;
            for (int i = 0; i < ((String)key).length(); i++) {
                h += ((String) key).charAt(0);
                h += ( h << 10 );
                h ^= ( h << 6 );
            }

            h += ( h << 3 );
            h ^= ( h >> 11 );
            h += ( h << 15 );

            return (h & 0xff) % (table.length - 1);
        } else {
            return (key.hashCode() & 0xff) % (table.length - 1);
        }
    }

    public void spill() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null)
                System.out.print(i + "\t" + table[i]);
        }
    }
}
