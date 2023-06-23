package org.code.queue.linked_list;

public class QueueImpl implements Queue {
    private static Node rear = null, front = null;
    private static int count = 0;

    @Override
    public int dequeue() {
        if (front == null) {
            System.out.println("queue is empty");
            System.exit(-1);
        }
        Node temp = front;
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        count--;
        return temp.getData();
    }

    @Override
    public void enqueue(int item) {
        Node node = new Node(item);
        if (front == null) {
            front = node;
            rear = node;
        } else {
            rear.setNext(node);
            rear = node;
        }
        count++;
    }

    @Override
    public int peek() {
        if (front == null) {
            System.out.println("queue is empty");
            System.exit(-1);
        }
        return front.getData();
    }

    @Override
    public boolean isEmpty() {
        return rear == null && front == null;
    }

    @Override
    public int size() {
        return count;
    }
}
